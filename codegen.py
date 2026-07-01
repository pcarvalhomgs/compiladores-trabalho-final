from dataclasses import dataclass, field
from llvmlite import ir

from SimplifiedJSSVisitor import SimplifiedJSSVisitor


@dataclass
class Value:
    """Valor produzido por uma expressao junto com seu tipo da linguagem."""
    value: ir.Value
    type: str
    lvalue: ir.Value | None = None


@dataclass
class Slot:
    """Entrada de escopo: guarda o ponteiro LLVM onde uma variavel vive."""
    name: str
    type: str
    ptr: ir.Value
    const: bool = False
    array_size: list[int] | None = None


@dataclass
class ClassLayout:
    """Layout LLVM de uma classe: struct, atributos e funcoes associadas."""
    name: str
    struct: ir.IdentifiedStructType
    attrs: list[tuple[str, str, list[int] | None]] = field(default_factory=list)
    attr_index: dict[str, int] = field(default_factory=dict)
    methods: dict[str, tuple[str, list[tuple[str, str]], ir.Function]] = field(default_factory=dict)
    constructor: tuple[list[tuple[str, str]], ir.Function] | None = None


class CodeGenerator(SimplifiedJSSVisitor):
    """Visitor que percorre a AST do ANTLR e emite LLVM IR com llvmlite."""

    def __init__(self):
        self.module = ir.Module(name="SimplifiedJSS")
        # Triple voltado ao WSL/Linux, onde o IR sera compilado com clang.
        self.module.triple = "x86_64-pc-linux-gnu"
        self.i32 = ir.IntType(32)
        self.i8 = ir.IntType(8)
        self.i1 = ir.IntType(1)
        self.double = ir.DoubleType()
        self.void = ir.VoidType()
        self.char_ptr = self.i8.as_pointer()
        self.scopes: list[dict[str, Slot]] = []
        self.builder: ir.IRBuilder | None = None
        self.current_function: ir.Function | None = None
        self.current_return = "void"
        self.current_class: ClassLayout | None = None
        self.classes: dict[str, ClassLayout] = {}
        self.functions: dict[str, tuple[str, list[tuple[str, str]], ir.Function]] = {}
        self.loop_stack: list[ir.Block] = []
        self.string_id = 0

        # Runtime minimo usado pelo IR gerado. As funcoes sao resolvidas pela libc
        # na etapa de linkagem feita pelo clang.
        self.printf = self.declare_vararg("printf", self.i32, [self.char_ptr])
        self.scanf = self.declare_vararg("scanf", self.i32, [self.char_ptr])
        self.malloc = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [ir.IntType(64)]),
            name="malloc",
        )
        self.sprintf = self.declare_vararg("sprintf", self.i32, [self.char_ptr, self.char_ptr])
        self.strchr = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [self.char_ptr, self.i32]),
            name="strchr",
        )
        self.strcat = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [self.char_ptr, self.char_ptr]),
            name="strcat",
        )

    def generate(self, tree):
        """Ponto de entrada: visita o programa e devolve o modulo LLVM textual."""
        self.visit(tree)
        return str(self.module)

    def declare_vararg(self, name, ret, args):
        return ir.Function(self.module, ir.FunctionType(ret, args, var_arg=True), name=name)

    # Programa e declaracoes
    def visitProgram(self, ctx):
        # A geracao tem varias passadas para permitir referencias antes da
        # definicao: classes/funcoes sao registradas antes de emitir corpos.
        for decl in ctx.topLevelDecl():
            if decl.classDecl():
                self.predeclare_class(decl.classDecl())

        for decl in ctx.topLevelDecl():
            if decl.functionDecl():
                self.predeclare_function(decl.functionDecl())

        for decl in ctx.topLevelDecl():
            if decl.classDecl():
                self.fill_class_layout(decl.classDecl())

        for decl in ctx.topLevelDecl():
            if decl.functionDecl():
                self.visit(decl.functionDecl())
            elif decl.classDecl():
                self.emit_class_methods(decl.classDecl())

        global_statements = [d.statement() for d in ctx.topLevelDecl() if d.statement()]
        has_user_main = "main" in self.functions
        if global_statements or has_user_main:
            self.emit_c_main(global_statements, has_user_main)

    def predeclare_class(self, ctx):
        """Cria o tipo identificado da struct antes de conhecer seus campos."""
        name = ctx.ID().getText()
        self.classes[name] = ClassLayout(name, self.module.context.get_identified_type(name))

    def fill_class_layout(self, ctx):
        """Preenche o corpo da struct com os atributos declarados na classe."""
        layout = self.classes[ctx.ID().getText()]
        body = []
        for member in ctx.classMember():
            if member.attributeDecl():
                attr = member.attributeDecl()
                typ = self.get_type(attr.type_())
                size = self.get_array_size(attr.type_())
                name = attr.ID().getText()
                layout.attr_index[name] = len(layout.attrs)
                layout.attrs.append((name, typ, size))
                body.append(self.llvm_type(typ, size))
        layout.struct.set_body(*body)

    def predeclare_function(self, ctx):
        """Declara assinatura LLVM da funcao para permitir chamadas recursivas."""
        name = ctx.ID().getText()
        ret = self.get_return_type(ctx.returnType())
        params = self.get_params(ctx.paramList())
        llvm_name = "jss_main" if name == "main" else name
        fn_type = ir.FunctionType(self.llvm_type(ret), [self.param_type(self.ptype(p), self.psize(p)) for p in params])
        self.functions[name] = (ret, params, ir.Function(self.module, fn_type, name=llvm_name))

    def emit_c_main(self, global_statements, has_user_main):
        """Gera o main real do C/LLVM.

        Statements globais sao executados aqui. Se a linguagem tambem declarou
        function void main(), ela vira jss_main e e chamada por este main real.
        """
        fn = ir.Function(self.module, ir.FunctionType(self.i32, []), name="main")
        block = fn.append_basic_block("entry")
        old_builder, old_fn, old_ret = self.builder, self.current_function, self.current_return
        self.builder = ir.IRBuilder(block)
        self.current_function = fn
        self.current_return = "int"
        self.push_scope()
        for stmt in global_statements:
            self.visit(stmt)
        if has_user_main:
            self.builder.call(self.functions["main"][2], [])
        if not self.builder.block.is_terminated:
            self.builder.ret(self.i32(0))
        self.pop_scope()
        self.builder, self.current_function, self.current_return = old_builder, old_fn, old_ret

    def visitFunctionDecl(self, ctx):
        name = ctx.ID().getText()
        ret, params, fn = self.functions[name]
        self.emit_function_body(fn, ret, params, ctx.block())

    def emit_class_methods(self, ctx):
        """Emite constructor e metodos como funcoes livres com this explicito."""
        layout = self.classes[ctx.ID().getText()]
        old_class = self.current_class
        self.current_class = layout
        for member in ctx.classMember():
            if member.constructorDecl():
                c = member.constructorDecl()
                params = self.get_params(c.paramList())
                fn_type = ir.FunctionType(self.void, [layout.struct.as_pointer()] + [self.param_type(self.ptype(p), self.psize(p)) for p in params])
                fn = ir.Function(self.module, fn_type, name=f"{layout.name}_constructor")
                layout.constructor = (params, fn)
                self.emit_function_body(fn, "void", [("this", "this")] + params, c.block(), is_method=True)
            elif member.methodDecl():
                m = member.methodDecl()
                ret = self.get_return_type(m.returnType())
                params = self.get_params(m.paramList())
                fn_type = ir.FunctionType(self.llvm_type(ret), [layout.struct.as_pointer()] + [self.param_type(self.ptype(p), self.psize(p)) for p in params])
                fn = ir.Function(self.module, fn_type, name=f"{layout.name}_{m.ID().getText()}")
                layout.methods[m.ID().getText()] = (ret, params, fn)
                self.emit_function_body(fn, ret, [("this", "this")] + params, m.block(), is_method=True)
        self.current_class = old_class

    def emit_function_body(self, fn, ret, params, block_ctx, is_method=False):
        """Emite corpo de funcao criando escopo, slots de parametros e retorno."""
        if fn.blocks:
            return
        old_builder, old_fn, old_ret = self.builder, self.current_function, self.current_return
        block = fn.append_basic_block("entry")
        self.builder = ir.IRBuilder(block)
        self.current_function = fn
        self.current_return = ret
        self.push_scope()
        for arg, param in zip(fn.args, params):
            pname, ptype = (param[0], self.current_class.name) if param[0] == "this" else (self.pname(param), self.ptype(param))
            arg.name = pname
            # Arrays, objetos e this ja chegam como ponteiros; primitivos ganham
            # alloca local para unificar leitura/escrita com variaveis comuns.
            if param[0] == "this" or self.is_array(ptype) or ptype in self.classes:
                self.scopes[-1][pname] = Slot(pname, ptype, arg, array_size=self.psize(param))
            else:
                ptr = self.builder.alloca(self.llvm_type(ptype), name=pname)
                self.builder.store(arg, ptr)
                self.scopes[-1][pname] = Slot(pname, ptype, ptr)
        self.visit_block_statements(block_ctx)
        if not self.builder.block.is_terminated:
            if ret == "void":
                self.builder.ret_void()
            else:
                self.builder.ret(self.default_value(ret))
        self.pop_scope()
        self.builder, self.current_function, self.current_return = old_builder, old_fn, old_ret

    # Comandos
    def visitBlock(self, ctx):
        self.push_scope()
        self.visit_block_statements(ctx)
        self.pop_scope()

    def visit_block_statements(self, ctx):
        # Depois de return/break nao ha bloco atual valido para continuar emitindo.
        for stmt in ctx.statement():
            if self.builder.block.is_terminated:
                break
            self.visit(stmt)

    def visitStatement(self, ctx):
        return self.visitChildren(ctx)

    def visitVarDecl(self, ctx):
        self.emit_var_decl(ctx.type_(), ctx.declaratorList().declarator(), False)

    def visitConstDecl(self, ctx):
        self.emit_var_decl(ctx.type_(), ctx.constDeclaratorList().constDeclarator(), True)

    def visitVarDeclNoSemi(self, ctx):
        self.emit_var_decl(ctx.type_(), ctx.declaratorList().declarator(), False)

    def emit_var_decl(self, type_ctx, decls, const):
        """Aloca variaveis locais e grava inicializadores quando existirem."""
        typ = self.get_type(type_ctx)
        size = self.get_array_size(type_ctx)
        for decl in decls:
            name = decl.ID().getText()
            if typ in self.classes:
                ptr = self.builder.alloca(self.llvm_type(typ), name=name)
            elif self.is_array(typ):
                ptr = self.builder.alloca(self.llvm_type(typ, size), name=name)
            else:
                ptr = self.builder.alloca(self.llvm_type(typ), name=name)
                self.builder.store(self.default_value(typ), ptr)
            self.scopes[-1][name] = Slot(name, typ, ptr, const, size)
            if decl.expr():
                # Literais de array precisam copiar elemento a elemento; o resto
                # vira valor escalar/ponteiro e pode ser armazenado diretamente.
                array_literal = self.direct_array_literal(decl.expr())
                if self.is_array(typ) and array_literal:
                    self.init_array_literal(ptr, typ, size, array_literal)
                else:
                    val = self.cast_if_needed(self.visit(decl.expr()), typ)
                    self.builder.store(val.value, ptr)

    def visitExprStmt(self, ctx):
        return self.visit(ctx.expr())

    def visitReturnStmt(self, ctx):
        if self.current_return == "void":
            self.builder.ret_void()
        else:
            value = self.cast_if_needed(self.visit(ctx.expr()), self.current_return)
            self.builder.ret(value.value)

    def visitBreakStmt(self, ctx):
        self.builder.branch(self.loop_stack[-1])

    def visitIfStmt(self, ctx):
        # Cadeias if/else-if sao emitidas como uma sequencia de testes que pulam
        # para o proximo teste ou para o bloco final comum.
        after = self.current_function.append_basic_block("ifend")
        branches = [(ctx.expr(), ctx.block())] + [(e.expr(), e.block()) for e in ctx.elseIfPart()]
        for cond_ctx, block_ctx in branches:
            then_bb = self.current_function.append_basic_block("ifthen")
            next_bb = self.current_function.append_basic_block("ifnext")
            cond = self.bool_value(self.visit(cond_ctx))
            self.builder.cbranch(cond, then_bb, next_bb)
            self.builder.position_at_end(then_bb)
            self.visit(block_ctx)
            if not self.builder.block.is_terminated:
                self.builder.branch(after)
            self.builder.position_at_end(next_bb)
        if ctx.elsePart():
            self.visit(ctx.elsePart().block())
        if not self.builder.block.is_terminated:
            self.builder.branch(after)
        self.builder.position_at_end(after)

    def visitWhileStmt(self, ctx):
        # Forma canonica: condicao -> corpo -> volta para condicao -> saida.
        cond_bb = self.current_function.append_basic_block("while.cond")
        body_bb = self.current_function.append_basic_block("while.body")
        end_bb = self.current_function.append_basic_block("while.end")
        self.builder.branch(cond_bb)
        self.builder.position_at_end(cond_bb)
        self.builder.cbranch(self.bool_value(self.visit(ctx.expr())), body_bb, end_bb)
        self.builder.position_at_end(body_bb)
        self.loop_stack.append(end_bb)
        self.visit(ctx.block())
        self.loop_stack.pop()
        if not self.builder.block.is_terminated:
            self.builder.branch(cond_bb)
        self.builder.position_at_end(end_bb)

    def visitForStmt(self, ctx):
        # O for ganha escopo proprio para o inicializador e quatro blocos:
        # condicao, corpo, passo e fim.
        self.push_scope()
        if ctx.forInit():
            self.visit(ctx.forInit())
        exprs = ctx.expr()
        cond_bb = self.current_function.append_basic_block("for.cond")
        body_bb = self.current_function.append_basic_block("for.body")
        step_bb = self.current_function.append_basic_block("for.step")
        end_bb = self.current_function.append_basic_block("for.end")
        self.builder.branch(cond_bb)
        self.builder.position_at_end(cond_bb)
        cond = self.i1(1) if len(exprs) == 0 else self.bool_value(self.visit(exprs[0]))
        self.builder.cbranch(cond, body_bb, end_bb)
        self.builder.position_at_end(body_bb)
        self.loop_stack.append(end_bb)
        self.visit(ctx.block())
        self.loop_stack.pop()
        if not self.builder.block.is_terminated:
            self.builder.branch(step_bb)
        self.builder.position_at_end(step_bb)
        if len(exprs) >= 2:
            self.visit(exprs[1])
        if not self.builder.block.is_terminated:
            self.builder.branch(cond_bb)
        self.builder.position_at_end(end_bb)
        self.pop_scope()

    def visitForInit(self, ctx):
        if ctx.varDeclNoSemi():
            return self.visit(ctx.varDeclNoSemi())
        return self.visit(ctx.expr())

    def visitConsoleLogStmt(self, ctx):
        # console.log aceita argumentos heterogeneos; cada um escolhe seu formato.
        if ctx.argumentList():
            for expr in ctx.argumentList().expr():
                val = self.visit(expr)
                self.emit_print_value(val)
                self.emit_print_cstr(self.string_const(" "))
        self.emit_print_cstr(self.string_const("\n"))

    def visitInputStmt(self, ctx):
        # input escreve diretamente no lvalue; strings recebem buffer dinamico.
        if not ctx.assignableList():
            return
        for assign in ctx.assignableList().assignable():
            slot = self.assignable_ptr(assign)
            if slot.type == "int":
                self.builder.call(self.scanf, [self.string_const("%d"), slot.ptr])
            elif slot.type == "real":
                self.builder.call(self.scanf, [self.string_const("%lf"), slot.ptr])
            elif slot.type == "str":
                buf = self.builder.call(self.malloc, [ir.IntType(64)(4096)])
                self.builder.call(self.scanf, [self.string_const("%4095s"), buf])
                self.builder.store(buf, slot.ptr)

    # Expressoes
    def visitExpr(self, ctx):
        return self.visit(ctx.assignment())

    def visitAssignment(self, ctx):
        # Atribuicao precisa do endereco do alvo. Operadores compostos leem o
        # valor atual, aplicam a operacao e armazenam de volta.
        if ctx.assignable():
            lhs = self.assignable_ptr(ctx.assignable())
            rhs = self.cast_if_needed(self.visit(ctx.assignment()), lhs.type)
            op = ctx.assignOp().getText()
            if op != "=":
                cur = self.load_slot(lhs)
                rhs = self.binary(cur, rhs, op[0])
            self.builder.store(rhs.value, lhs.ptr)
            return Value(rhs.value, lhs.type, lhs.ptr)
        return self.visit(ctx.logicalOr())

    def visitLogicalOr(self, ctx):
        vals = [self.visit(x) for x in ctx.logicalAnd()]
        out = vals[0]
        for right in vals[1:]:
            out = Value(self.builder.or_(self.bool_value(out), self.bool_value(right)), "bool")
        return out

    def visitLogicalAnd(self, ctx):
        vals = [self.visit(x) for x in ctx.equality()]
        out = vals[0]
        for right in vals[1:]:
            out = Value(self.builder.and_(self.bool_value(out), self.bool_value(right)), "bool")
        return out

    def visitEquality(self, ctx):
        items = ctx.relational()
        out = self.visit(items[0])
        for i in range(1, len(items)):
            op = ctx.getChild(2 * i - 1).getText()
            out = self.compare(out, self.visit(items[i]), op)
        return out

    def visitRelational(self, ctx):
        items = ctx.additive()
        out = self.visit(items[0])
        for i in range(1, len(items)):
            op = ctx.getChild(2 * i - 1).getText()
            out = self.compare(out, self.visit(items[i]), op)
        return out

    def visitAdditive(self, ctx):
        items = ctx.multiplicative()
        out = self.visit(items[0])
        for i in range(1, len(items)):
            out = self.binary(out, self.visit(items[i]), ctx.getChild(2 * i - 1).getText())
        return out

    def visitMultiplicative(self, ctx):
        items = ctx.power()
        out = self.visit(items[0])
        for i in range(1, len(items)):
            out = self.binary(out, self.visit(items[i]), ctx.getChild(2 * i - 1).getText())
        return out

    def visitPower(self, ctx):
        # A gramatica torna ** associativo a direita; por isso visitamos ctx.power().
        left = self.visit(ctx.unary())
        if ctx.power():
            right = self.visit(ctx.power())
            return self.int_power(
                self.cast_if_needed(left, "int").value,
                self.cast_if_needed(right, "int").value,
            )
        return left

    def int_power(self, base, exponent):
        """Gera potencia inteira inline, evitando dependencia externa de libm/pow."""
        result_ptr = self.builder.alloca(self.i32, name="pow.result")
        base_ptr = self.builder.alloca(self.i32, name="pow.base")
        exp_ptr = self.builder.alloca(self.i32, name="pow.exp")
        self.builder.store(self.i32(1), result_ptr)
        self.builder.store(base, base_ptr)
        self.builder.store(exponent, exp_ptr)

        cond_bb = self.current_function.append_basic_block("pow.cond")
        body_bb = self.current_function.append_basic_block("pow.body")
        end_bb = self.current_function.append_basic_block("pow.end")

        self.builder.branch(cond_bb)
        self.builder.position_at_end(cond_bb)
        exp = self.builder.load(exp_ptr)
        self.builder.cbranch(self.builder.icmp_signed(">", exp, self.i32(0)), body_bb, end_bb)

        self.builder.position_at_end(body_bb)
        result = self.builder.load(result_ptr)
        current_base = self.builder.load(base_ptr)
        self.builder.store(self.builder.mul(result, current_base), result_ptr)
        self.builder.store(self.builder.sub(exp, self.i32(1)), exp_ptr)
        self.builder.branch(cond_bb)

        self.builder.position_at_end(end_bb)
        return Value(self.builder.load(result_ptr), "int")

    def visitUnary(self, ctx):
        if ctx.postfix():
            return self.visit(ctx.postfix())
        op = ctx.getChild(0).getText()
        val = self.visit(ctx.unary())
        if op == "!":
            return Value(self.builder.not_(self.bool_value(val)), "bool")
        if op == "-":
            z = self.default_value(val.type)
            return Value(self.builder.fsub(z, val.value) if val.type == "real" else self.builder.sub(z, val.value), val.type)
        if op == "+":
            return val
        if op in ("++", "--"):
            # Prefixado retorna o valor novo apos atualizar o lvalue.
            target = self.assignable_ptr(ctx.unary().postfix().primary().assignable())
            cur = self.load_slot(target)
            one = Value(ir.Constant(self.llvm_type(target.type), 1), target.type)
            new = self.binary(cur, one, "+" if op == "++" else "-")
            self.builder.store(new.value, target.ptr)
            return new

    def visitPostfix(self, ctx):
        val = self.visit(ctx.primary())
        if ctx.INC() or ctx.DEC():
            # Pos-fixado atualiza o lvalue, mas o valor da expressao e o antigo.
            target = self.assignable_ptr(ctx.primary().assignable())
            old = self.load_slot(target)
            one = Value(ir.Constant(self.llvm_type(target.type), 1), target.type)
            new = self.binary(old, one, "+" if ctx.INC() else "-")
            self.builder.store(new.value, target.ptr)
            return old
        return val

    def visitPrimary(self, ctx):
        if ctx.literal():
            return self.visit(ctx.literal())
        if ctx.assignable():
            return self.load_slot(self.assignable_ptr(ctx.assignable()))
        if ctx.expr():
            return self.visit(ctx.expr())
        if ctx.functionCall():
            return self.visit(ctx.functionCall())
        if ctx.methodCall():
            return self.visit(ctx.methodCall())
        if ctx.castCall():
            return self.visit(ctx.castCall())
        if ctx.newObject():
            return self.visit(ctx.newObject())
        if ctx.arrayLiteral():
            return Value(ir.Constant(self.i32, 0), "arrayliteral")

    def visitLiteral(self, ctx):
        text = ctx.getText()
        if text == "true":
            return Value(self.i1(1), "bool")
        if text == "false":
            return Value(self.i1(0), "bool")
        if text == "null":
            return Value(ir.Constant(self.char_ptr, None), "null")
        if text.startswith('"'):
            return Value(self.string_const(self.unescape(text[1:-1])), "str")
        if "." in text or "e" in text.lower():
            return Value(ir.Constant(self.double, float(text)), "real")
        return Value(self.i32(int(text)), "int")

    def visitFunctionCall(self, ctx):
        name = ctx.ID().getText()
        ret, params, fn = self.functions[name]
        args = self.call_args(ctx.argumentList(), params)
        result = self.builder.call(fn, args)
        return Value(result, ret)

    def visitMethodCall(self, ctx):
        receiver = self.method_receiver(ctx.methodReceiver())
        layout = self.classes[receiver.type]
        ret, params, fn = layout.methods[ctx.ID().getText()]
        args = [receiver.value] + self.call_args(ctx.argumentList(), params)
        result = self.builder.call(fn, args)
        return Value(result, ret)

    def visitNewObject(self, ctx):
        # Objetos sao alocados com malloc e tratados como ponteiro para struct.
        layout = self.classes[ctx.ID().getText()]
        size = self.sizeof(layout.struct)
        raw = self.builder.call(self.malloc, [size])
        obj = self.builder.bitcast(raw, layout.struct.as_pointer())
        if layout.constructor:
            params, fn = layout.constructor
            self.builder.call(fn, [obj] + self.call_args(ctx.argumentList(), params))
        return Value(obj, layout.name)

    def visitCastCall(self, ctx):
        return self.cast_if_needed(self.visit(ctx.expr()), ctx.primitiveType().getText())

    # Auxiliares de valores
    def binary(self, left, right, op):
        """Emite operacoes binarias, promovendo int para real quando necessario."""
        if op == "+" and (left.type == "str" or right.type == "str"):
            return self.concat(self.cast_if_needed(left, "str"), self.cast_if_needed(right, "str"))
        typ = "real" if left.type == "real" or right.type == "real" else "int"
        left = self.cast_if_needed(left, typ)
        right = self.cast_if_needed(right, typ)
        if typ == "real":
            ops = {"+": self.builder.fadd, "-": self.builder.fsub, "*": self.builder.fmul, "/": self.builder.fdiv}
            return Value(ops[op](left.value, right.value), "real")
        ops = {"+": self.builder.add, "-": self.builder.sub, "*": self.builder.mul, "/": self.builder.sdiv, "%": self.builder.srem}
        return Value(ops[op](left.value, right.value), "int")

    def compare(self, left, right, op):
        """Compara inteiros/bools com icmp e reais com fcmp."""
        typ = "real" if left.type == "real" or right.type == "real" else left.type
        left = self.cast_if_needed(left, typ)
        right = self.cast_if_needed(right, typ)
        if typ == "real":
            pred = {"==": "==", "!=": "!=", ">": ">", ">=": ">=", "<": "<", "<=": "<="}[op]
            return Value(self.builder.fcmp_ordered(pred, left.value, right.value), "bool")
        pred = {"==": "==", "!=": "!=", ">": ">", ">=": ">=", "<": "<", "<=": "<="}[op]
        return Value(self.builder.icmp_signed(pred, left.value, right.value), "bool")

    def cast_if_needed(self, val, target):
        """Aplica casts implicitos usados pelo codegen apos checagem semantica."""
        if val.type == target:
            return val
        if target == "real" and val.type == "int":
            return Value(self.builder.sitofp(val.value, self.double), "real")
        if target == "int" and val.type == "real":
            return Value(self.builder.fptosi(val.value, self.i32), "int")
        if target == "int" and val.type == "bool":
            return Value(self.builder.zext(val.value, self.i32), "int")
        if target == "bool":
            if val.type == "int":
                return Value(self.builder.icmp_signed("!=", val.value, self.i32(0)), "bool")
            if val.type == "real":
                return Value(self.builder.fcmp_ordered("!=", val.value, ir.Constant(self.double, 0.0)), "bool")
        if target == "str":
            return self.to_string(val)
        return val

    def bool_value(self, val):
        """Normaliza qualquer valor aceito em condicao para i1."""
        return self.cast_if_needed(val, "bool").value if val.type != "bool" else val.value

    def to_string(self, val):
        """Converte valores para char* para concatenacao, cast str() e log."""
        if val.type == "str":
            return val
        if val.type == "real":
            return self.real_to_string(val.value)
        if val.type == "bool":
            return self.bool_to_string(val.value)
        buf = self.builder.call(self.malloc, [ir.IntType(64)(128)])
        fmt = {"int": "%d"}.get(val.type, "%p")
        self.builder.call(self.sprintf, [buf, self.string_const(fmt), val.value])
        return Value(buf, "str")

    def bool_to_string(self, value):
        """Representacao textual esperada pela linguagem: true/false."""
        text = self.builder.select(value, self.string_const("true"), self.string_const("false"))
        return Value(text, "str")

    def real_to_string(self, value):
        """Formata real sem zeros sobrando, mas preservando .0 em inteiros."""
        buf = self.builder.call(self.malloc, [ir.IntType(64)(128)])
        self.builder.call(self.sprintf, [buf, self.string_const("%.15g"), value])

        null = ir.Constant(self.char_ptr, None)
        has_dot = self.builder.icmp_unsigned(
            "!=",
            self.builder.call(self.strchr, [buf, self.i32(ord("."))]),
            null,
        )
        has_lower_exp = self.builder.icmp_unsigned(
            "!=",
            self.builder.call(self.strchr, [buf, self.i32(ord("e"))]),
            null,
        )
        has_upper_exp = self.builder.icmp_unsigned(
            "!=",
            self.builder.call(self.strchr, [buf, self.i32(ord("E"))]),
            null,
        )
        has_decimal_marker = self.builder.or_(has_dot, self.builder.or_(has_lower_exp, has_upper_exp))

        append_bb = self.current_function.append_basic_block("real.append_decimal")
        end_bb = self.current_function.append_basic_block("real.format_end")
        self.builder.cbranch(has_decimal_marker, end_bb, append_bb)

        self.builder.position_at_end(append_bb)
        self.builder.call(self.strcat, [buf, self.string_const(".0")])
        self.builder.branch(end_bb)

        self.builder.position_at_end(end_bb)
        return Value(buf, "str")

    def concat(self, left, right):
        """Concatena strings em um buffer novo."""
        buf = self.builder.call(self.malloc, [ir.IntType(64)(4096)])
        self.builder.call(self.sprintf, [buf, self.string_const("%s%s"), left.value, right.value])
        return Value(buf, "str")

    def emit_print_value(self, val):
        """Emite printf adequado ao tipo da linguagem."""
        if val.type == "str":
            self.emit_print_cstr(val.value)
        elif val.type == "int":
            self.builder.call(self.printf, [self.string_const("%d"), val.value])
        elif val.type == "real":
            self.emit_print_cstr(self.real_to_string(val.value).value)
        elif val.type == "bool":
            self.emit_print_cstr(self.bool_to_string(val.value).value)
        else:
            self.builder.call(self.printf, [self.string_const("%p"), val.value])

    def emit_print_cstr(self, cstr):
        self.builder.call(self.printf, [self.string_const("%s"), cstr])

    # Lvalues
    def assignable_ptr(self, ctx):
        """Resolve ID/this, indices e atributos ate chegar no endereco final."""
        base = ctx.assignableBase()
        if base.THIS():
            slot = self.resolve("this")
        else:
            slot = self.resolve(base.ID().getText())
        ptr, typ, size = slot.ptr, slot.type, slot.array_size
        for suffix in ctx.accessSuffix():
            if suffix.expr():
                # Acesso a array: GEP no elemento e reduz uma dimensao do tipo.
                idx = self.visit(suffix.expr()).value
                if isinstance(ptr.type.pointee, ir.PointerType):
                    ptr = self.builder.load(ptr)
                ptr = self.builder.gep(ptr, [self.i32(0), idx], inbounds=True)
                typ = typ[:-2]
                size = None
            else:
                # Acesso a atributo: GEP pelo indice do campo na struct da classe.
                layout = self.classes[typ]
                if isinstance(ptr.type.pointee, ir.PointerType):
                    ptr = self.builder.load(ptr)
                name = suffix.ID().getText()
                index = layout.attr_index[name]
                ptr = self.builder.gep(ptr, [self.i32(0), self.i32(index)], inbounds=True)
                typ = layout.attrs[index][1]
                size = layout.attrs[index][2]
        return Slot(slot.name, typ, ptr, slot.const, size)

    def method_receiver(self, ctx):
        """Resolve o ponteiro do objeto que recebe uma chamada de metodo."""
        if ctx.THIS():
            value = self.resolve("this").ptr
            typ = self.current_class.name
        else:
            slot = self.resolve(ctx.ID().getText())
            value = slot.ptr
            typ = slot.type
            if typ in self.classes and isinstance(value.type.pointee, ir.PointerType):
                value = self.builder.load(value)
        fake = Slot("", typ, value)
        for suffix in ctx.accessSuffix():
            layout = self.classes[fake.type]
            idx = layout.attr_index[suffix.ID().getText()]
            ptr = self.builder.gep(fake.ptr, [self.i32(0), self.i32(idx)], inbounds=True)
            fake = Slot("", layout.attrs[idx][1], ptr)
        return Value(fake.ptr, fake.type)

    def load_slot(self, slot):
        """Carrega primitivos; arrays e objetos ficam como ponteiros."""
        if self.is_array(slot.type) or slot.type in self.classes:
            if slot.type in self.classes and isinstance(slot.ptr.type.pointee, ir.PointerType):
                return Value(self.builder.load(slot.ptr), slot.type, slot.ptr)
            return Value(slot.ptr, slot.type, slot.ptr)
        return Value(self.builder.load(slot.ptr), slot.type, slot.ptr)

    # Tipos e escopos
    def llvm_type(self, typ, size=None):
        """Mapeia tipos da linguagem para tipos LLVM."""
        if typ == "void":
            return self.void
        if typ == "int":
            return self.i32
        if typ == "real":
            return self.double
        if typ == "bool":
            return self.i1
        if typ == "str":
            return self.char_ptr
        if typ in self.classes:
            return self.classes[typ].struct.as_pointer()
        if self.is_array(typ):
            base = typ.replace("[]", "")
            dims = size or [1] * typ.count("[]")
            out = self.llvm_type(base)
            for dim in reversed(dims):
                out = ir.ArrayType(out, dim)
            return out
        return self.char_ptr

    def param_type(self, typ, size=None):
        """Arrays como parametro sao passados por ponteiro para o array."""
        if self.is_array(typ):
            return self.llvm_type(typ, size or [1] * typ.count("[]")).as_pointer()
        return self.llvm_type(typ)

    def default_value(self, typ):
        """Valor inicial usado quando uma variavel nao tem inicializador."""
        if typ == "int":
            return self.i32(0)
        if typ == "real":
            return ir.Constant(self.double, 0.0)
        if typ == "bool":
            return self.i1(0)
        if typ == "str":
            return self.string_const("")
        if typ in self.classes:
            return ir.Constant(self.llvm_type(typ), None)
        return self.i32(0)

    def sizeof(self, typ):
        """Calcula sizeof(T) em LLVM usando gep(null, 1) e ptrtoint."""
        ptr = ir.Constant(typ.as_pointer(), None)
        gep = self.builder.gep(ptr, [ir.IntType(32)(1)])
        return self.builder.ptrtoint(gep, ir.IntType(64))

    def push_scope(self):
        self.scopes.append({})

    def pop_scope(self):
        self.scopes.pop()

    def resolve(self, name):
        """Busca simbolo do escopo mais interno para o mais externo."""
        for scope in reversed(self.scopes):
            if name in scope:
                return scope[name]
        raise RuntimeError(f"simbolo nao encontrado: {name}")

    def get_type(self, ctx):
        return ctx.getChild(0).getText() + ("[]" * len(ctx.arraySuffix()))

    def get_array_size(self, ctx):
        return [int(s.INT_LITERAL().getText()) for s in ctx.arraySuffix()] or None

    def get_return_type(self, ctx):
        return ctx.getText()

    def get_params(self, ctx):
        """Extrai parametros como (tipo, nome, dimensoes_de_array)."""
        if not ctx:
            return []
        return [(self.get_type(p.type_()), p.ID().getText(), self.get_array_size(p.type_())) for p in ctx.param()]

    def is_array(self, typ):
        return typ.endswith("[]")

    def call_args(self, arg_ctx, params):
        """Gera argumentos de chamada aplicando casts para os tipos formais."""
        exprs = arg_ctx.expr() if arg_ctx else []
        return [self.cast_if_needed(self.visit(expr), self.ptype(params[i])).value for i, expr in enumerate(exprs)]

    def ptype(self, param):
        return param[0]

    def pname(self, param):
        return param[1]

    def psize(self, param):
        return param[2] if len(param) > 2 else None

    def init_array_literal(self, ptr, typ, size, arr_ctx):
        """Inicializa vetor literal copiando cada elemento para sua posicao."""
        if not arr_ctx.argumentList():
            return
        for i, expr in enumerate(arr_ctx.argumentList().expr()):
            elem_ptr = self.builder.gep(ptr, [self.i32(0), self.i32(i)], inbounds=True)
            val = self.cast_if_needed(self.visit(expr), typ[:-2])
            self.builder.store(val.value, elem_ptr)

    def direct_array_literal(self, expr_ctx):
        """Retorna o arrayLiteral quando a expressao inteira e um literal [...]."""
        try:
            assignment = expr_ctx.assignment()
            if assignment.assignable():
                return None

            logical_or = assignment.logicalOr()
            logical_and = logical_or.logicalAnd()
            if len(logical_and) != 1:
                return None

            equality = logical_and[0].equality()
            if len(equality) != 1:
                return None

            relational = equality[0].relational()
            if len(relational) != 1:
                return None

            additive = relational[0].additive()
            if len(additive) != 1:
                return None

            multiplicative = additive[0].multiplicative()
            if len(multiplicative) != 1:
                return None

            power = multiplicative[0].power()
            if len(power) != 1:
                return None

            unary = power[0].unary()
            if not unary.postfix():
                return None

            postfix = unary.postfix()
            if postfix.INC() or postfix.DEC():
                return None

            primary = postfix.primary()
            return primary.arrayLiteral()
        except Exception:
            return None

    def string_const(self, text):
        """Cria uma global string constante e retorna char* para seu inicio."""
        data = bytearray(text.encode("utf8")) + b"\00"
        name = f".str.{self.string_id}"
        self.string_id += 1
        glob = ir.GlobalVariable(self.module, ir.ArrayType(self.i8, len(data)), name=name)
        glob.linkage = "internal"
        glob.global_constant = True
        glob.initializer = ir.Constant(ir.ArrayType(self.i8, len(data)), data)
        return self.builder.bitcast(glob, self.char_ptr) if self.builder else glob.bitcast(self.char_ptr)

    def unescape(self, text):
        """Decodifica escapes de string da linguagem fonte."""
        return bytes(text, "utf8").decode("unicode_escape")

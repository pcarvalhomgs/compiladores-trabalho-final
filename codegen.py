from dataclasses import dataclass

from llvmlite import ir

from SimplifiedJSSVisitor import SimplifiedJSSVisitor


@dataclass
class VarInfo:
    name: str
    source_type: str
    llvm_type: ir.Type
    ptr: ir.Value
    kind: str = "var"
    array_size: list[int] | None = None
    is_reference: bool = False


@dataclass
class FunctionInfo:
    name: str
    llvm_name: str
    return_type: str
    params: list
    function: ir.Function


@dataclass
class ClassGenInfo:
    name: str
    struct_type: ir.IdentifiedStructType
    attributes: list
    attribute_index: dict
    methods: dict
    constructor_params: list | None = None


class CodeGenerator(SimplifiedJSSVisitor):
    def __init__(self):
        self.module = ir.Module(name="SimplifiedJSS")
        self.module.triple = "x86_64-pc-linux-gnu"

        self.i1 = ir.IntType(1)
        self.i8 = ir.IntType(8)
        self.i32 = ir.IntType(32)
        self.i64 = ir.IntType(64)
        self.double = ir.DoubleType()
        self.void = ir.VoidType()
        self.char_ptr = self.i8.as_pointer()

        self.builder = None
        self.current_function = None
        self.current_class = None
        self.scopes = []
        self.loop_exits = []

        self.functions = {}
        self.classes = {}
        self.string_counter = 0

        self.printf = None
        self.scanf = None
        self.malloc = None
        self.strconcat = None
        self.int_to_str = None
        self.real_to_str = None
        self.bool_to_str = None

    def generate(self, tree):
        self._declare_runtime()
        self._predeclare_classes(tree)
        self._predeclare_functions(tree)

        for decl in tree.topLevelDecl():
            if decl.classDecl():
                self.visit(decl.classDecl())

        global_statements = []
        for decl in tree.topLevelDecl():
            if decl.functionDecl():
                self.visit(decl.functionDecl())
            elif decl.statement():
                global_statements.append(decl.statement())

        if global_statements:
            self._emit_global_main(global_statements)

        return str(self.module)

    # --------------------------------------------------
    # Predeclaracoes
    # --------------------------------------------------

    def _predeclare_classes(self, tree):
        for decl in tree.topLevelDecl():
            class_ctx = decl.classDecl()
            if not class_ctx:
                continue

            name = class_ctx.ID().getText()
            struct_type = self.module.context.get_identified_type(f"class.{name}")
            info = ClassGenInfo(name, struct_type, [], {}, {})
            self.classes[name] = info

        for decl in tree.topLevelDecl():
            class_ctx = decl.classDecl()
            if not class_ctx:
                continue

            info = self.classes[class_ctx.ID().getText()]
            attr_types = []

            for member in class_ctx.classMember():
                attr = member.attributeDecl()
                if not attr:
                    continue

                attr_name = attr.ID().getText()
                source_type, sizes = self._source_type(attr.type_())
                llvm_type = self._llvm_type(source_type, sizes)
                info.attribute_index[attr_name] = len(info.attributes)
                info.attributes.append((attr_name, source_type, sizes, llvm_type))
                attr_types.append(llvm_type)

            info.struct_type.set_body(*attr_types)

    def _predeclare_functions(self, tree):
        for decl in tree.topLevelDecl():
            fn_ctx = decl.functionDecl()
            if fn_ctx:
                self._declare_function(fn_ctx)

        for decl in tree.topLevelDecl():
            class_ctx = decl.classDecl()
            if not class_ctx:
                continue

            class_name = class_ctx.ID().getText()
            class_info = self.classes[class_name]

            for member in class_ctx.classMember():
                if member.constructorDecl():
                    ctor = member.constructorDecl()
                    params = self._params(ctor.paramList())
                    class_info.constructor_params = params
                    arg_types = [class_info.struct_type.as_pointer()]
                    arg_types += [self._param_llvm_type(t, sizes) for t, _, sizes in params]
                    fn_ty = ir.FunctionType(self.void, arg_types)
                    fn = ir.Function(self.module, fn_ty, name=f"{class_name}_constructor")
                    class_info.methods["constructor"] = FunctionInfo(
                        "constructor", fn.name, "void", params, fn
                    )

                if member.methodDecl():
                    method = member.methodDecl()
                    name = method.ID().getText()
                    ret = self._return_type(method.returnType())
                    params = self._params(method.paramList())
                    arg_types = [class_info.struct_type.as_pointer()]
                    arg_types += [self._param_llvm_type(t, sizes) for t, _, sizes in params]
                    fn_ty = ir.FunctionType(self._llvm_type(ret), arg_types)
                    fn = ir.Function(self.module, fn_ty, name=f"{class_name}_{name}")
                    class_info.methods[name] = FunctionInfo(name, fn.name, ret, params, fn)

    def _declare_function(self, ctx):
        name = ctx.ID().getText()
        ret = self._return_type(ctx.returnType())
        params = self._params(ctx.paramList())
        arg_types = [self._param_llvm_type(t, sizes) for t, _, sizes in params]
        fn_ty = ir.FunctionType(self._llvm_type(ret), arg_types)
        fn = ir.Function(self.module, fn_ty, name=name)
        self.functions[name] = FunctionInfo(name, name, ret, params, fn)

    def _declare_runtime(self):
        self.printf = ir.Function(
            self.module,
            ir.FunctionType(self.i32, [self.char_ptr], var_arg=True),
            name="printf",
        )
        self.scanf = ir.Function(
            self.module,
            ir.FunctionType(self.i32, [self.char_ptr], var_arg=True),
            name="scanf",
        )
        self.malloc = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [self.i64]),
            name="malloc",
        )
        self.strconcat = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [self.char_ptr, self.char_ptr]),
            name="__jss_concat",
        )
        self.int_to_str = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [self.i32]),
            name="__jss_int_to_str",
        )
        self.real_to_str = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [self.double]),
            name="__jss_real_to_str",
        )
        self.bool_to_str = ir.Function(
            self.module,
            ir.FunctionType(self.char_ptr, [self.i1]),
            name="__jss_bool_to_str",
        )

    # --------------------------------------------------
    # Declaracoes
    # --------------------------------------------------

    def visitFunctionDecl(self, ctx):
        info = self.functions[ctx.ID().getText()]
        self._start_function(info.function)
        self._push_scope()

        for arg, (source_type, name, sizes) in zip(info.function.args, info.params):
            arg.name = name
            llvm_type = self._llvm_type(source_type, sizes)
            if self._is_array(source_type):
                self._define(name, VarInfo(name, source_type, llvm_type, arg, "param", sizes, True))
            else:
                slot = self._alloca_entry(name, llvm_type)
                self.builder.store(arg, slot)
                self._define(name, VarInfo(name, source_type, llvm_type, slot, "param", sizes))

        self.visit(ctx.block())
        self._finish_function(info.return_type)
        self._pop_scope()

    def visitClassDecl(self, ctx):
        previous = self.current_class
        self.current_class = self.classes[ctx.ID().getText()]

        for member in ctx.classMember():
            if member.constructorDecl():
                self.visit(member.constructorDecl())
            elif member.methodDecl():
                self.visit(member.methodDecl())

        self.current_class = previous

    def visitConstructorDecl(self, ctx):
        info = self.current_class.methods["constructor"]
        self._start_function(info.function)
        self._push_scope()

        this_arg = info.function.args[0]
        this_arg.name = "this"
        self._define(
            "this",
            VarInfo("this", self.current_class.name, self.current_class.struct_type, this_arg, "var", None, True),
        )

        for arg, (source_type, name, sizes) in zip(info.function.args[1:], info.params):
            arg.name = name
            llvm_type = self._llvm_type(source_type, sizes)
            if self._is_array(source_type):
                self._define(name, VarInfo(name, source_type, llvm_type, arg, "param", sizes, True))
            else:
                slot = self._alloca_entry(name, llvm_type)
                self.builder.store(arg, slot)
                self._define(name, VarInfo(name, source_type, llvm_type, slot, "param", sizes))

        self.visit(ctx.block())
        self._finish_function("void")
        self._pop_scope()

    def visitMethodDecl(self, ctx):
        info = self.current_class.methods[ctx.ID().getText()]
        self._start_function(info.function)
        self._push_scope()

        this_arg = info.function.args[0]
        this_arg.name = "this"
        self._define(
            "this",
            VarInfo("this", self.current_class.name, self.current_class.struct_type, this_arg, "var", None, True),
        )

        for arg, (source_type, name, sizes) in zip(info.function.args[1:], info.params):
            arg.name = name
            llvm_type = self._llvm_type(source_type, sizes)
            if self._is_array(source_type):
                self._define(name, VarInfo(name, source_type, llvm_type, arg, "param", sizes, True))
            else:
                slot = self._alloca_entry(name, llvm_type)
                self.builder.store(arg, slot)
                self._define(name, VarInfo(name, source_type, llvm_type, slot, "param", sizes))

        self.visit(ctx.block())
        self._finish_function(info.return_type)
        self._pop_scope()

    def visitBlock(self, ctx):
        self._push_scope()
        for stmt in ctx.statement():
            if not self._terminated():
                self.visit(stmt)
        self._pop_scope()

    def visitVarDecl(self, ctx):
        self._declare_vars(ctx.type_(), ctx.declaratorList().declarator(), "var")

    def visitConstDecl(self, ctx):
        self._declare_vars(ctx.type_(), ctx.constDeclaratorList().constDeclarator(), "const")

    def visitVarDeclNoSemi(self, ctx):
        self._declare_vars(ctx.type_(), ctx.declaratorList().declarator(), "var")

    def _declare_vars(self, type_ctx, declarators, kind):
        source_type, sizes = self._source_type(type_ctx)
        llvm_type = self._llvm_type(source_type, sizes)

        for decl in declarators:
            name = decl.ID().getText()
            slot = self._alloca_entry(name, llvm_type)
            self._define(name, VarInfo(name, source_type, llvm_type, slot, kind, sizes))

            if self._is_array(source_type):
                self._zero_initialize(slot, llvm_type)
                if decl.expr():
                    self._assign_array_literal(slot, source_type, sizes, decl.expr())
            elif decl.expr():
                value, value_type = self.visit(decl.expr())
                self.builder.store(self._cast(value, value_type, source_type), slot)
            else:
                self.builder.store(self._default_value(source_type, llvm_type), slot)

    # --------------------------------------------------
    # Statements
    # --------------------------------------------------

    def visitExprStmt(self, ctx):
        return self.visit(ctx.expr())

    def visitReturnStmt(self, ctx):
        if ctx.expr():
            value, source_type = self.visit(ctx.expr())
            ret_type = str(self.current_function.function_type.return_type)
            if ret_type == "void":
                self.builder.ret_void()
            else:
                self.builder.ret(self._cast_to_llvm(value, source_type, self.current_function.function_type.return_type))
        else:
            self.builder.ret_void()

    def visitIfStmt(self, ctx):
        end_block = self.current_function.append_basic_block("if.end")
        branches = [(ctx.expr(), ctx.block())]
        branches.extend((p.expr(), p.block()) for p in ctx.elseIfPart())

        for i, (cond_ctx, block_ctx) in enumerate(branches):
            then_block = self.current_function.append_basic_block(f"if.then.{i}")
            next_block = end_block if i == len(branches) - 1 and not ctx.elsePart() else self.current_function.append_basic_block(f"if.next.{i}")
            cond, cond_type = self.visit(cond_ctx)
            self.builder.cbranch(self._to_bool(cond, cond_type), then_block, next_block)

            self.builder.position_at_end(then_block)
            self.visit(block_ctx)
            if not self._terminated():
                self.builder.branch(end_block)

            self.builder.position_at_end(next_block)

        if ctx.elsePart():
            self.visit(ctx.elsePart().block())
            if not self._terminated():
                self.builder.branch(end_block)

        if not self._terminated():
            self.builder.branch(end_block)
        self.builder.position_at_end(end_block)

    def visitWhileStmt(self, ctx):
        cond_block = self.current_function.append_basic_block("while.cond")
        body_block = self.current_function.append_basic_block("while.body")
        end_block = self.current_function.append_basic_block("while.end")

        self.builder.branch(cond_block)
        self.builder.position_at_end(cond_block)
        cond, cond_type = self.visit(ctx.expr())
        self.builder.cbranch(self._to_bool(cond, cond_type), body_block, end_block)

        self.builder.position_at_end(body_block)
        self.loop_exits.append(end_block)
        self.visit(ctx.block())
        self.loop_exits.pop()
        if not self._terminated():
            self.builder.branch(cond_block)

        self.builder.position_at_end(end_block)

    def visitForStmt(self, ctx):
        self._push_scope()
        if ctx.forInit():
            self.visit(ctx.forInit())

        cond_block = self.current_function.append_basic_block("for.cond")
        body_block = self.current_function.append_basic_block("for.body")
        step_block = self.current_function.append_basic_block("for.step")
        end_block = self.current_function.append_basic_block("for.end")

        self.builder.branch(cond_block)
        self.builder.position_at_end(cond_block)

        exprs = ctx.expr()
        if len(exprs) > 0:
            cond, cond_type = self.visit(exprs[0])
            self.builder.cbranch(self._to_bool(cond, cond_type), body_block, end_block)
        else:
            self.builder.branch(body_block)

        self.builder.position_at_end(body_block)
        self.loop_exits.append(end_block)
        self.visit(ctx.block())
        self.loop_exits.pop()
        if not self._terminated():
            self.builder.branch(step_block)

        self.builder.position_at_end(step_block)
        if len(exprs) > 1:
            self.visit(exprs[1])
        if not self._terminated():
            self.builder.branch(cond_block)

        self.builder.position_at_end(end_block)
        self._pop_scope()

    def visitForInit(self, ctx):
        if ctx.varDeclNoSemi():
            return self.visit(ctx.varDeclNoSemi())
        if ctx.expr():
            return self.visit(ctx.expr())
        return None

    def visitBreakStmt(self, ctx):
        self.builder.branch(self.loop_exits[-1])

    def visitConsoleLogStmt(self, ctx):
        if not ctx.argumentList():
            self._printf("\n")
            return

        for expr in ctx.argumentList().expr():
            value, source_type = self.visit(expr)
            if source_type == "str":
                self._printf("%s", value)
            elif source_type == "real":
                self._printf("%f", value)
            elif source_type == "bool":
                as_int = self.builder.zext(value, self.i32)
                self._printf("%d", as_int)
            else:
                self._printf("%d", value)
            self._printf(" ")
        self._printf("\n")

    def visitInputStmt(self, ctx):
        if not ctx.assignableList():
            return

        for assignable in ctx.assignableList().assignable():
            ptr, source_type = self._address_of(assignable)
            if source_type == "int":
                self._scanf("%d", ptr)
            elif source_type == "real":
                self._scanf("%lf", ptr)
            elif source_type == "str":
                buf = self.builder.call(self.malloc, [ir.Constant(self.i64, 256)], name="strbuf")
                self.builder.store(buf, ptr)
                self._scanf("%255s", buf)

    # --------------------------------------------------
    # Expressoes
    # --------------------------------------------------

    def visitExpr(self, ctx):
        return self.visit(ctx.assignment())

    def visitAssignment(self, ctx):
        if not ctx.assignable():
            return self.visit(ctx.logicalOr())

        ptr, target_type = self._address_of(ctx.assignable())
        current = self._load_from(ptr, target_type)
        right, right_type = self.visit(ctx.assignment())
        op = ctx.assignOp().getText()

        if op == "=":
            value = self._cast(right, right_type, target_type)
        else:
            rhs = self._cast(right, right_type, target_type)
            value = self._binary(op[:-1], current, rhs, target_type, target_type)[0]

        self.builder.store(value, ptr)
        return value, target_type

    def visitLogicalOr(self, ctx):
        items = ctx.logicalAnd()
        value, value_type = self.visit(items[0])
        if len(items) == 1:
            return value, value_type
        value = self._to_bool(value, value_type)
        for item in items[1:]:
            right, right_type = self.visit(item)
            value = self.builder.or_(value, self._to_bool(right, right_type))
        return value, "bool"

    def visitLogicalAnd(self, ctx):
        items = ctx.equality()
        value, value_type = self.visit(items[0])
        if len(items) == 1:
            return value, value_type
        value = self._to_bool(value, value_type)
        for item in items[1:]:
            right, right_type = self.visit(item)
            value = self.builder.and_(value, self._to_bool(right, right_type))
        return value, "bool"

    def visitEquality(self, ctx):
        return self._left_assoc(ctx.relational(), ctx, {"==", "!="})

    def visitRelational(self, ctx):
        return self._left_assoc(ctx.additive(), ctx, {">", ">=", "<", "<="})

    def visitAdditive(self, ctx):
        return self._left_assoc(ctx.multiplicative(), ctx, {"+", "-"})

    def visitMultiplicative(self, ctx):
        return self._left_assoc(ctx.power(), ctx, {"*", "/", "%"})

    def visitPower(self, ctx):
        left, left_type = self.visit(ctx.unary())
        if ctx.power():
            right, right_type = self.visit(ctx.power())
            right = self._cast(right, right_type, "int")
            result = ir.Constant(self.i32, 1)
            loop_i = self._alloca_entry("pow.i", self.i32)
            loop_acc = self._alloca_entry("pow.acc", self.i32)
            self.builder.store(ir.Constant(self.i32, 0), loop_i)
            self.builder.store(result, loop_acc)

            cond_block = self.current_function.append_basic_block("pow.cond")
            body_block = self.current_function.append_basic_block("pow.body")
            end_block = self.current_function.append_basic_block("pow.end")
            self.builder.branch(cond_block)
            self.builder.position_at_end(cond_block)
            i_val = self.builder.load(loop_i)
            self.builder.cbranch(self.builder.icmp_signed("<", i_val, right), body_block, end_block)
            self.builder.position_at_end(body_block)
            acc_val = self.builder.load(loop_acc)
            self.builder.store(self.builder.mul(acc_val, self._cast(left, left_type, "int")), loop_acc)
            self.builder.store(self.builder.add(i_val, ir.Constant(self.i32, 1)), loop_i)
            self.builder.branch(cond_block)
            self.builder.position_at_end(end_block)
            return self.builder.load(loop_acc), "int"
        return left, left_type

    def visitUnary(self, ctx):
        if ctx.postfix():
            return self.visit(ctx.postfix())

        op = ctx.getChild(0).getText()
        if op in {"++", "--"}:
            ptr, source_type = self._address_of(ctx.unary().postfix().primary().assignable())
            current = self._load_from(ptr, source_type)
            one = self._number_one(source_type)
            value = self.builder.add(current, one) if source_type == "int" and op == "++" else None
            if source_type == "int" and op == "--":
                value = self.builder.sub(current, one)
            if source_type == "real" and op == "++":
                value = self.builder.fadd(current, one)
            if source_type == "real" and op == "--":
                value = self.builder.fsub(current, one)
            self.builder.store(value, ptr)
            return value, source_type

        value, source_type = self.visit(ctx.unary())
        if op == "!":
            return self.builder.not_(self._to_bool(value, source_type)), "bool"
        if op == "-":
            if source_type == "real":
                return self.builder.fneg(value), "real"
            return self.builder.neg(value), "int"
        return value, source_type

    def visitPostfix(self, ctx):
        value, source_type = self.visit(ctx.primary())
        if ctx.INC() or ctx.DEC():
            ptr, source_type = self._address_of(ctx.primary().assignable())
            current = self._load_from(ptr, source_type)
            one = self._number_one(source_type)
            if source_type == "real":
                new_value = self.builder.fadd(current, one) if ctx.INC() else self.builder.fsub(current, one)
            else:
                new_value = self.builder.add(current, one) if ctx.INC() else self.builder.sub(current, one)
            self.builder.store(new_value, ptr)
            return current, source_type
        return value, source_type

    def visitPrimary(self, ctx):
        if ctx.literal():
            return self.visit(ctx.literal())
        if ctx.newObject():
            return self.visit(ctx.newObject())
        if ctx.castCall():
            return self.visit(ctx.castCall())
        if ctx.methodCall():
            return self.visit(ctx.methodCall())
        if ctx.functionCall():
            return self.visit(ctx.functionCall())
        if ctx.assignable():
            ptr, source_type = self._address_of(ctx.assignable())
            if self._is_array(source_type):
                return ptr, source_type
            return self._load_from(ptr, source_type), source_type
        if ctx.arrayLiteral():
            return self.visit(ctx.arrayLiteral())
        return self.visit(ctx.expr())

    def visitFunctionCall(self, ctx):
        info = self.functions[ctx.ID().getText()]
        args = self._call_args(ctx.argumentList(), info.params)
        return self.builder.call(info.function, args), info.return_type

    def visitMethodCall(self, ctx):
        receiver, receiver_type = self._method_receiver(ctx.methodReceiver())
        method_name = ctx.ID().getText()
        class_info = self.classes[receiver_type]
        info = class_info.methods[method_name]
        args = [receiver] + self._call_args(ctx.argumentList(), info.params)
        value = self.builder.call(info.function, args)
        return value, info.return_type

    def visitNewObject(self, ctx):
        class_name = ctx.ID().getText()
        class_info = self.classes[class_name]
        raw = self.builder.call(self.malloc, [ir.Constant(self.i64, self._sizeof(class_info.struct_type))])
        obj = self.builder.bitcast(raw, class_info.struct_type.as_pointer())
        ctor = class_info.methods["constructor"]
        args = [obj] + self._call_args(ctx.argumentList(), ctor.params)
        self.builder.call(ctor.function, args)
        return obj, class_name

    def visitCastCall(self, ctx):
        target = ctx.primitiveType().getText()
        value, source_type = self.visit(ctx.expr())
        return self._cast(value, source_type, target), target

    def visitArrayLiteral(self, ctx):
        values = []
        if ctx.argumentList():
            values = [self.visit(e) for e in ctx.argumentList().expr()]
        return values, "array_literal"

    def visitLiteral(self, ctx):
        text = ctx.getText()
        if text == "true":
            return ir.Constant(self.i1, 1), "bool"
        if text == "false":
            return ir.Constant(self.i1, 0), "bool"
        if text == "null":
            return ir.Constant(self.char_ptr, None), "null"
        if text.startswith('"'):
            return self._string_literal(self._decode_string(text)), "str"
        if "." in text or "e" in text.lower():
            return ir.Constant(self.double, float(text)), "real"
        return ir.Constant(self.i32, int(text)), "int"

    # --------------------------------------------------
    # Enderecos, chamadas e tipos
    # --------------------------------------------------

    def _address_of(self, ctx):
        base = ctx.assignableBase()
        name = "this" if base.THIS() else base.ID().getText()
        var = self._resolve(name)
        ptr = var.ptr
        source_type = var.source_type
        sizes = var.array_size

        if source_type in self.classes and not var.is_reference:
            ptr = self.builder.load(ptr)

        for suffix in ctx.accessSuffix():
            if suffix.expr():
                index, index_type = self.visit(suffix.expr())
                index = self._cast(index, index_type, "int")
                ptr = self.builder.gep(ptr, [ir.Constant(self.i32, 0), index], inbounds=True)
                source_type = self._element_type(source_type)
                sizes = sizes[1:] if sizes else None
            else:
                attr_name = suffix.ID().getText()
                class_info = self.classes[source_type]
                idx = class_info.attribute_index[attr_name]
                ptr = self.builder.gep(ptr, [ir.Constant(self.i32, 0), ir.Constant(self.i32, idx)], inbounds=True)
                _, source_type, sizes, _ = class_info.attributes[idx]

        return ptr, source_type

    def _method_receiver(self, ctx):
        name = "this" if ctx.THIS() else ctx.ID().getText()
        var = self._resolve(name)
        ptr = var.ptr if var.is_reference else self.builder.load(var.ptr)
        source_type = var.source_type

        for suffix in ctx.accessSuffix():
            attr_name = suffix.ID().getText() if suffix.ID() else None
            if attr_name:
                class_info = self.classes[source_type]
                idx = class_info.attribute_index[attr_name]
                ptr = self.builder.gep(ptr, [ir.Constant(self.i32, 0), ir.Constant(self.i32, idx)], inbounds=True)
                _, source_type, _, _ = class_info.attributes[idx]
                if source_type in self.classes:
                    ptr = self.builder.load(ptr)
            else:
                index, index_type = self.visit(suffix.expr())
                ptr = self.builder.gep(ptr, [ir.Constant(self.i32, 0), self._cast(index, index_type, "int")], inbounds=True)
                source_type = self._element_type(source_type)

        return ptr, source_type

    def _call_args(self, argument_list, params):
        if not argument_list:
            return []

        args = []
        for expr, (param_type, _, _) in zip(argument_list.expr(), params):
            value, source_type = self.visit(expr)
            args.append(value if self._is_array(param_type) else self._cast(value, source_type, param_type))
        return args

    def _left_assoc(self, items, ctx, ops):
        value, source_type = self.visit(items[0])
        for i in range(1, len(items)):
            op = ctx.getChild(2 * i - 1).getText()
            if op not in ops:
                continue
            right, right_type = self.visit(items[i])
            value, source_type = self._binary(op, value, right, source_type, right_type)
        return value, source_type

    def _binary(self, op, left, right, left_type, right_type):
        if op == "+" and (left_type == "str" or right_type == "str"):
            return self.builder.call(
                self.strconcat,
                [self._to_string(left, left_type), self._to_string(right, right_type)],
            ), "str"

        if left_type == "real" or right_type == "real":
            left = self._cast(left, left_type, "real")
            right = self._cast(right, right_type, "real")
            if op == "+": return self.builder.fadd(left, right), "real"
            if op == "-": return self.builder.fsub(left, right), "real"
            if op == "*": return self.builder.fmul(left, right), "real"
            if op == "/": return self.builder.fdiv(left, right), "real"
            if op in {">", ">=", "<", "<=", "==", "!="}:
                return self.builder.fcmp_ordered(op, left, right), "bool"

        left = self._cast(left, left_type, "int" if left_type != "bool" else "bool")
        right = self._cast(right, right_type, "int" if right_type != "bool" else "bool")
        if op == "+": return self.builder.add(left, right), "int"
        if op == "-": return self.builder.sub(left, right), "int"
        if op == "*": return self.builder.mul(left, right), "int"
        if op == "/": return self.builder.sdiv(left, right), "int"
        if op == "%": return self.builder.srem(left, right), "int"
        if op in {">", ">=", "<", "<=", "==", "!="}:
            pred = {"==": "==", "!=": "!=", ">": ">", ">=": ">=", "<": "<", "<=": "<="}[op]
            return self.builder.icmp_signed(pred, left, right), "bool"
        raise NotImplementedError(f"operador {op} nao suportado")

    def _source_type(self, ctx):
        base = ctx.getChild(0).getText()
        sizes = [int(s.INT_LITERAL().getText()) for s in ctx.arraySuffix()]
        return base + ("[]" * len(sizes)), sizes or None

    def _return_type(self, ctx):
        if ctx.VOID():
            return "void"
        return self._source_type(ctx.type_())[0]

    def _params(self, ctx):
        if not ctx:
            return []
        params = []
        for p in ctx.param():
            source_type, sizes = self._source_type(p.type_())
            params.append((source_type, p.ID().getText(), sizes))
        return params

    def _llvm_type(self, source_type, sizes=None):
        if source_type == "void":
            return self.void
        if source_type == "int":
            return self.i32
        if source_type == "real":
            return self.double
        if source_type == "bool":
            return self.i1
        if source_type == "str":
            return self.char_ptr
        if source_type in self.classes:
            return self.classes[source_type].struct_type.as_pointer()
        if self._is_array(source_type):
            base = source_type.replace("[]", "")
            llvm_type = self._llvm_type(base)
            for size in reversed(sizes or []):
                llvm_type = ir.ArrayType(llvm_type, size)
            return llvm_type
        return self.char_ptr

    def _param_llvm_type(self, source_type, sizes):
        llvm_type = self._llvm_type(source_type, sizes)
        return llvm_type.as_pointer() if self._is_array(source_type) else llvm_type

    # --------------------------------------------------
    # Infra LLVM
    # --------------------------------------------------

    def _start_function(self, fn):
        block = fn.append_basic_block("entry")
        self.builder = ir.IRBuilder(block)
        self.current_function = fn

    def _finish_function(self, source_return_type):
        if self._terminated():
            return
        if source_return_type == "void":
            self.builder.ret_void()
        else:
            self.builder.ret(self._default_value(source_return_type, self._llvm_type(source_return_type)))

    def _emit_global_main(self, statements):
        if "main" in self.functions:
            return
        fn_ty = ir.FunctionType(self.i32, [])
        fn = ir.Function(self.module, fn_ty, name="main")
        self._start_function(fn)
        self._push_scope()
        for stmt in statements:
            if not self._terminated():
                self.visit(stmt)
        if not self._terminated():
            self.builder.ret(ir.Constant(self.i32, 0))
        self._pop_scope()

    def _alloca_entry(self, name, llvm_type):
        return self.builder.alloca(llvm_type, name=name)

    def _push_scope(self):
        self.scopes.append({})

    def _pop_scope(self):
        self.scopes.pop()

    def _define(self, name, info):
        self.scopes[-1][name] = info

    def _resolve(self, name):
        for scope in reversed(self.scopes):
            if name in scope:
                return scope[name]
        raise NameError(name)

    def _terminated(self):
        return self.builder.block.is_terminated

    def _load_from(self, ptr, source_type):
        if source_type in self.classes:
            return ptr if isinstance(ptr.type.pointee, ir.IdentifiedStructType) else self.builder.load(ptr)
        return self.builder.load(ptr)

    def _zero_initialize(self, ptr, llvm_type):
        self.builder.store(ir.Constant(llvm_type, None), ptr)

    def _assign_array_literal(self, ptr, source_type, sizes, expr):
        values, literal_type = self.visit(expr)
        if literal_type != "array_literal":
            return
        element_type = self._element_type(source_type)
        for i, (value, value_type) in enumerate(values):
            elem_ptr = self.builder.gep(ptr, [ir.Constant(self.i32, 0), ir.Constant(self.i32, i)], inbounds=True)
            self.builder.store(self._cast(value, value_type, element_type), elem_ptr)

    def _printf(self, fmt, *args):
        self.builder.call(self.printf, [self._string_literal(fmt), *args])

    def _scanf(self, fmt, *args):
        self.builder.call(self.scanf, [self._string_literal(fmt), *args])

    def _string_literal(self, text):
        data = bytearray(text.encode("utf-8")) + b"\00"
        name = f".str.{self.string_counter}"
        self.string_counter += 1
        const = ir.Constant(ir.ArrayType(self.i8, len(data)), data)
        glob = ir.GlobalVariable(self.module, const.type, name=name)
        glob.linkage = "internal"
        glob.global_constant = True
        glob.initializer = const
        return self.builder.bitcast(glob, self.char_ptr)

    # --------------------------------------------------
    # Conversoes e utilitarios
    # --------------------------------------------------

    def _cast(self, value, source_type, target_type):
        if source_type == target_type:
            return value
        if target_type == "str":
            return self._to_string(value, source_type)
        if target_type == "real" and source_type == "int":
            return self.builder.sitofp(value, self.double)
        if target_type == "real" and source_type == "bool":
            return self.builder.uitofp(value, self.double)
        if target_type == "int" and source_type == "real":
            return self.builder.fptosi(value, self.i32)
        if target_type == "int" and source_type == "bool":
            return self.builder.zext(value, self.i32)
        if target_type == "bool":
            return self._to_bool(value, source_type)
        if target_type in self.classes and source_type == "null":
            return ir.Constant(self._llvm_type(target_type), None)
        return value

    def _cast_to_llvm(self, value, source_type, llvm_type):
        target = self._source_name_from_llvm(llvm_type)
        return self._cast(value, source_type, target)

    def _source_name_from_llvm(self, llvm_type):
        if llvm_type == self.i32:
            return "int"
        if llvm_type == self.double:
            return "real"
        if llvm_type == self.i1:
            return "bool"
        if llvm_type == self.char_ptr:
            return "str"
        return "void"

    def _to_bool(self, value, source_type):
        if source_type == "bool":
            return value
        if source_type == "real":
            return self.builder.fcmp_ordered("!=", value, ir.Constant(self.double, 0.0))
        if isinstance(value.type, ir.PointerType):
            return self.builder.icmp_unsigned("!=", value, ir.Constant(value.type, None))
        return self.builder.icmp_signed("!=", value, ir.Constant(value.type, 0))

    def _to_string(self, value, source_type):
        if source_type == "str":
            return value
        if source_type == "real":
            return self.builder.call(self.real_to_str, [value])
        if source_type == "bool":
            return self.builder.call(self.bool_to_str, [value])
        return self.builder.call(self.int_to_str, [value])

    def _default_value(self, source_type, llvm_type):
        if source_type == "real":
            return ir.Constant(self.double, 0.0)
        if source_type == "bool":
            return ir.Constant(self.i1, 0)
        if source_type == "str":
            return self._string_literal("")
        if source_type in self.classes:
            return ir.Constant(llvm_type, None)
        return ir.Constant(llvm_type, 0)

    def _number_one(self, source_type):
        if source_type == "real":
            return ir.Constant(self.double, 1.0)
        return ir.Constant(self.i32, 1)

    def _is_array(self, source_type):
        return source_type.endswith("[]")

    def _element_type(self, source_type):
        return source_type[:-2]

    def _sizeof(self, llvm_type):
        if isinstance(llvm_type, ir.IntType):
            return max(1, llvm_type.width // 8)
        if isinstance(llvm_type, ir.DoubleType):
            return 8
        if isinstance(llvm_type, ir.PointerType):
            return 8
        if isinstance(llvm_type, ir.ArrayType):
            return llvm_type.count * self._sizeof(llvm_type.element)
        if isinstance(llvm_type, ir.IdentifiedStructType):
            return sum(self._sizeof(t) for t in llvm_type.elements) or 1
        return 8

    def _decode_string(self, text):
        return bytes(text[1:-1], "utf-8").decode("unicode_escape")

# Checador Semântico

from dataclasses import dataclass, field
from SimplifiedJSSVisitor import SimplifiedJSSVisitor 


class SemanticError(Exception):
    pass


@dataclass
class Symbol:
    name: str
    type: str
    kind: str
    initialized: bool = False
    params: list = field(default_factory=list)
    return_type: str | None = None
    array_size: int | None = None


@dataclass
class ClassInfo:
    name: str
    attributes: dict = field(default_factory=dict)
    methods: dict = field(default_factory=dict)
    constructor_params: list = field(default_factory=list)
    has_constructor: bool = False


class Scope:
    def __init__(self, parent=None):
        self.parent = parent
        self.symbols = {}

    def define(self, symbol, line):
        if symbol.name in self.symbols:
            raise SemanticError(
                f"Linha {line}: variável '{symbol.name}' já declarado neste escopo"
            )
        self.symbols[symbol.name] = symbol

    def resolve(self, name):
        scope = self
        while scope:
            if name in scope.symbols:
                return scope.symbols[name]
            scope = scope.parent
        return None


class StaticChecker(SimplifiedJSSVisitor):
    def __init__(self):
        self.global_scope = Scope()
        self.current_scope = self.global_scope

        self.classes = {}
        self.current_function = None
        self.current_class = None
        self.loop_depth = 0

        self.primitive_types = {"int", "real", "str", "bool"}

    def check(self, tree):
        try:
            self.visit(tree)
            return True, []
        except SemanticError as e:
            return False, [str(e)]

    def error(self, ctx, msg):
        line = ctx.start.line if hasattr(ctx, "start") and ctx.start else "?"
        raise SemanticError(f"Linha {line}: {msg}")

    # --------------------------------------------------
    # Programa
    # --------------------------------------------------

    def visitProgram(self, ctx):
        for decl in ctx.topLevelDecl():
            if decl.classDecl():
                self.predeclareClass(decl.classDecl())
            elif decl.functionDecl():
                self.predeclareFunction(decl.functionDecl())

        for decl in ctx.topLevelDecl():
            self.visit(decl)

        main = self.global_scope.resolve("main")

        if main:
            if main.kind != "function":
                self.error(ctx, "'main' deve ser função")
            if main.return_type != "void":
                self.error(ctx, "função main deve retornar void")
            if len(main.params) != 0:
                self.error(ctx, "função main não deve possuir parâmetros")

    # --------------------------------------------------
    # Pré-declarações globais
    # --------------------------------------------------

    def predeclareClass(self, ctx):
        name = ctx.ID().getText()

        self.global_scope.define(
            Symbol(name=name, type=name, kind="class"),
            ctx.start.line
        )

        self.classes[name] = ClassInfo(name=name)

    def predeclareFunction(self, ctx):
        name = ctx.ID().getText()
        return_type = self.getReturnType(ctx.returnType())

        params = []
        if ctx.paramList():
            for p in ctx.paramList().param():
                param_type = self.getType(p.type_())
                param_name = p.ID().getText()
                params.append((param_type, param_name))

        self.global_scope.define(
            Symbol(
                name=name,
                type="function",
                kind="function",
                params=params,
                return_type=return_type
            ),
            ctx.start.line
        )

    # --------------------------------------------------
    # Variáveis e constantes
    # --------------------------------------------------

    def visitVarDecl(self, ctx):
        var_type = self.getType(ctx.type_())
        array_size = self.getArraySize(ctx.type_())

        self.ensureTypeExists(ctx, var_type)

        for decl in ctx.declaratorList().declarator():
            name = decl.ID().getText()
            initialized = False

            if decl.expr():
                expr_type = self.visit(decl.expr())

                if self.isArrayType(var_type):
                    self.checkArrayInitialization(ctx, var_type, array_size, expr_type)
                else:
                    self.ensureAssignable(ctx, var_type, expr_type)

                initialized = True

            self.current_scope.define(
                Symbol(
                    name=name,
                    type=var_type,
                    kind="var",
                    initialized=initialized,
                    array_size=array_size
                ),
                decl.start.line
            )

    def visitConstDecl(self, ctx):
        const_type = self.getType(ctx.type_())
        array_size = self.getArraySize(ctx.type_())

        self.ensureTypeExists(ctx, const_type)

        for decl in ctx.constDeclaratorList().constDeclarator():
            name = decl.ID().getText()
            expr_type = self.visit(decl.expr())

            if self.isArrayType(const_type):
                self.checkArrayInitialization(ctx, const_type, array_size, expr_type)
            else:
                self.ensureAssignable(ctx, const_type, expr_type)

            self.current_scope.define(
                Symbol(
                    name=name,
                    type=const_type,
                    kind="const",
                    initialized=True,
                    array_size=array_size
                ),
                decl.start.line
            )

    # --------------------------------------------------
    # Funções
    # --------------------------------------------------

    def visitFunctionDecl(self, ctx):
        name = ctx.ID().getText()
        function_symbol = self.global_scope.resolve(name)

        previous_function = self.current_function
        self.current_function = function_symbol

        self.enterScope()

        seen_params = set()

        for param_type, param_name in function_symbol.params:
            self.ensureTypeExists(ctx, param_type)

            if param_name in seen_params:
                self.error(ctx, f"parâmetro '{param_name}' duplicado")

            seen_params.add(param_name)

            self.current_scope.define(
                Symbol(
                    name=param_name,
                    type=param_type,
                    kind="param",
                    initialized=True
                ),
                ctx.start.line
            )

        has_return = self.blockHasReturn(ctx.block())

        self.visit(ctx.block())

        if function_symbol.return_type != "void" and not has_return:
            self.error(
                ctx,
                f"função '{name}' deve retornar {function_symbol.return_type}"
            )

        self.exitScope()
        self.current_function = previous_function

    def visitReturnStmt(self, ctx):
        if self.current_function is None:
            self.error(ctx, "return fora de função")

        expected = self.current_function.return_type

        if expected == "void":
            if ctx.expr():
                self.error(ctx, "função void não deve retornar valor")
            return

        if not ctx.expr():
            self.error(ctx, f"função deve retornar {expected}")

        actual = self.visit(ctx.expr())
        self.ensureAssignable(ctx, expected, actual)

    # --------------------------------------------------
    # Classes
    # --------------------------------------------------

    def visitClassDecl(self, ctx):
        class_name = ctx.ID().getText()
        class_info = self.classes[class_name]

        previous_class = self.current_class
        self.current_class = class_info

        for member in ctx.classMember():
            if member.attributeDecl():
                attr = member.attributeDecl()
                attr_type = self.getType(attr.type_())
                attr_name = attr.ID().getText()

                self.ensureTypeExists(attr, attr_type)

                if attr_name in class_info.attributes:
                    self.error(
                        attr,
                        f"atributo '{attr_name}' já declarado na classe '{class_name}'"
                    )

                class_info.attributes[attr_name] = Symbol(
                    name=attr_name,
                    type=attr_type,
                    kind="var",
                    initialized=True
                )

        for member in ctx.classMember():
            if member.constructorDecl():
                self.visit(member.constructorDecl())
            elif member.methodDecl():
                self.visit(member.methodDecl())

        if not class_info.has_constructor:
            self.error(ctx, f"classe '{class_name}' deve possuir constructor")

        self.current_class = previous_class

    def visitConstructorDecl(self, ctx):
        constructor_name = ctx.ID().getText()
        class_name = self.current_class.name

        if constructor_name != class_name:
            self.error(
                ctx,
                f"constructor '{constructor_name}' deve ter o mesmo nome da classe '{class_name}'"
            )

        if self.current_class.has_constructor:
            self.error(ctx, f"classe '{class_name}' possui mais de um constructor")

        params = self.getParams(ctx.paramList())

        self.current_class.constructor_params = params
        self.current_class.has_constructor = True

        self.enterScope()
        self.defineThis(ctx)

        for param_type, param_name in params:
            self.current_scope.define(
                Symbol(param_name, param_type, "param", initialized=True),
                ctx.start.line
            )

        self.visit(ctx.block())

        self.exitScope()

    def visitMethodDecl(self, ctx):
        method_name = ctx.ID().getText()
        ret_type = self.getType(ctx.type_())
        params = self.getParams(ctx.paramList())

        if method_name in self.current_class.methods:
            self.error(
                ctx,
                f"método '{method_name}' já declarado na classe '{self.current_class.name}'"
            )

        method_symbol = Symbol(
            name=method_name,
            type="method",
            kind="function",
            params=params,
            return_type=ret_type
        )

        self.current_class.methods[method_name] = method_symbol

        previous_function = self.current_function
        self.current_function = method_symbol

        self.enterScope()
        self.defineThis(ctx)

        for param_type, param_name in params:
            self.current_scope.define(
                Symbol(param_name, param_type, "param", initialized=True),
                ctx.start.line
            )

        has_return = self.blockHasReturn(ctx.block())

        self.visit(ctx.block())

        if ret_type != "void" and not has_return:
            self.error(ctx, f"método '{method_name}' deve retornar {ret_type}")

        self.exitScope()
        self.current_function = previous_function

    def defineThis(self, ctx):
        if not self.current_class:
            self.error(ctx, "'this' usado fora de classe")

        self.current_scope.define(
            Symbol(
                name="this",
                type=self.current_class.name,
                kind="var",
                initialized=True
            ),
            ctx.start.line
        )

    # --------------------------------------------------
    # Blocos e comandos
    # --------------------------------------------------

    def visitBlock(self, ctx):
        self.enterScope()

        for stmt in ctx.statement():
            self.visit(stmt)

        self.exitScope()

    def visitIfStmt(self, ctx):
        cond_type = self.visit(ctx.expr())

        if cond_type != "bool":
            self.error(ctx, "condição do if deve ser bool")

        self.visit(ctx.block())

        for elseif in ctx.elseIfPart():
            self.visit(elseif)

        if ctx.elsePart():
            self.visit(ctx.elsePart())

    def visitElseIfPart(self, ctx):
        cond_type = self.visit(ctx.expr())

        if cond_type != "bool":
            self.error(ctx, "condição do else if deve ser bool")

        self.visit(ctx.block())

    def visitElsePart(self, ctx):
        self.visit(ctx.block())

    def visitWhileStmt(self, ctx):
        cond_type = self.visit(ctx.expr())

        if cond_type != "bool":
            self.error(ctx, "condição do while deve ser bool")

        self.loop_depth += 1
        self.visit(ctx.block())
        self.loop_depth -= 1

    def visitForStmt(self, ctx):
        self.enterScope()

        if ctx.forInit():
            self.visit(ctx.forInit())

        exprs = ctx.expr()

        if len(exprs) >= 1:
            cond_type = self.visit(exprs[0])

            if cond_type != "bool":
                self.error(ctx, "condição do for deve ser bool")

        if len(exprs) >= 2:
            self.visit(exprs[1])

        self.loop_depth += 1
        self.visit(ctx.block())
        self.loop_depth -= 1

        self.exitScope()

    def visitForInit(self, ctx):
        if ctx.varDeclNoSemi():
            return self.visit(ctx.varDeclNoSemi())

        if ctx.expr():
            return self.visit(ctx.expr())

        return None

    def visitVarDeclNoSemi(self, ctx):
        var_type = self.getType(ctx.type_())
        array_size = self.getArraySize(ctx.type_())

        self.ensureTypeExists(ctx, var_type)

        for decl in ctx.declaratorList().declarator():
            name = decl.ID().getText()
            initialized = False

            if decl.expr():
                expr_type = self.visit(decl.expr())

                if self.isArrayType(var_type):
                    self.checkArrayInitialization(ctx, var_type, array_size, expr_type)
                else:
                    self.ensureAssignable(ctx, var_type, expr_type)

                initialized = True

            self.current_scope.define(
                Symbol(
                    name=name,
                    type=var_type,
                    kind="var",
                    initialized=initialized,
                    array_size=array_size
                ),
                decl.start.line
            )

        return None

    def visitBreakStmt(self, ctx):
        if self.loop_depth == 0:
            self.error(ctx, "break usado fora de laço")

    def visitExprStmt(self, ctx):
        return self.visit(ctx.expr())

    # --------------------------------------------------
    # Built-ins
    # --------------------------------------------------

    def visitInputStmt(self, ctx):
        if not ctx.assignableList():
            return

        for assignable in ctx.assignableList().assignable():
            symbol = self.resolveAssignableSymbol(assignable)

            if symbol.kind == "const":
                self.error(
                    assignable,
                    f"não é possível modificar constante '{symbol.name}'"
                )

            if symbol.type not in {"int", "real", "str"}:
                self.error(assignable, "input aceita apenas variáveis int, real ou str")

    def visitConsoleLogStmt(self, ctx):
        if ctx.argumentList():
            for expr in ctx.argumentList().expr():
                self.visit(expr)

    # --------------------------------------------------
    # Expressões
    # --------------------------------------------------

    def visitExpr(self, ctx):
        return self.visit(ctx.assignment())

    def visitAssignment(self, ctx):
        if ctx.assignable():
            target = self.resolveAssignableSymbol(ctx.assignable())

            if target.kind == "const":
                self.error(
                    ctx,
                    f"não é possível atribuir valor à constante '{target.name}'"
                )

            right_type = self.visit(ctx.assignment())
            self.ensureAssignable(ctx, target.type, right_type)

            return target.type

        return self.visit(ctx.logicalOr())

    def visitLogicalOr(self, ctx):
        items = ctx.logicalAnd()

        result = self.visit(items[0])

        for item in items[1:]:
            right = self.visit(item)

            if result != "bool" or right != "bool":
                self.error(ctx, "operador || exige operandos bool")

            result = "bool"

        return result


    def visitLogicalAnd(self, ctx):
        items = ctx.equality()

        result = self.visit(items[0])

        for item in items[1:]:
            right = self.visit(item)

            if result != "bool" or right != "bool":
                self.error(ctx, "operador && exige operandos bool")

            result = "bool"

        return result


    def visitEquality(self, ctx):
        items = ctx.relational()

        result = self.visit(items[0])

        for item in items[1:]:
            right = self.visit(item)

            if result != right:
                self.error(ctx, f"igualdade inválida entre {result} e {right}")

            result = "bool"

        return result


    def visitRelational(self, ctx):
        items = ctx.additive()

        result = self.visit(items[0])

        for item in items[1:]:
            right = self.visit(item)

            if result != right:
                self.error(ctx, f"comparação inválida entre {result} e {right}")

            if self.isArrayType(result):
                self.error(ctx, "vetores não podem ser comparados diretamente")

            result = "bool"

        return result


    def visitAdditive(self, ctx):
        items = ctx.multiplicative()

        result = self.visit(items[0])

        for i in range(1, len(items)):
            right = self.visit(items[i])
            op = ctx.getChild(2 * i - 1).getText()

            if op == "+" and result == "str" and right == "str":
                result = "str"

            elif op in {"+", "-"} and self.isNumeric(result) and self.isNumeric(right):
                if result != right:
                    self.error(
                        ctx,
                        f"operação {op} inválida entre {result} e {right}; use cast explícito"
                    )

            else:
                self.error(ctx, f"operador {op} inválido entre {result} e {right}")

        return result


    def visitMultiplicative(self, ctx):
        items = ctx.power()

        result = self.visit(items[0])

        for i in range(1, len(items)):
            right = self.visit(items[i])
            op = ctx.getChild(2 * i - 1).getText()

            if not self.isNumeric(result) or not self.isNumeric(right):
                self.error(ctx, f"operador {op} exige operandos numéricos")

            if result != right:
                self.error(
                    ctx,
                    f"operação {op} inválida entre {result} e {right}; use cast explícito"
                )

            if op == "%" and result != "int":
                self.error(ctx, "operador % exige operandos int")

        return result


    def visitPower(self, ctx):
        items = ctx.unary()

        left = self.visit(items[0])

        if len(items) == 2:
            right = self.visit(items[1])

            if left != "int" or right != "int":
                self.error(ctx, "operador ** exige operandos int")

            return "int"

        return left
    
    def visitPower(self, ctx):
        left = self.visit(ctx.unary())

        if ctx.power():
            right = self.visit(ctx.power())

            if left != "int" or right != "int":
                self.error(ctx, "operador ** exige operandos int")

            return "int"

        return left

    def visitUnary(self, ctx):
        if ctx.postfix():
            return self.visit(ctx.postfix())

        op = ctx.getChild(0).getText()
        operand_type = self.visit(ctx.unary())

        if op == "!":
            if operand_type != "bool":
                self.error(ctx, "operador ! exige bool")
            return "bool"

        if op in {"+", "-"}:
            if not self.isNumeric(operand_type):
                self.error(ctx, f"operador {op} exige int ou real")
            return operand_type

        if op in {"++", "--"}:
            child = ctx.unary()

            if not child.postfix() or not child.postfix().primary().assignable():
                self.error(ctx, f"operador {op} exige variável modificável")

            symbol = self.resolveAssignableSymbol(
                child.postfix().primary().assignable()
            )

            if symbol.kind == "const":
                self.error(ctx, f"não é possível modificar constante '{symbol.name}'")

            if not self.isNumeric(symbol.type):
                self.error(ctx, f"operador {op} exige variável int ou real")

            return symbol.type

        return operand_type
    
    def visitPostfix(self, ctx):
        base_type = self.visit(ctx.primary())

        if ctx.INC() or ctx.DEC():
            primary = ctx.primary()

            if not primary.assignable():
                self.error(ctx, "operador ++/-- pós-fixado exige variável modificável")

            symbol = self.resolveAssignableSymbol(primary.assignable())

            if symbol.kind == "const":
                self.error(ctx, f"não é possível modificar constante '{symbol.name}'")

            if not self.isNumeric(symbol.type):
                self.error(ctx, "operador ++/-- exige variável int ou real")

            return symbol.type

        return base_type

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
            return self.resolveAssignableSymbol(ctx.assignable()).type

        if ctx.arrayLiteral():
            return self.visit(ctx.arrayLiteral())

        if ctx.expr():
            return self.visit(ctx.expr())

        self.error(ctx, "expressão inválida")

    def visitNewObject(self, ctx):
        class_name = ctx.ID().getText()

        if class_name not in self.classes:
            self.error(ctx, f"classe '{class_name}' não declarada")

        class_info = self.classes[class_name]

        args = []
        if ctx.argumentList():
            args = [self.visit(e) for e in ctx.argumentList().expr()]

        self.checkCallArgs(ctx, class_name, class_info.constructor_params, args)

        return class_name

    def visitFunctionCall(self, ctx):
        name = ctx.ID().getText()
        symbol = self.global_scope.resolve(name)

        if not symbol or symbol.kind != "function":
            self.error(ctx, f"função '{name}' não declarada")

        args = []
        if ctx.argumentList():
            args = [self.visit(e) for e in ctx.argumentList().expr()]

        self.checkCallArgs(ctx, name, symbol.params, args)

        return symbol.return_type

    def visitMethodCall(self, ctx):
        receiver_type = self.resolveMethodReceiverType(ctx.methodReceiver())
        method_name = ctx.ID().getText()

        class_info = self.classes.get(receiver_type)

        if not class_info:
            self.error(ctx, f"tipo '{receiver_type}' não possui métodos")

        if method_name not in class_info.methods:
            self.error(ctx, f"método '{method_name}' não existe em '{receiver_type}'")

        method = class_info.methods[method_name]

        args = []
        if ctx.argumentList():
            args = [self.visit(e) for e in ctx.argumentList().expr()]

        self.checkCallArgs(ctx, method_name, method.params, args)

        return method.return_type

    def visitCastCall(self, ctx):
        target = ctx.primitiveType().getText()
        source = self.visit(ctx.expr())

        if target == "str":
            if self.isArrayType(source):
                self.error(ctx, "não é possível converter vetor para str")
            return "str"

        if target in {"int", "real", "bool"}:
            if source not in {"int", "real", "bool"}:
                self.error(ctx, f"não é possível converter {source} para {target}")
            return target

        self.error(ctx, f"cast inválido para {target}")

    def visitArrayLiteral(self, ctx):
        if not ctx.argumentList():
            return "unknown[]:0"

        types = [self.visit(e) for e in ctx.argumentList().expr()]
        first = types[0]

        for t in types:
            if t != first:
                self.error(ctx, "todos os elementos do vetor devem ter o mesmo tipo")

        return f"{first}[]:{len(types)}"

    def visitLiteral(self, ctx):
        text = ctx.getText()

        if text in {"true", "false"}:
            return "bool"

        if text == "null":
            return "null"

        if text.startswith('"'):
            return "str"

        if "." in text or "e" in text.lower():
            return "real"

        return "int"

    # --------------------------------------------------
    # Assignable e methodReceiver
    # --------------------------------------------------

    def resolveAssignableSymbol(self, ctx):
        base_ctx = ctx.assignableBase()

        if base_ctx.THIS():
            if not self.current_class:
                self.error(ctx, "'this' usado fora de classe")

            symbol = Symbol(
                name="this",
                type=self.current_class.name,
                kind="var",
                initialized=True
            )
        else:
            base_name = base_ctx.ID().getText()
            symbol = self.current_scope.resolve(base_name)

            if not symbol:
                self.error(ctx, f"variável '{base_name}' não declarado")

        return self.applyAccessSuffix(ctx, symbol, ctx.accessSuffix())

    def resolveMethodReceiverType(self, ctx):
        if ctx.THIS():
            if not self.current_class:
                self.error(ctx, "'this' usado fora de classe")

            symbol = Symbol(
                name="this",
                type=self.current_class.name,
                kind="var",
                initialized=True
            )
        else:
            base_name = ctx.ID().getText()
            symbol = self.current_scope.resolve(base_name)

            if not symbol:
                self.error(ctx, f"variável '{base_name}' não declarado")

        result = self.applyAccessSuffix(ctx, symbol, ctx.accessSuffix())
        return result.type

    def applyAccessSuffix(self, ctx, symbol, suffixes):
        result = Symbol(
            name=symbol.name,
            type=symbol.type,
            kind=symbol.kind,
            initialized=symbol.initialized,
            array_size=symbol.array_size
        )

        for suffix in suffixes:
            suffix_text = suffix.getText()

            if suffix_text.startswith("["):
                if not self.isArrayType(result.type):
                    self.error(suffix, f"'{result.name}' não é vetor")

                index_type = self.visit(suffix.expr())

                if index_type != "int":
                    self.error(suffix, "índice de vetor deve ser int")

                result = Symbol(
                    name=result.name,
                    type=self.elementType(result.type),
                    kind=result.kind,
                    initialized=result.initialized
                )

            elif suffix_text.startswith("."):
                attr_name = suffix.ID().getText()
                class_info = self.classes.get(result.type)

                if not class_info:
                    self.error(suffix, f"tipo '{result.type}' não possui atributos")

                if attr_name not in class_info.attributes:
                    self.error(
                        suffix,
                        f"atributo '{attr_name}' não existe em '{result.type}'"
                    )

                attr_symbol = class_info.attributes[attr_name]

                result = Symbol(
                    name=attr_symbol.name,
                    type=attr_symbol.type,
                    kind=attr_symbol.kind,
                    initialized=attr_symbol.initialized,
                    array_size=attr_symbol.array_size
                )

        return result

    # --------------------------------------------------
    # Utilitários
    # --------------------------------------------------

    def enterScope(self):
        self.current_scope = Scope(self.current_scope)

    def exitScope(self):
        self.current_scope = self.current_scope.parent

    def getParams(self, paramListCtx):
        params = []

        if not paramListCtx:
            return params

        seen = set()

        for p in paramListCtx.param():
            param_type = self.getType(p.type_())
            param_name = p.ID().getText()

            self.ensureTypeExists(p, param_type)

            if param_name in seen:
                self.error(p, f"parâmetro '{param_name}' duplicado")

            seen.add(param_name)
            params.append((param_type, param_name))

        return params

    def getType(self, ctx):
        base = ctx.getChild(0).getText()

        if ctx.arraySuffix():
            return f"{base}[]"

        return base

    def getArraySize(self, ctx):
        if not ctx.arraySuffix():
            return None

        return int(ctx.arraySuffix().INT_LITERAL().getText())

    def getReturnType(self, ctx):
        return ctx.getText()

    def ensureTypeExists(self, ctx, type_name):
        base = type_name.replace("[]", "")

        if base in self.primitive_types:
            return

        if base in self.classes:
            return

        if type_name == "void":
            return

        self.error(ctx, f"tipo '{base}' não declarado")

    def ensureAssignable(self, ctx, expected, actual):
        if expected == actual:
            return

        if actual == "null" and expected not in self.primitive_types and not self.isArrayType(expected):
            return

        self.error(
            ctx,
            f"não é possível atribuir {actual} a {expected}; use cast explícito se aplicável"
        )

    def checkArrayInitialization(self, ctx, expected_type, expected_size, actual_type):
        if ":" not in actual_type:
            self.error(ctx, f"vetor {expected_type} deve ser inicializado com lista de valores")

        actual_base, actual_len = actual_type.split(":")
        actual_len = int(actual_len)

        if actual_base == "unknown[]":
            return

        if actual_base != expected_type:
            self.error(ctx, f"vetor esperado {expected_type}, recebido {actual_base}")

        if expected_size is not None and actual_len != expected_size:
            self.error(
                ctx,
                f"vetor esperado com {expected_size} elemento(s), recebeu {actual_len}"
            )

    def checkCallArgs(self, ctx, name, expected_params, actual_args):
        if len(expected_params) != len(actual_args):
            self.error(
                ctx,
                f"'{name}' espera {len(expected_params)} argumento(s), recebeu {len(actual_args)}"
            )

        for i, actual in enumerate(actual_args):
            expected = expected_params[i][0]
            self.ensureAssignable(ctx, expected, actual)

    def blockHasReturn(self, block_ctx):
        for stmt in block_ctx.statement():
            if stmt.returnStmt():
                return True

            if stmt.ifStmt():
                if self.ifHasReturn(stmt.ifStmt()):
                    return True

        return False

    def ifHasReturn(self, if_ctx):
        if not self.blockHasReturn(if_ctx.block()):
            return False

        for elseif in if_ctx.elseIfPart():
            if not self.blockHasReturn(elseif.block()):
                return False

        if not if_ctx.elsePart():
            return False

        return self.blockHasReturn(if_ctx.elsePart().block())

    def isArrayType(self, type_name):
        return type_name.endswith("[]")

    def elementType(self, type_name):
        return type_name[:-2]

    def isNumeric(self, type_name):
        return type_name in {"int", "real"}
# Generated from SimplifiedJSS.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .SimplifiedJSSParser import SimplifiedJSSParser
else:
    from SimplifiedJSSParser import SimplifiedJSSParser

# This class defines a complete generic visitor for a parse tree produced by SimplifiedJSSParser.

class SimplifiedJSSVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by SimplifiedJSSParser#program.
    def visitProgram(self, ctx:SimplifiedJSSParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#topLevelDecl.
    def visitTopLevelDecl(self, ctx:SimplifiedJSSParser.TopLevelDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#varDecl.
    def visitVarDecl(self, ctx:SimplifiedJSSParser.VarDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#constDecl.
    def visitConstDecl(self, ctx:SimplifiedJSSParser.ConstDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#declaratorList.
    def visitDeclaratorList(self, ctx:SimplifiedJSSParser.DeclaratorListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#constDeclaratorList.
    def visitConstDeclaratorList(self, ctx:SimplifiedJSSParser.ConstDeclaratorListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#declarator.
    def visitDeclarator(self, ctx:SimplifiedJSSParser.DeclaratorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#constDeclarator.
    def visitConstDeclarator(self, ctx:SimplifiedJSSParser.ConstDeclaratorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#type.
    def visitType(self, ctx:SimplifiedJSSParser.TypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#primitiveType.
    def visitPrimitiveType(self, ctx:SimplifiedJSSParser.PrimitiveTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#arraySuffix.
    def visitArraySuffix(self, ctx:SimplifiedJSSParser.ArraySuffixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#functionDecl.
    def visitFunctionDecl(self, ctx:SimplifiedJSSParser.FunctionDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#returnType.
    def visitReturnType(self, ctx:SimplifiedJSSParser.ReturnTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#paramList.
    def visitParamList(self, ctx:SimplifiedJSSParser.ParamListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#param.
    def visitParam(self, ctx:SimplifiedJSSParser.ParamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#classDecl.
    def visitClassDecl(self, ctx:SimplifiedJSSParser.ClassDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#classMember.
    def visitClassMember(self, ctx:SimplifiedJSSParser.ClassMemberContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#attributeDecl.
    def visitAttributeDecl(self, ctx:SimplifiedJSSParser.AttributeDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#constructorDecl.
    def visitConstructorDecl(self, ctx:SimplifiedJSSParser.ConstructorDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#methodDecl.
    def visitMethodDecl(self, ctx:SimplifiedJSSParser.MethodDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#block.
    def visitBlock(self, ctx:SimplifiedJSSParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#statement.
    def visitStatement(self, ctx:SimplifiedJSSParser.StatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#ifStmt.
    def visitIfStmt(self, ctx:SimplifiedJSSParser.IfStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#elseIfPart.
    def visitElseIfPart(self, ctx:SimplifiedJSSParser.ElseIfPartContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#elsePart.
    def visitElsePart(self, ctx:SimplifiedJSSParser.ElsePartContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#whileStmt.
    def visitWhileStmt(self, ctx:SimplifiedJSSParser.WhileStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#forStmt.
    def visitForStmt(self, ctx:SimplifiedJSSParser.ForStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#breakStmt.
    def visitBreakStmt(self, ctx:SimplifiedJSSParser.BreakStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#returnStmt.
    def visitReturnStmt(self, ctx:SimplifiedJSSParser.ReturnStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#inputStmt.
    def visitInputStmt(self, ctx:SimplifiedJSSParser.InputStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#consoleLogStmt.
    def visitConsoleLogStmt(self, ctx:SimplifiedJSSParser.ConsoleLogStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#exprStmt.
    def visitExprStmt(self, ctx:SimplifiedJSSParser.ExprStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#assignableList.
    def visitAssignableList(self, ctx:SimplifiedJSSParser.AssignableListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#argumentList.
    def visitArgumentList(self, ctx:SimplifiedJSSParser.ArgumentListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#expr.
    def visitExpr(self, ctx:SimplifiedJSSParser.ExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#assignment.
    def visitAssignment(self, ctx:SimplifiedJSSParser.AssignmentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#assignOp.
    def visitAssignOp(self, ctx:SimplifiedJSSParser.AssignOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#logicalOr.
    def visitLogicalOr(self, ctx:SimplifiedJSSParser.LogicalOrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#logicalAnd.
    def visitLogicalAnd(self, ctx:SimplifiedJSSParser.LogicalAndContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#equality.
    def visitEquality(self, ctx:SimplifiedJSSParser.EqualityContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#relational.
    def visitRelational(self, ctx:SimplifiedJSSParser.RelationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#additive.
    def visitAdditive(self, ctx:SimplifiedJSSParser.AdditiveContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#multiplicative.
    def visitMultiplicative(self, ctx:SimplifiedJSSParser.MultiplicativeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#power.
    def visitPower(self, ctx:SimplifiedJSSParser.PowerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#unary.
    def visitUnary(self, ctx:SimplifiedJSSParser.UnaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#primary.
    def visitPrimary(self, ctx:SimplifiedJSSParser.PrimaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#newObject.
    def visitNewObject(self, ctx:SimplifiedJSSParser.NewObjectContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#functionCall.
    def visitFunctionCall(self, ctx:SimplifiedJSSParser.FunctionCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#methodCall.
    def visitMethodCall(self, ctx:SimplifiedJSSParser.MethodCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#methodReceiver.
    def visitMethodReceiver(self, ctx:SimplifiedJSSParser.MethodReceiverContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#castCall.
    def visitCastCall(self, ctx:SimplifiedJSSParser.CastCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#arrayLiteral.
    def visitArrayLiteral(self, ctx:SimplifiedJSSParser.ArrayLiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#assignable.
    def visitAssignable(self, ctx:SimplifiedJSSParser.AssignableContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#assignableBase.
    def visitAssignableBase(self, ctx:SimplifiedJSSParser.AssignableBaseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#accessSuffix.
    def visitAccessSuffix(self, ctx:SimplifiedJSSParser.AccessSuffixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SimplifiedJSSParser#literal.
    def visitLiteral(self, ctx:SimplifiedJSSParser.LiteralContext):
        return self.visitChildren(ctx)



del SimplifiedJSSParser
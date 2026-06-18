# Generated from SimplifiedJSS.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .SimplifiedJSSParser import SimplifiedJSSParser
else:
    from SimplifiedJSSParser import SimplifiedJSSParser

# This class defines a complete listener for a parse tree produced by SimplifiedJSSParser.
class SimplifiedJSSListener(ParseTreeListener):

    # Enter a parse tree produced by SimplifiedJSSParser#program.
    def enterProgram(self, ctx:SimplifiedJSSParser.ProgramContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#program.
    def exitProgram(self, ctx:SimplifiedJSSParser.ProgramContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#topLevelDecl.
    def enterTopLevelDecl(self, ctx:SimplifiedJSSParser.TopLevelDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#topLevelDecl.
    def exitTopLevelDecl(self, ctx:SimplifiedJSSParser.TopLevelDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#varDecl.
    def enterVarDecl(self, ctx:SimplifiedJSSParser.VarDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#varDecl.
    def exitVarDecl(self, ctx:SimplifiedJSSParser.VarDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#constDecl.
    def enterConstDecl(self, ctx:SimplifiedJSSParser.ConstDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#constDecl.
    def exitConstDecl(self, ctx:SimplifiedJSSParser.ConstDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#declaratorList.
    def enterDeclaratorList(self, ctx:SimplifiedJSSParser.DeclaratorListContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#declaratorList.
    def exitDeclaratorList(self, ctx:SimplifiedJSSParser.DeclaratorListContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#constDeclaratorList.
    def enterConstDeclaratorList(self, ctx:SimplifiedJSSParser.ConstDeclaratorListContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#constDeclaratorList.
    def exitConstDeclaratorList(self, ctx:SimplifiedJSSParser.ConstDeclaratorListContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#declarator.
    def enterDeclarator(self, ctx:SimplifiedJSSParser.DeclaratorContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#declarator.
    def exitDeclarator(self, ctx:SimplifiedJSSParser.DeclaratorContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#constDeclarator.
    def enterConstDeclarator(self, ctx:SimplifiedJSSParser.ConstDeclaratorContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#constDeclarator.
    def exitConstDeclarator(self, ctx:SimplifiedJSSParser.ConstDeclaratorContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#type.
    def enterType(self, ctx:SimplifiedJSSParser.TypeContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#type.
    def exitType(self, ctx:SimplifiedJSSParser.TypeContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#primitiveType.
    def enterPrimitiveType(self, ctx:SimplifiedJSSParser.PrimitiveTypeContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#primitiveType.
    def exitPrimitiveType(self, ctx:SimplifiedJSSParser.PrimitiveTypeContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#arraySuffix.
    def enterArraySuffix(self, ctx:SimplifiedJSSParser.ArraySuffixContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#arraySuffix.
    def exitArraySuffix(self, ctx:SimplifiedJSSParser.ArraySuffixContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#functionDecl.
    def enterFunctionDecl(self, ctx:SimplifiedJSSParser.FunctionDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#functionDecl.
    def exitFunctionDecl(self, ctx:SimplifiedJSSParser.FunctionDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#returnType.
    def enterReturnType(self, ctx:SimplifiedJSSParser.ReturnTypeContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#returnType.
    def exitReturnType(self, ctx:SimplifiedJSSParser.ReturnTypeContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#paramList.
    def enterParamList(self, ctx:SimplifiedJSSParser.ParamListContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#paramList.
    def exitParamList(self, ctx:SimplifiedJSSParser.ParamListContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#param.
    def enterParam(self, ctx:SimplifiedJSSParser.ParamContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#param.
    def exitParam(self, ctx:SimplifiedJSSParser.ParamContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#classDecl.
    def enterClassDecl(self, ctx:SimplifiedJSSParser.ClassDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#classDecl.
    def exitClassDecl(self, ctx:SimplifiedJSSParser.ClassDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#classMember.
    def enterClassMember(self, ctx:SimplifiedJSSParser.ClassMemberContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#classMember.
    def exitClassMember(self, ctx:SimplifiedJSSParser.ClassMemberContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#attributeDecl.
    def enterAttributeDecl(self, ctx:SimplifiedJSSParser.AttributeDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#attributeDecl.
    def exitAttributeDecl(self, ctx:SimplifiedJSSParser.AttributeDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#constructorDecl.
    def enterConstructorDecl(self, ctx:SimplifiedJSSParser.ConstructorDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#constructorDecl.
    def exitConstructorDecl(self, ctx:SimplifiedJSSParser.ConstructorDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#methodDecl.
    def enterMethodDecl(self, ctx:SimplifiedJSSParser.MethodDeclContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#methodDecl.
    def exitMethodDecl(self, ctx:SimplifiedJSSParser.MethodDeclContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#block.
    def enterBlock(self, ctx:SimplifiedJSSParser.BlockContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#block.
    def exitBlock(self, ctx:SimplifiedJSSParser.BlockContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#statement.
    def enterStatement(self, ctx:SimplifiedJSSParser.StatementContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#statement.
    def exitStatement(self, ctx:SimplifiedJSSParser.StatementContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#ifStmt.
    def enterIfStmt(self, ctx:SimplifiedJSSParser.IfStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#ifStmt.
    def exitIfStmt(self, ctx:SimplifiedJSSParser.IfStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#elseIfPart.
    def enterElseIfPart(self, ctx:SimplifiedJSSParser.ElseIfPartContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#elseIfPart.
    def exitElseIfPart(self, ctx:SimplifiedJSSParser.ElseIfPartContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#elsePart.
    def enterElsePart(self, ctx:SimplifiedJSSParser.ElsePartContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#elsePart.
    def exitElsePart(self, ctx:SimplifiedJSSParser.ElsePartContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#whileStmt.
    def enterWhileStmt(self, ctx:SimplifiedJSSParser.WhileStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#whileStmt.
    def exitWhileStmt(self, ctx:SimplifiedJSSParser.WhileStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#forStmt.
    def enterForStmt(self, ctx:SimplifiedJSSParser.ForStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#forStmt.
    def exitForStmt(self, ctx:SimplifiedJSSParser.ForStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#forInit.
    def enterForInit(self, ctx:SimplifiedJSSParser.ForInitContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#forInit.
    def exitForInit(self, ctx:SimplifiedJSSParser.ForInitContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#varDeclNoSemi.
    def enterVarDeclNoSemi(self, ctx:SimplifiedJSSParser.VarDeclNoSemiContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#varDeclNoSemi.
    def exitVarDeclNoSemi(self, ctx:SimplifiedJSSParser.VarDeclNoSemiContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#breakStmt.
    def enterBreakStmt(self, ctx:SimplifiedJSSParser.BreakStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#breakStmt.
    def exitBreakStmt(self, ctx:SimplifiedJSSParser.BreakStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#returnStmt.
    def enterReturnStmt(self, ctx:SimplifiedJSSParser.ReturnStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#returnStmt.
    def exitReturnStmt(self, ctx:SimplifiedJSSParser.ReturnStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#inputStmt.
    def enterInputStmt(self, ctx:SimplifiedJSSParser.InputStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#inputStmt.
    def exitInputStmt(self, ctx:SimplifiedJSSParser.InputStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#consoleLogStmt.
    def enterConsoleLogStmt(self, ctx:SimplifiedJSSParser.ConsoleLogStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#consoleLogStmt.
    def exitConsoleLogStmt(self, ctx:SimplifiedJSSParser.ConsoleLogStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#exprStmt.
    def enterExprStmt(self, ctx:SimplifiedJSSParser.ExprStmtContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#exprStmt.
    def exitExprStmt(self, ctx:SimplifiedJSSParser.ExprStmtContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#assignableList.
    def enterAssignableList(self, ctx:SimplifiedJSSParser.AssignableListContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#assignableList.
    def exitAssignableList(self, ctx:SimplifiedJSSParser.AssignableListContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#argumentList.
    def enterArgumentList(self, ctx:SimplifiedJSSParser.ArgumentListContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#argumentList.
    def exitArgumentList(self, ctx:SimplifiedJSSParser.ArgumentListContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#expr.
    def enterExpr(self, ctx:SimplifiedJSSParser.ExprContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#expr.
    def exitExpr(self, ctx:SimplifiedJSSParser.ExprContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#assignment.
    def enterAssignment(self, ctx:SimplifiedJSSParser.AssignmentContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#assignment.
    def exitAssignment(self, ctx:SimplifiedJSSParser.AssignmentContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#assignOp.
    def enterAssignOp(self, ctx:SimplifiedJSSParser.AssignOpContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#assignOp.
    def exitAssignOp(self, ctx:SimplifiedJSSParser.AssignOpContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#logicalOr.
    def enterLogicalOr(self, ctx:SimplifiedJSSParser.LogicalOrContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#logicalOr.
    def exitLogicalOr(self, ctx:SimplifiedJSSParser.LogicalOrContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#logicalAnd.
    def enterLogicalAnd(self, ctx:SimplifiedJSSParser.LogicalAndContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#logicalAnd.
    def exitLogicalAnd(self, ctx:SimplifiedJSSParser.LogicalAndContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#equality.
    def enterEquality(self, ctx:SimplifiedJSSParser.EqualityContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#equality.
    def exitEquality(self, ctx:SimplifiedJSSParser.EqualityContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#relational.
    def enterRelational(self, ctx:SimplifiedJSSParser.RelationalContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#relational.
    def exitRelational(self, ctx:SimplifiedJSSParser.RelationalContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#additive.
    def enterAdditive(self, ctx:SimplifiedJSSParser.AdditiveContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#additive.
    def exitAdditive(self, ctx:SimplifiedJSSParser.AdditiveContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#multiplicative.
    def enterMultiplicative(self, ctx:SimplifiedJSSParser.MultiplicativeContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#multiplicative.
    def exitMultiplicative(self, ctx:SimplifiedJSSParser.MultiplicativeContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#power.
    def enterPower(self, ctx:SimplifiedJSSParser.PowerContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#power.
    def exitPower(self, ctx:SimplifiedJSSParser.PowerContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#unary.
    def enterUnary(self, ctx:SimplifiedJSSParser.UnaryContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#unary.
    def exitUnary(self, ctx:SimplifiedJSSParser.UnaryContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#postfix.
    def enterPostfix(self, ctx:SimplifiedJSSParser.PostfixContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#postfix.
    def exitPostfix(self, ctx:SimplifiedJSSParser.PostfixContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#primary.
    def enterPrimary(self, ctx:SimplifiedJSSParser.PrimaryContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#primary.
    def exitPrimary(self, ctx:SimplifiedJSSParser.PrimaryContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#newObject.
    def enterNewObject(self, ctx:SimplifiedJSSParser.NewObjectContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#newObject.
    def exitNewObject(self, ctx:SimplifiedJSSParser.NewObjectContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#functionCall.
    def enterFunctionCall(self, ctx:SimplifiedJSSParser.FunctionCallContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#functionCall.
    def exitFunctionCall(self, ctx:SimplifiedJSSParser.FunctionCallContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#methodCall.
    def enterMethodCall(self, ctx:SimplifiedJSSParser.MethodCallContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#methodCall.
    def exitMethodCall(self, ctx:SimplifiedJSSParser.MethodCallContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#methodReceiver.
    def enterMethodReceiver(self, ctx:SimplifiedJSSParser.MethodReceiverContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#methodReceiver.
    def exitMethodReceiver(self, ctx:SimplifiedJSSParser.MethodReceiverContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#castCall.
    def enterCastCall(self, ctx:SimplifiedJSSParser.CastCallContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#castCall.
    def exitCastCall(self, ctx:SimplifiedJSSParser.CastCallContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#arrayLiteral.
    def enterArrayLiteral(self, ctx:SimplifiedJSSParser.ArrayLiteralContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#arrayLiteral.
    def exitArrayLiteral(self, ctx:SimplifiedJSSParser.ArrayLiteralContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#assignable.
    def enterAssignable(self, ctx:SimplifiedJSSParser.AssignableContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#assignable.
    def exitAssignable(self, ctx:SimplifiedJSSParser.AssignableContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#assignableBase.
    def enterAssignableBase(self, ctx:SimplifiedJSSParser.AssignableBaseContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#assignableBase.
    def exitAssignableBase(self, ctx:SimplifiedJSSParser.AssignableBaseContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#accessSuffix.
    def enterAccessSuffix(self, ctx:SimplifiedJSSParser.AccessSuffixContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#accessSuffix.
    def exitAccessSuffix(self, ctx:SimplifiedJSSParser.AccessSuffixContext):
        pass


    # Enter a parse tree produced by SimplifiedJSSParser#literal.
    def enterLiteral(self, ctx:SimplifiedJSSParser.LiteralContext):
        pass

    # Exit a parse tree produced by SimplifiedJSSParser#literal.
    def exitLiteral(self, ctx:SimplifiedJSSParser.LiteralContext):
        pass



del SimplifiedJSSParser
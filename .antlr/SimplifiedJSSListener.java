// Generated from /home/lkl/Área de Trabalho/PY/Compiladores/FrontEnd (cópia)/SimplifiedJSS.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimplifiedJSSParser}.
 */
public interface SimplifiedJSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimplifiedJSSParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimplifiedJSSParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDecl(SimplifiedJSSParser.TopLevelDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDecl(SimplifiedJSSParser.TopLevelDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(SimplifiedJSSParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(SimplifiedJSSParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(SimplifiedJSSParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(SimplifiedJSSParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#declaratorList}.
	 * @param ctx the parse tree
	 */
	void enterDeclaratorList(SimplifiedJSSParser.DeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#declaratorList}.
	 * @param ctx the parse tree
	 */
	void exitDeclaratorList(SimplifiedJSSParser.DeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#constDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaratorList(SimplifiedJSSParser.ConstDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#constDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaratorList(SimplifiedJSSParser.ConstDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(SimplifiedJSSParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(SimplifiedJSSParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#constDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclarator(SimplifiedJSSParser.ConstDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#constDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclarator(SimplifiedJSSParser.ConstDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimplifiedJSSParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimplifiedJSSParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(SimplifiedJSSParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(SimplifiedJSSParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#arraySuffix}.
	 * @param ctx the parse tree
	 */
	void enterArraySuffix(SimplifiedJSSParser.ArraySuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#arraySuffix}.
	 * @param ctx the parse tree
	 */
	void exitArraySuffix(SimplifiedJSSParser.ArraySuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(SimplifiedJSSParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(SimplifiedJSSParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(SimplifiedJSSParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(SimplifiedJSSParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(SimplifiedJSSParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(SimplifiedJSSParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(SimplifiedJSSParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(SimplifiedJSSParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(SimplifiedJSSParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(SimplifiedJSSParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(SimplifiedJSSParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(SimplifiedJSSParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#attributeDecl}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDecl(SimplifiedJSSParser.AttributeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#attributeDecl}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDecl(SimplifiedJSSParser.AttributeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDecl(SimplifiedJSSParser.ConstructorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDecl(SimplifiedJSSParser.ConstructorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(SimplifiedJSSParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(SimplifiedJSSParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimplifiedJSSParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimplifiedJSSParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimplifiedJSSParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimplifiedJSSParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(SimplifiedJSSParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(SimplifiedJSSParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#elseIfPart}.
	 * @param ctx the parse tree
	 */
	void enterElseIfPart(SimplifiedJSSParser.ElseIfPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#elseIfPart}.
	 * @param ctx the parse tree
	 */
	void exitElseIfPart(SimplifiedJSSParser.ElseIfPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void enterElsePart(SimplifiedJSSParser.ElsePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void exitElsePart(SimplifiedJSSParser.ElsePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(SimplifiedJSSParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(SimplifiedJSSParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(SimplifiedJSSParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(SimplifiedJSSParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(SimplifiedJSSParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(SimplifiedJSSParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(SimplifiedJSSParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(SimplifiedJSSParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void enterInputStmt(SimplifiedJSSParser.InputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void exitInputStmt(SimplifiedJSSParser.InputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#consoleLogStmt}.
	 * @param ctx the parse tree
	 */
	void enterConsoleLogStmt(SimplifiedJSSParser.ConsoleLogStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#consoleLogStmt}.
	 * @param ctx the parse tree
	 */
	void exitConsoleLogStmt(SimplifiedJSSParser.ConsoleLogStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(SimplifiedJSSParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(SimplifiedJSSParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#assignableList}.
	 * @param ctx the parse tree
	 */
	void enterAssignableList(SimplifiedJSSParser.AssignableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#assignableList}.
	 * @param ctx the parse tree
	 */
	void exitAssignableList(SimplifiedJSSParser.AssignableListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(SimplifiedJSSParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(SimplifiedJSSParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimplifiedJSSParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimplifiedJSSParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimplifiedJSSParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimplifiedJSSParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(SimplifiedJSSParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(SimplifiedJSSParser.AssignOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#logicalOr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(SimplifiedJSSParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#logicalOr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(SimplifiedJSSParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#logicalAnd}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(SimplifiedJSSParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#logicalAnd}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(SimplifiedJSSParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(SimplifiedJSSParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(SimplifiedJSSParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(SimplifiedJSSParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(SimplifiedJSSParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(SimplifiedJSSParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(SimplifiedJSSParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(SimplifiedJSSParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(SimplifiedJSSParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#power}.
	 * @param ctx the parse tree
	 */
	void enterPower(SimplifiedJSSParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#power}.
	 * @param ctx the parse tree
	 */
	void exitPower(SimplifiedJSSParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(SimplifiedJSSParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(SimplifiedJSSParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SimplifiedJSSParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SimplifiedJSSParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#newObject}.
	 * @param ctx the parse tree
	 */
	void enterNewObject(SimplifiedJSSParser.NewObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#newObject}.
	 * @param ctx the parse tree
	 */
	void exitNewObject(SimplifiedJSSParser.NewObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimplifiedJSSParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimplifiedJSSParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(SimplifiedJSSParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(SimplifiedJSSParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#methodReceiver}.
	 * @param ctx the parse tree
	 */
	void enterMethodReceiver(SimplifiedJSSParser.MethodReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#methodReceiver}.
	 * @param ctx the parse tree
	 */
	void exitMethodReceiver(SimplifiedJSSParser.MethodReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#castCall}.
	 * @param ctx the parse tree
	 */
	void enterCastCall(SimplifiedJSSParser.CastCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#castCall}.
	 * @param ctx the parse tree
	 */
	void exitCastCall(SimplifiedJSSParser.CastCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(SimplifiedJSSParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(SimplifiedJSSParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(SimplifiedJSSParser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(SimplifiedJSSParser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#assignableBase}.
	 * @param ctx the parse tree
	 */
	void enterAssignableBase(SimplifiedJSSParser.AssignableBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#assignableBase}.
	 * @param ctx the parse tree
	 */
	void exitAssignableBase(SimplifiedJSSParser.AssignableBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#accessSuffix}.
	 * @param ctx the parse tree
	 */
	void enterAccessSuffix(SimplifiedJSSParser.AccessSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#accessSuffix}.
	 * @param ctx the parse tree
	 */
	void exitAccessSuffix(SimplifiedJSSParser.AccessSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifiedJSSParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SimplifiedJSSParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifiedJSSParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SimplifiedJSSParser.LiteralContext ctx);
}
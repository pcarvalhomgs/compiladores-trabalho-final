// Generated from /home/lkl/Área de Trabalho/PY/Compiladores/FrontEnd (cópia)/SimplifiedJSS.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimplifiedJSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, CONST=2, FUNCTION=3, CLASS=4, CONSTRUCTOR=5, NEW=6, THIS=7, IF=8, 
		ELSE=9, WHILE=10, FOR=11, BREAK=12, RETURN=13, VOID=14, INT=15, REAL=16, 
		STR=17, BOOL=18, TRUE=19, FALSE=20, NULL=21, INPUT=22, CONSOLE=23, LOG=24, 
		PLUS_ASSIGN=25, MINUS_ASSIGN=26, MUL_ASSIGN=27, DIV_ASSIGN=28, MOD_ASSIGN=29, 
		EQ=30, NEQ=31, GTE=32, LTE=33, AND=34, OR=35, INC=36, DEC=37, POW=38, 
		ASSIGN=39, GT=40, LT=41, NOT=42, PLUS=43, MINUS=44, MUL=45, DIV=46, MOD=47, 
		LPAREN=48, RPAREN=49, LBRACE=50, RBRACE=51, LBRACK=52, RBRACK=53, SEMI=54, 
		COMMA=55, DOT=56, REAL_LITERAL=57, INT_LITERAL=58, STRING_LITERAL=59, 
		ID=60, LINE_COMMENT=61, WS=62;
	public static final int
		RULE_program = 0, RULE_topLevelDecl = 1, RULE_varDecl = 2, RULE_constDecl = 3, 
		RULE_declaratorList = 4, RULE_constDeclaratorList = 5, RULE_declarator = 6, 
		RULE_constDeclarator = 7, RULE_type = 8, RULE_primitiveType = 9, RULE_arraySuffix = 10, 
		RULE_functionDecl = 11, RULE_returnType = 12, RULE_paramList = 13, RULE_param = 14, 
		RULE_classDecl = 15, RULE_classMember = 16, RULE_attributeDecl = 17, RULE_constructorDecl = 18, 
		RULE_methodDecl = 19, RULE_block = 20, RULE_statement = 21, RULE_ifStmt = 22, 
		RULE_elseIfPart = 23, RULE_elsePart = 24, RULE_whileStmt = 25, RULE_forStmt = 26, 
		RULE_breakStmt = 27, RULE_returnStmt = 28, RULE_inputStmt = 29, RULE_consoleLogStmt = 30, 
		RULE_exprStmt = 31, RULE_assignableList = 32, RULE_argumentList = 33, 
		RULE_expr = 34, RULE_assignment = 35, RULE_assignOp = 36, RULE_logicalOr = 37, 
		RULE_logicalAnd = 38, RULE_equality = 39, RULE_relational = 40, RULE_additive = 41, 
		RULE_multiplicative = 42, RULE_power = 43, RULE_unary = 44, RULE_primary = 45, 
		RULE_newObject = 46, RULE_functionCall = 47, RULE_methodCall = 48, RULE_methodReceiver = 49, 
		RULE_castCall = 50, RULE_arrayLiteral = 51, RULE_assignable = 52, RULE_assignableBase = 53, 
		RULE_accessSuffix = 54, RULE_literal = 55;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "topLevelDecl", "varDecl", "constDecl", "declaratorList", 
			"constDeclaratorList", "declarator", "constDeclarator", "type", "primitiveType", 
			"arraySuffix", "functionDecl", "returnType", "paramList", "param", "classDecl", 
			"classMember", "attributeDecl", "constructorDecl", "methodDecl", "block", 
			"statement", "ifStmt", "elseIfPart", "elsePart", "whileStmt", "forStmt", 
			"breakStmt", "returnStmt", "inputStmt", "consoleLogStmt", "exprStmt", 
			"assignableList", "argumentList", "expr", "assignment", "assignOp", "logicalOr", 
			"logicalAnd", "equality", "relational", "additive", "multiplicative", 
			"power", "unary", "primary", "newObject", "functionCall", "methodCall", 
			"methodReceiver", "castCall", "arrayLiteral", "assignable", "assignableBase", 
			"accessSuffix", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'const'", "'function'", "'class'", "'constructor'", "'new'", 
			"'this'", "'if'", "'else'", "'while'", "'for'", "'break'", "'return'", 
			"'void'", "'int'", "'real'", "'str'", "'bool'", "'true'", "'false'", 
			"'null'", "'input'", "'console'", "'log'", "'+='", "'-='", "'*='", "'/='", 
			"'%='", "'=='", "'!='", "'>='", "'<='", "'&&'", "'||'", "'++'", "'--'", 
			"'**'", "'='", "'>'", "'<'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "CONST", "FUNCTION", "CLASS", "CONSTRUCTOR", "NEW", "THIS", 
			"IF", "ELSE", "WHILE", "FOR", "BREAK", "RETURN", "VOID", "INT", "REAL", 
			"STR", "BOOL", "TRUE", "FALSE", "NULL", "INPUT", "CONSOLE", "LOG", "PLUS_ASSIGN", 
			"MINUS_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "EQ", "NEQ", 
			"GTE", "LTE", "AND", "OR", "INC", "DEC", "POW", "ASSIGN", "GT", "LT", 
			"NOT", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "REAL_LITERAL", 
			"INT_LITERAL", "STRING_LITERAL", "ID", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimplifiedJSS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimplifiedJSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimplifiedJSSParser.EOF, 0); }
		public List<TopLevelDeclContext> topLevelDecl() {
			return getRuleContexts(TopLevelDeclContext.class);
		}
		public TopLevelDeclContext topLevelDecl(int i) {
			return getRuleContext(TopLevelDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0)) {
				{
				{
				setState(112);
				topLevelDecl();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TopLevelDeclContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public TopLevelDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterTopLevelDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitTopLevelDecl(this);
		}
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDecl);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				varDecl();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				constDecl();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				functionDecl();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				classDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(SimplifiedJSSParser.LET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclaratorListContext declaratorList() {
			return getRuleContext(DeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(LET);
			setState(127);
			type();
			setState(128);
			declaratorList();
			setState(129);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(SimplifiedJSSParser.CONST, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ConstDeclaratorListContext constDeclaratorList() {
			return getRuleContext(ConstDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitConstDecl(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(CONST);
			setState(132);
			type();
			setState(133);
			constDeclaratorList();
			setState(134);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorListContext extends ParserRuleContext {
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimplifiedJSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimplifiedJSSParser.COMMA, i);
		}
		public DeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitDeclaratorList(this);
		}
	}

	public final DeclaratorListContext declaratorList() throws RecognitionException {
		DeclaratorListContext _localctx = new DeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			declarator();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(137);
				match(COMMA);
				setState(138);
				declarator();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclaratorListContext extends ParserRuleContext {
		public List<ConstDeclaratorContext> constDeclarator() {
			return getRuleContexts(ConstDeclaratorContext.class);
		}
		public ConstDeclaratorContext constDeclarator(int i) {
			return getRuleContext(ConstDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimplifiedJSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimplifiedJSSParser.COMMA, i);
		}
		public ConstDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterConstDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitConstDeclaratorList(this);
		}
	}

	public final ConstDeclaratorListContext constDeclaratorList() throws RecognitionException {
		ConstDeclaratorListContext _localctx = new ConstDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			constDeclarator();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(145);
				match(COMMA);
				setState(146);
				constDeclarator();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SimplifiedJSSParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitDeclarator(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(ID);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(153);
				match(ASSIGN);
				setState(154);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclaratorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SimplifiedJSSParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterConstDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitConstDeclarator(this);
		}
	}

	public final ConstDeclaratorContext constDeclarator() throws RecognitionException {
		ConstDeclaratorContext _localctx = new ConstDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(ID);
			setState(158);
			match(ASSIGN);
			setState(159);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ArraySuffixContext arraySuffix() {
			return getRuleContext(ArraySuffixContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case REAL:
			case STR:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				primitiveType();
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(162);
					arraySuffix();
					}
				}

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(ID);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(166);
					arraySuffix();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SimplifiedJSSParser.INT, 0); }
		public TerminalNode REAL() { return getToken(SimplifiedJSSParser.REAL, 0); }
		public TerminalNode STR() { return getToken(SimplifiedJSSParser.STR, 0); }
		public TerminalNode BOOL() { return getToken(SimplifiedJSSParser.BOOL, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 491520L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArraySuffixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(SimplifiedJSSParser.LBRACK, 0); }
		public TerminalNode INT_LITERAL() { return getToken(SimplifiedJSSParser.INT_LITERAL, 0); }
		public TerminalNode RBRACK() { return getToken(SimplifiedJSSParser.RBRACK, 0); }
		public ArraySuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterArraySuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitArraySuffix(this);
		}
	}

	public final ArraySuffixContext arraySuffix() throws RecognitionException {
		ArraySuffixContext _localctx = new ArraySuffixContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arraySuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(LBRACK);
			setState(174);
			match(INT_LITERAL);
			setState(175);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(SimplifiedJSSParser.FUNCTION, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(FUNCTION);
			setState(178);
			returnType();
			setState(179);
			match(ID);
			setState(180);
			match(LPAREN);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921504607338496L) != 0)) {
				{
				setState(181);
				paramList();
				}
			}

			setState(184);
			match(RPAREN);
			setState(185);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SimplifiedJSSParser.VOID, 0); }
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitReturnType(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnType);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case REAL:
			case STR:
			case BOOL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimplifiedJSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimplifiedJSSParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			param();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(192);
				match(COMMA);
				setState(193);
				param();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			type();
			setState(200);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(SimplifiedJSSParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(SimplifiedJSSParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimplifiedJSSParser.RBRACE, 0); }
		public List<ClassMemberContext> classMember() {
			return getRuleContexts(ClassMemberContext.class);
		}
		public ClassMemberContext classMember(int i) {
			return getRuleContext(ClassMemberContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitClassDecl(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(CLASS);
			setState(203);
			match(ID);
			setState(204);
			match(LBRACE);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921504607338496L) != 0)) {
				{
				{
				setState(205);
				classMember();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(211);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberContext extends ParserRuleContext {
		public AttributeDeclContext attributeDecl() {
			return getRuleContext(AttributeDeclContext.class,0);
		}
		public ConstructorDeclContext constructorDecl() {
			return getRuleContext(ConstructorDeclContext.class,0);
		}
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitClassMember(this);
		}
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classMember);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				attributeDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				constructorDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				methodDecl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public AttributeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAttributeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAttributeDecl(this);
		}
	}

	public final AttributeDeclContext attributeDecl() throws RecognitionException {
		AttributeDeclContext _localctx = new AttributeDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_attributeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			type();
			setState(219);
			match(ID);
			setState(220);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode CONSTRUCTOR() { return getToken(SimplifiedJSSParser.CONSTRUCTOR, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ConstructorDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterConstructorDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitConstructorDecl(this);
		}
	}

	public final ConstructorDeclContext constructorDecl() throws RecognitionException {
		ConstructorDeclContext _localctx = new ConstructorDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constructorDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(ID);
			setState(223);
			match(CONSTRUCTOR);
			setState(224);
			match(LPAREN);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921504607338496L) != 0)) {
				{
				setState(225);
				paramList();
				}
			}

			setState(228);
			match(RPAREN);
			setState(229);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitMethodDecl(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			type();
			setState(232);
			match(ID);
			setState(233);
			match(LPAREN);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921504607338496L) != 0)) {
				{
				setState(234);
				paramList();
				}
			}

			setState(237);
			match(RPAREN);
			setState(238);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SimplifiedJSSParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimplifiedJSSParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(LBRACE);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2167669788149530054L) != 0)) {
				{
				{
				setState(241);
				statement();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(247);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public InputStmtContext inputStmt() {
			return getRuleContext(InputStmtContext.class,0);
		}
		public ConsoleLogStmtContext consoleLogStmt() {
			return getRuleContext(ConsoleLogStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				varDecl();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				constDecl();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				ifStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(252);
				whileStmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(253);
				forStmt();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 6);
				{
				setState(254);
				breakStmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 7);
				{
				setState(255);
				returnStmt();
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 8);
				{
				setState(256);
				inputStmt();
				}
				break;
			case CONSOLE:
				enterOuterAlt(_localctx, 9);
				{
				setState(257);
				consoleLogStmt();
				}
				break;
			case NEW:
			case THIS:
			case INT:
			case REAL:
			case STR:
			case BOOL:
			case TRUE:
			case FALSE:
			case NULL:
			case INC:
			case DEC:
			case NOT:
			case PLUS:
			case MINUS:
			case LPAREN:
			case LBRACK:
			case REAL_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 10);
				{
				setState(258);
				exprStmt();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 11);
				{
				setState(259);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SimplifiedJSSParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ElseIfPartContext> elseIfPart() {
			return getRuleContexts(ElseIfPartContext.class);
		}
		public ElseIfPartContext elseIfPart(int i) {
			return getRuleContext(ElseIfPartContext.class,i);
		}
		public ElsePartContext elsePart() {
			return getRuleContext(ElsePartContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(IF);
			setState(263);
			match(LPAREN);
			setState(264);
			expr();
			setState(265);
			match(RPAREN);
			setState(266);
			block();
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(267);
					elseIfPart();
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(273);
				elsePart();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfPartContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(SimplifiedJSSParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(SimplifiedJSSParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterElseIfPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitElseIfPart(this);
		}
	}

	public final ElseIfPartContext elseIfPart() throws RecognitionException {
		ElseIfPartContext _localctx = new ElseIfPartContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_elseIfPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(ELSE);
			setState(277);
			match(IF);
			setState(278);
			match(LPAREN);
			setState(279);
			expr();
			setState(280);
			match(RPAREN);
			setState(281);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsePartContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(SimplifiedJSSParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElsePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterElsePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitElsePart(this);
		}
	}

	public final ElsePartContext elsePart() throws RecognitionException {
		ElsePartContext _localctx = new ElsePartContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_elsePart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(ELSE);
			setState(284);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SimplifiedJSSParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(WHILE);
			setState(287);
			match(LPAREN);
			setState(288);
			expr();
			setState(289);
			match(RPAREN);
			setState(290);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SimplifiedJSSParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(SimplifiedJSSParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(SimplifiedJSSParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitForStmt(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(FOR);
			setState(293);
			match(LPAREN);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(294);
				expr();
				}
			}

			setState(297);
			match(SEMI);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(298);
				expr();
				}
			}

			setState(301);
			match(SEMI);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(302);
				expr();
				}
			}

			setState(305);
			match(RPAREN);
			setState(306);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(SimplifiedJSSParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitBreakStmt(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(BREAK);
			setState(309);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(SimplifiedJSSParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(RETURN);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(312);
				expr();
				}
			}

			setState(315);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputStmtContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(SimplifiedJSSParser.INPUT, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public AssignableListContext assignableList() {
			return getRuleContext(AssignableListContext.class,0);
		}
		public InputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterInputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitInputStmt(this);
		}
	}

	public final InputStmtContext inputStmt() throws RecognitionException {
		InputStmtContext _localctx = new InputStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_inputStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(INPUT);
			setState(318);
			match(LPAREN);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THIS || _la==ID) {
				{
				setState(319);
				assignableList();
				}
			}

			setState(322);
			match(RPAREN);
			setState(323);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConsoleLogStmtContext extends ParserRuleContext {
		public TerminalNode CONSOLE() { return getToken(SimplifiedJSSParser.CONSOLE, 0); }
		public TerminalNode DOT() { return getToken(SimplifiedJSSParser.DOT, 0); }
		public TerminalNode LOG() { return getToken(SimplifiedJSSParser.LOG, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ConsoleLogStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consoleLogStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterConsoleLogStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitConsoleLogStmt(this);
		}
	}

	public final ConsoleLogStmtContext consoleLogStmt() throws RecognitionException {
		ConsoleLogStmtContext _localctx = new ConsoleLogStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_consoleLogStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(CONSOLE);
			setState(326);
			match(DOT);
			setState(327);
			match(LOG);
			setState(328);
			match(LPAREN);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(329);
				argumentList();
				}
			}

			setState(332);
			match(RPAREN);
			setState(333);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimplifiedJSSParser.SEMI, 0); }
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitExprStmt(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			expr();
			setState(336);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableListContext extends ParserRuleContext {
		public List<AssignableContext> assignable() {
			return getRuleContexts(AssignableContext.class);
		}
		public AssignableContext assignable(int i) {
			return getRuleContext(AssignableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimplifiedJSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimplifiedJSSParser.COMMA, i);
		}
		public AssignableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAssignableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAssignableList(this);
		}
	}

	public final AssignableListContext assignableList() throws RecognitionException {
		AssignableListContext _localctx = new AssignableListContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_assignableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			assignable();
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(339);
				match(COMMA);
				setState(340);
				assignable();
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimplifiedJSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimplifiedJSSParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			expr();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(347);
				match(COMMA);
				setState(348);
				expr();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LogicalOrContext logicalOr() {
			return getRuleContext(LogicalOrContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_assignment);
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				assignable();
				setState(357);
				assignOp();
				setState(358);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				logicalOr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignOpContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(SimplifiedJSSParser.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(SimplifiedJSSParser.PLUS_ASSIGN, 0); }
		public TerminalNode MINUS_ASSIGN() { return getToken(SimplifiedJSSParser.MINUS_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(SimplifiedJSSParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(SimplifiedJSSParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(SimplifiedJSSParser.MOD_ASSIGN, 0); }
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAssignOp(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 550796001280L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrContext extends ParserRuleContext {
		public List<LogicalAndContext> logicalAnd() {
			return getRuleContexts(LogicalAndContext.class);
		}
		public LogicalAndContext logicalAnd(int i) {
			return getRuleContext(LogicalAndContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SimplifiedJSSParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SimplifiedJSSParser.OR, i);
		}
		public LogicalOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterLogicalOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitLogicalOr(this);
		}
	}

	public final LogicalOrContext logicalOr() throws RecognitionException {
		LogicalOrContext _localctx = new LogicalOrContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_logicalOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			logicalAnd();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(366);
				match(OR);
				setState(367);
				logicalAnd();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndContext extends ParserRuleContext {
		public List<EqualityContext> equality() {
			return getRuleContexts(EqualityContext.class);
		}
		public EqualityContext equality(int i) {
			return getRuleContext(EqualityContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SimplifiedJSSParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SimplifiedJSSParser.AND, i);
		}
		public LogicalAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterLogicalAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitLogicalAnd(this);
		}
	}

	public final LogicalAndContext logicalAnd() throws RecognitionException {
		LogicalAndContext _localctx = new LogicalAndContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_logicalAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			equality();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(374);
				match(AND);
				setState(375);
				equality();
				}
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ParserRuleContext {
		public List<RelationalContext> relational() {
			return getRuleContexts(RelationalContext.class);
		}
		public RelationalContext relational(int i) {
			return getRuleContext(RelationalContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(SimplifiedJSSParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(SimplifiedJSSParser.EQ, i);
		}
		public List<TerminalNode> NEQ() { return getTokens(SimplifiedJSSParser.NEQ); }
		public TerminalNode NEQ(int i) {
			return getToken(SimplifiedJSSParser.NEQ, i);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitEquality(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			relational();
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQ || _la==NEQ) {
				{
				{
				setState(382);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(383);
				relational();
				}
				}
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ParserRuleContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(SimplifiedJSSParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(SimplifiedJSSParser.GT, i);
		}
		public List<TerminalNode> GTE() { return getTokens(SimplifiedJSSParser.GTE); }
		public TerminalNode GTE(int i) {
			return getToken(SimplifiedJSSParser.GTE, i);
		}
		public List<TerminalNode> LT() { return getTokens(SimplifiedJSSParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(SimplifiedJSSParser.LT, i);
		}
		public List<TerminalNode> LTE() { return getTokens(SimplifiedJSSParser.LTE); }
		public TerminalNode LTE(int i) {
			return getToken(SimplifiedJSSParser.LTE, i);
		}
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitRelational(this);
		}
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_relational);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			additive();
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3311419785216L) != 0)) {
				{
				{
				setState(390);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3311419785216L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(391);
				additive();
				}
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveContext extends ParserRuleContext {
		public List<MultiplicativeContext> multiplicative() {
			return getRuleContexts(MultiplicativeContext.class);
		}
		public MultiplicativeContext multiplicative(int i) {
			return getRuleContext(MultiplicativeContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SimplifiedJSSParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SimplifiedJSSParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SimplifiedJSSParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SimplifiedJSSParser.MINUS, i);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAdditive(this);
		}
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_additive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			multiplicative();
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(398);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(399);
				multiplicative();
				}
				}
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeContext extends ParserRuleContext {
		public List<PowerContext> power() {
			return getRuleContexts(PowerContext.class);
		}
		public PowerContext power(int i) {
			return getRuleContext(PowerContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(SimplifiedJSSParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(SimplifiedJSSParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SimplifiedJSSParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SimplifiedJSSParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(SimplifiedJSSParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(SimplifiedJSSParser.MOD, i);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitMultiplicative(this);
		}
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_multiplicative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			power();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 246290604621824L) != 0)) {
				{
				{
				setState(406);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 246290604621824L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(407);
				power();
				}
				}
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PowerContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode POW() { return getToken(SimplifiedJSSParser.POW, 0); }
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public PowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitPower(this);
		}
	}

	public final PowerContext power() throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_power);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			unary();
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POW) {
				{
				setState(414);
				match(POW);
				setState(415);
				power();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SimplifiedJSSParser.NOT, 0); }
		public TerminalNode PLUS() { return getToken(SimplifiedJSSParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SimplifiedJSSParser.MINUS, 0); }
		public TerminalNode INC() { return getToken(SimplifiedJSSParser.INC, 0); }
		public TerminalNode DEC() { return getToken(SimplifiedJSSParser.DEC, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_unary);
		int _la;
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INC:
			case DEC:
			case NOT:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30992484007936L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(419);
				unary();
				}
				break;
			case NEW:
			case THIS:
			case INT:
			case REAL:
			case STR:
			case BOOL:
			case TRUE:
			case FALSE:
			case NULL:
			case LPAREN:
			case LBRACK:
			case REAL_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public NewObjectContext newObject() {
			return getRuleContext(NewObjectContext.class,0);
		}
		public CastCallContext castCall() {
			return getRuleContext(CastCallContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_primary);
		try {
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				newObject();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				castCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
				methodCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(427);
				functionCall();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(428);
				assignable();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(429);
				arrayLiteral();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(430);
				match(LPAREN);
				setState(431);
				expr();
				setState(432);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewObjectContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(SimplifiedJSSParser.NEW, 0); }
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public NewObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterNewObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitNewObject(this);
		}
	}

	public final NewObjectContext newObject() throws RecognitionException {
		NewObjectContext _localctx = new NewObjectContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_newObject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			match(NEW);
			setState(437);
			match(ID);
			setState(438);
			match(LPAREN);
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(439);
				argumentList();
				}
			}

			setState(442);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(ID);
			setState(445);
			match(LPAREN);
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(446);
				argumentList();
				}
			}

			setState(449);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public MethodReceiverContext methodReceiver() {
			return getRuleContext(MethodReceiverContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SimplifiedJSSParser.DOT, 0); }
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			methodReceiver();
			setState(452);
			match(DOT);
			setState(453);
			match(ID);
			setState(454);
			match(LPAREN);
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(455);
				argumentList();
				}
			}

			setState(458);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodReceiverContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public List<AccessSuffixContext> accessSuffix() {
			return getRuleContexts(AccessSuffixContext.class);
		}
		public AccessSuffixContext accessSuffix(int i) {
			return getRuleContext(AccessSuffixContext.class,i);
		}
		public TerminalNode THIS() { return getToken(SimplifiedJSSParser.THIS, 0); }
		public MethodReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReceiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterMethodReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitMethodReceiver(this);
		}
	}

	public final MethodReceiverContext methodReceiver() throws RecognitionException {
		MethodReceiverContext _localctx = new MethodReceiverContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_methodReceiver);
		try {
			int _alt;
			setState(474);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				match(ID);
				setState(464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(461);
						accessSuffix();
						}
						} 
					}
					setState(466);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(467);
				match(THIS);
				setState(471);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(468);
						accessSuffix();
						}
						} 
					}
					setState(473);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastCallContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimplifiedJSSParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifiedJSSParser.RPAREN, 0); }
		public CastCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterCastCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitCastCall(this);
		}
	}

	public final CastCallContext castCall() throws RecognitionException {
		CastCallContext _localctx = new CastCallContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_castCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			primitiveType();
			setState(477);
			match(LPAREN);
			setState(478);
			expr();
			setState(479);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(SimplifiedJSSParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SimplifiedJSSParser.RBRACK, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitArrayLiteral(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			match(LBRACK);
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2166543888230088896L) != 0)) {
				{
				setState(482);
				argumentList();
				}
			}

			setState(485);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableContext extends ParserRuleContext {
		public AssignableBaseContext assignableBase() {
			return getRuleContext(AssignableBaseContext.class,0);
		}
		public List<AccessSuffixContext> accessSuffix() {
			return getRuleContexts(AccessSuffixContext.class);
		}
		public AccessSuffixContext accessSuffix(int i) {
			return getRuleContext(AccessSuffixContext.class,i);
		}
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAssignable(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_assignable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			assignableBase();
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK || _la==DOT) {
				{
				{
				setState(488);
				accessSuffix();
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableBaseContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public TerminalNode THIS() { return getToken(SimplifiedJSSParser.THIS, 0); }
		public AssignableBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAssignableBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAssignableBase(this);
		}
	}

	public final AssignableBaseContext assignableBase() throws RecognitionException {
		AssignableBaseContext _localctx = new AssignableBaseContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_assignableBase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			_la = _input.LA(1);
			if ( !(_la==THIS || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessSuffixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(SimplifiedJSSParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(SimplifiedJSSParser.RBRACK, 0); }
		public TerminalNode DOT() { return getToken(SimplifiedJSSParser.DOT, 0); }
		public TerminalNode ID() { return getToken(SimplifiedJSSParser.ID, 0); }
		public AccessSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterAccessSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitAccessSuffix(this);
		}
	}

	public final AccessSuffixContext accessSuffix() throws RecognitionException {
		AccessSuffixContext _localctx = new AccessSuffixContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_accessSuffix);
		try {
			setState(502);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(496);
				match(LBRACK);
				setState(497);
				expr();
				setState(498);
				match(RBRACK);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				match(DOT);
				setState(501);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(SimplifiedJSSParser.INT_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(SimplifiedJSSParser.REAL_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SimplifiedJSSParser.STRING_LITERAL, 0); }
		public TerminalNode TRUE() { return getToken(SimplifiedJSSParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SimplifiedJSSParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(SimplifiedJSSParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimplifiedJSSListener ) ((SimplifiedJSSListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1008806316534661120L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001>\u01fb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u0001\u0000\u0005\u0000r\b\u0000\n\u0000\f\u0000u\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001}\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u008c\b\u0004\n\u0004\f\u0004"+
		"\u008f\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0094\b"+
		"\u0005\n\u0005\f\u0005\u0097\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u009c\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0003\b\u00a4\b\b\u0001\b\u0001\b\u0003\b\u00a8\b\b\u0003"+
		"\b\u00aa\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b7\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u00be\b\f"+
		"\u0001\r\u0001\r\u0001\r\u0005\r\u00c3\b\r\n\r\f\r\u00c6\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u00cf\b\u000f\n\u000f\f\u000f\u00d2\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00d9\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00e3\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00ec"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u00f3\b\u0014\n\u0014\f\u0014\u00f6\t\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u0105\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0005\u0016\u010d\b\u0016\n\u0016\f\u0016\u0110\t\u0016\u0001"+
		"\u0016\u0003\u0016\u0113\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0128\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u012c\b\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0130\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u013a\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0141"+
		"\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u014b\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0005 \u0156\b \n \f \u0159\t \u0001!\u0001!\u0001!\u0005!\u015e\b!"+
		"\n!\f!\u0161\t!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0003"+
		"#\u016a\b#\u0001$\u0001$\u0001%\u0001%\u0001%\u0005%\u0171\b%\n%\f%\u0174"+
		"\t%\u0001&\u0001&\u0001&\u0005&\u0179\b&\n&\f&\u017c\t&\u0001\'\u0001"+
		"\'\u0001\'\u0005\'\u0181\b\'\n\'\f\'\u0184\t\'\u0001(\u0001(\u0001(\u0005"+
		"(\u0189\b(\n(\f(\u018c\t(\u0001)\u0001)\u0001)\u0005)\u0191\b)\n)\f)\u0194"+
		"\t)\u0001*\u0001*\u0001*\u0005*\u0199\b*\n*\f*\u019c\t*\u0001+\u0001+"+
		"\u0001+\u0003+\u01a1\b+\u0001,\u0001,\u0001,\u0003,\u01a6\b,\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003"+
		"-\u01b3\b-\u0001.\u0001.\u0001.\u0001.\u0003.\u01b9\b.\u0001.\u0001.\u0001"+
		"/\u0001/\u0001/\u0003/\u01c0\b/\u0001/\u0001/\u00010\u00010\u00010\u0001"+
		"0\u00010\u00030\u01c9\b0\u00010\u00010\u00011\u00011\u00051\u01cf\b1\n"+
		"1\f1\u01d2\t1\u00011\u00011\u00051\u01d6\b1\n1\f1\u01d9\t1\u00031\u01db"+
		"\b1\u00012\u00012\u00012\u00012\u00012\u00013\u00013\u00033\u01e4\b3\u0001"+
		"3\u00013\u00014\u00014\u00054\u01ea\b4\n4\f4\u01ed\t4\u00015\u00015\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00036\u01f7\b6\u00017\u00017\u0001"+
		"7\u0000\u00008\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjln\u0000"+
		"\t\u0001\u0000\u000f\u0012\u0002\u0000\u0019\u001d\'\'\u0001\u0000\u001e"+
		"\u001f\u0002\u0000 !()\u0001\u0000+,\u0001\u0000-/\u0002\u0000$%*,\u0002"+
		"\u0000\u0007\u0007<<\u0002\u0000\u0013\u00159;\u0202\u0000s\u0001\u0000"+
		"\u0000\u0000\u0002|\u0001\u0000\u0000\u0000\u0004~\u0001\u0000\u0000\u0000"+
		"\u0006\u0083\u0001\u0000\u0000\u0000\b\u0088\u0001\u0000\u0000\u0000\n"+
		"\u0090\u0001\u0000\u0000\u0000\f\u0098\u0001\u0000\u0000\u0000\u000e\u009d"+
		"\u0001\u0000\u0000\u0000\u0010\u00a9\u0001\u0000\u0000\u0000\u0012\u00ab"+
		"\u0001\u0000\u0000\u0000\u0014\u00ad\u0001\u0000\u0000\u0000\u0016\u00b1"+
		"\u0001\u0000\u0000\u0000\u0018\u00bd\u0001\u0000\u0000\u0000\u001a\u00bf"+
		"\u0001\u0000\u0000\u0000\u001c\u00c7\u0001\u0000\u0000\u0000\u001e\u00ca"+
		"\u0001\u0000\u0000\u0000 \u00d8\u0001\u0000\u0000\u0000\"\u00da\u0001"+
		"\u0000\u0000\u0000$\u00de\u0001\u0000\u0000\u0000&\u00e7\u0001\u0000\u0000"+
		"\u0000(\u00f0\u0001\u0000\u0000\u0000*\u0104\u0001\u0000\u0000\u0000,"+
		"\u0106\u0001\u0000\u0000\u0000.\u0114\u0001\u0000\u0000\u00000\u011b\u0001"+
		"\u0000\u0000\u00002\u011e\u0001\u0000\u0000\u00004\u0124\u0001\u0000\u0000"+
		"\u00006\u0134\u0001\u0000\u0000\u00008\u0137\u0001\u0000\u0000\u0000:"+
		"\u013d\u0001\u0000\u0000\u0000<\u0145\u0001\u0000\u0000\u0000>\u014f\u0001"+
		"\u0000\u0000\u0000@\u0152\u0001\u0000\u0000\u0000B\u015a\u0001\u0000\u0000"+
		"\u0000D\u0162\u0001\u0000\u0000\u0000F\u0169\u0001\u0000\u0000\u0000H"+
		"\u016b\u0001\u0000\u0000\u0000J\u016d\u0001\u0000\u0000\u0000L\u0175\u0001"+
		"\u0000\u0000\u0000N\u017d\u0001\u0000\u0000\u0000P\u0185\u0001\u0000\u0000"+
		"\u0000R\u018d\u0001\u0000\u0000\u0000T\u0195\u0001\u0000\u0000\u0000V"+
		"\u019d\u0001\u0000\u0000\u0000X\u01a5\u0001\u0000\u0000\u0000Z\u01b2\u0001"+
		"\u0000\u0000\u0000\\\u01b4\u0001\u0000\u0000\u0000^\u01bc\u0001\u0000"+
		"\u0000\u0000`\u01c3\u0001\u0000\u0000\u0000b\u01da\u0001\u0000\u0000\u0000"+
		"d\u01dc\u0001\u0000\u0000\u0000f\u01e1\u0001\u0000\u0000\u0000h\u01e7"+
		"\u0001\u0000\u0000\u0000j\u01ee\u0001\u0000\u0000\u0000l\u01f6\u0001\u0000"+
		"\u0000\u0000n\u01f8\u0001\u0000\u0000\u0000pr\u0003\u0002\u0001\u0000"+
		"qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000vw\u0005\u0000\u0000\u0001w\u0001\u0001\u0000\u0000\u0000"+
		"x}\u0003\u0004\u0002\u0000y}\u0003\u0006\u0003\u0000z}\u0003\u0016\u000b"+
		"\u0000{}\u0003\u001e\u000f\u0000|x\u0001\u0000\u0000\u0000|y\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0003"+
		"\u0001\u0000\u0000\u0000~\u007f\u0005\u0001\u0000\u0000\u007f\u0080\u0003"+
		"\u0010\b\u0000\u0080\u0081\u0003\b\u0004\u0000\u0081\u0082\u00056\u0000"+
		"\u0000\u0082\u0005\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0002\u0000"+
		"\u0000\u0084\u0085\u0003\u0010\b\u0000\u0085\u0086\u0003\n\u0005\u0000"+
		"\u0086\u0087\u00056\u0000\u0000\u0087\u0007\u0001\u0000\u0000\u0000\u0088"+
		"\u008d\u0003\f\u0006\u0000\u0089\u008a\u00057\u0000\u0000\u008a\u008c"+
		"\u0003\f\u0006\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008f\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\t\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0095\u0003\u000e\u0007\u0000\u0091\u0092\u00057\u0000"+
		"\u0000\u0092\u0094\u0003\u000e\u0007\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u000b\u0001\u0000\u0000"+
		"\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u009b\u0005<\u0000\u0000"+
		"\u0099\u009a\u0005\'\u0000\u0000\u009a\u009c\u0003D\"\u0000\u009b\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\r\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005<\u0000\u0000\u009e\u009f\u0005\'"+
		"\u0000\u0000\u009f\u00a0\u0003D\"\u0000\u00a0\u000f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a3\u0003\u0012\t\u0000\u00a2\u00a4\u0003\u0014\n\u0000"+
		"\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u00aa\u0001\u0000\u0000\u0000\u00a5\u00a7\u0005<\u0000\u0000\u00a6"+
		"\u00a8\u0003\u0014\n\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a5\u0001\u0000\u0000\u0000\u00aa\u0011"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007\u0000\u0000\u0000\u00ac\u0013"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u00054\u0000\u0000\u00ae\u00af\u0005"+
		":\u0000\u0000\u00af\u00b0\u00055\u0000\u0000\u00b0\u0015\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0005\u0003\u0000\u0000\u00b2\u00b3\u0003\u0018\f\u0000"+
		"\u00b3\u00b4\u0005<\u0000\u0000\u00b4\u00b6\u00050\u0000\u0000\u00b5\u00b7"+
		"\u0003\u001a\r\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005"+
		"1\u0000\u0000\u00b9\u00ba\u0003(\u0014\u0000\u00ba\u0017\u0001\u0000\u0000"+
		"\u0000\u00bb\u00be\u0003\u0010\b\u0000\u00bc\u00be\u0005\u000e\u0000\u0000"+
		"\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000"+
		"\u00be\u0019\u0001\u0000\u0000\u0000\u00bf\u00c4\u0003\u001c\u000e\u0000"+
		"\u00c0\u00c1\u00057\u0000\u0000\u00c1\u00c3\u0003\u001c\u000e\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u001b\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0003\u0010\b\u0000\u00c8\u00c9\u0005<\u0000\u0000\u00c9\u001d"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u0004\u0000\u0000\u00cb\u00cc"+
		"\u0005<\u0000\u0000\u00cc\u00d0\u00052\u0000\u0000\u00cd\u00cf\u0003 "+
		"\u0010\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u00053\u0000\u0000\u00d4\u001f\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d9\u0003\"\u0011\u0000\u00d6\u00d9\u0003$\u0012\u0000"+
		"\u00d7\u00d9\u0003&\u0013\u0000\u00d8\u00d5\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"!\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u0010\b\u0000\u00db\u00dc"+
		"\u0005<\u0000\u0000\u00dc\u00dd\u00056\u0000\u0000\u00dd#\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0005<\u0000\u0000\u00df\u00e0\u0005\u0005\u0000"+
		"\u0000\u00e0\u00e2\u00050\u0000\u0000\u00e1\u00e3\u0003\u001a\r\u0000"+
		"\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5\u00051\u0000\u0000\u00e5"+
		"\u00e6\u0003(\u0014\u0000\u00e6%\u0001\u0000\u0000\u0000\u00e7\u00e8\u0003"+
		"\u0010\b\u0000\u00e8\u00e9\u0005<\u0000\u0000\u00e9\u00eb\u00050\u0000"+
		"\u0000\u00ea\u00ec\u0003\u001a\r\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ee\u00051\u0000\u0000\u00ee\u00ef\u0003(\u0014\u0000\u00ef\'"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f4\u00052\u0000\u0000\u00f1\u00f3\u0003"+
		"*\u0015\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u00053\u0000\u0000\u00f8)\u0001\u0000\u0000\u0000"+
		"\u00f9\u0105\u0003\u0004\u0002\u0000\u00fa\u0105\u0003\u0006\u0003\u0000"+
		"\u00fb\u0105\u0003,\u0016\u0000\u00fc\u0105\u00032\u0019\u0000\u00fd\u0105"+
		"\u00034\u001a\u0000\u00fe\u0105\u00036\u001b\u0000\u00ff\u0105\u00038"+
		"\u001c\u0000\u0100\u0105\u0003:\u001d\u0000\u0101\u0105\u0003<\u001e\u0000"+
		"\u0102\u0105\u0003>\u001f\u0000\u0103\u0105\u0003(\u0014\u0000\u0104\u00f9"+
		"\u0001\u0000\u0000\u0000\u0104\u00fa\u0001\u0000\u0000\u0000\u0104\u00fb"+
		"\u0001\u0000\u0000\u0000\u0104\u00fc\u0001\u0000\u0000\u0000\u0104\u00fd"+
		"\u0001\u0000\u0000\u0000\u0104\u00fe\u0001\u0000\u0000\u0000\u0104\u00ff"+
		"\u0001\u0000\u0000\u0000\u0104\u0100\u0001\u0000\u0000\u0000\u0104\u0101"+
		"\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0103"+
		"\u0001\u0000\u0000\u0000\u0105+\u0001\u0000\u0000\u0000\u0106\u0107\u0005"+
		"\b\u0000\u0000\u0107\u0108\u00050\u0000\u0000\u0108\u0109\u0003D\"\u0000"+
		"\u0109\u010a\u00051\u0000\u0000\u010a\u010e\u0003(\u0014\u0000\u010b\u010d"+
		"\u0003.\u0017\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d\u0110\u0001"+
		"\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001"+
		"\u0000\u0000\u0000\u0111\u0113\u00030\u0018\u0000\u0112\u0111\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113-\u0001\u0000\u0000"+
		"\u0000\u0114\u0115\u0005\t\u0000\u0000\u0115\u0116\u0005\b\u0000\u0000"+
		"\u0116\u0117\u00050\u0000\u0000\u0117\u0118\u0003D\"\u0000\u0118\u0119"+
		"\u00051\u0000\u0000\u0119\u011a\u0003(\u0014\u0000\u011a/\u0001\u0000"+
		"\u0000\u0000\u011b\u011c\u0005\t\u0000\u0000\u011c\u011d\u0003(\u0014"+
		"\u0000\u011d1\u0001\u0000\u0000\u0000\u011e\u011f\u0005\n\u0000\u0000"+
		"\u011f\u0120\u00050\u0000\u0000\u0120\u0121\u0003D\"\u0000\u0121\u0122"+
		"\u00051\u0000\u0000\u0122\u0123\u0003(\u0014\u0000\u01233\u0001\u0000"+
		"\u0000\u0000\u0124\u0125\u0005\u000b\u0000\u0000\u0125\u0127\u00050\u0000"+
		"\u0000\u0126\u0128\u0003D\"\u0000\u0127\u0126\u0001\u0000\u0000\u0000"+
		"\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000"+
		"\u0129\u012b\u00056\u0000\u0000\u012a\u012c\u0003D\"\u0000\u012b\u012a"+
		"\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012d"+
		"\u0001\u0000\u0000\u0000\u012d\u012f\u00056\u0000\u0000\u012e\u0130\u0003"+
		"D\"\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000"+
		"\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u00051\u0000"+
		"\u0000\u0132\u0133\u0003(\u0014\u0000\u01335\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0005\f\u0000\u0000\u0135\u0136\u00056\u0000\u0000\u01367\u0001"+
		"\u0000\u0000\u0000\u0137\u0139\u0005\r\u0000\u0000\u0138\u013a\u0003D"+
		"\"\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000"+
		"\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u00056\u0000\u0000"+
		"\u013c9\u0001\u0000\u0000\u0000\u013d\u013e\u0005\u0016\u0000\u0000\u013e"+
		"\u0140\u00050\u0000\u0000\u013f\u0141\u0003@ \u0000\u0140\u013f\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142\u0001"+
		"\u0000\u0000\u0000\u0142\u0143\u00051\u0000\u0000\u0143\u0144\u00056\u0000"+
		"\u0000\u0144;\u0001\u0000\u0000\u0000\u0145\u0146\u0005\u0017\u0000\u0000"+
		"\u0146\u0147\u00058\u0000\u0000\u0147\u0148\u0005\u0018\u0000\u0000\u0148"+
		"\u014a\u00050\u0000\u0000\u0149\u014b\u0003B!\u0000\u014a\u0149\u0001"+
		"\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0001"+
		"\u0000\u0000\u0000\u014c\u014d\u00051\u0000\u0000\u014d\u014e\u00056\u0000"+
		"\u0000\u014e=\u0001\u0000\u0000\u0000\u014f\u0150\u0003D\"\u0000\u0150"+
		"\u0151\u00056\u0000\u0000\u0151?\u0001\u0000\u0000\u0000\u0152\u0157\u0003"+
		"h4\u0000\u0153\u0154\u00057\u0000\u0000\u0154\u0156\u0003h4\u0000\u0155"+
		"\u0153\u0001\u0000\u0000\u0000\u0156\u0159\u0001\u0000\u0000\u0000\u0157"+
		"\u0155\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158"+
		"A\u0001\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u015a\u015f"+
		"\u0003D\"\u0000\u015b\u015c\u00057\u0000\u0000\u015c\u015e\u0003D\"\u0000"+
		"\u015d\u015b\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000"+
		"\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000"+
		"\u0160C\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162"+
		"\u0163\u0003F#\u0000\u0163E\u0001\u0000\u0000\u0000\u0164\u0165\u0003"+
		"h4\u0000\u0165\u0166\u0003H$\u0000\u0166\u0167\u0003F#\u0000\u0167\u016a"+
		"\u0001\u0000\u0000\u0000\u0168\u016a\u0003J%\u0000\u0169\u0164\u0001\u0000"+
		"\u0000\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u016aG\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0007\u0001\u0000\u0000\u016cI\u0001\u0000\u0000\u0000"+
		"\u016d\u0172\u0003L&\u0000\u016e\u016f\u0005#\u0000\u0000\u016f\u0171"+
		"\u0003L&\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000"+
		"\u0000\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000"+
		"\u0000\u0000\u0173K\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000"+
		"\u0000\u0175\u017a\u0003N\'\u0000\u0176\u0177\u0005\"\u0000\u0000\u0177"+
		"\u0179\u0003N\'\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u017c"+
		"\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017a\u017b"+
		"\u0001\u0000\u0000\u0000\u017bM\u0001\u0000\u0000\u0000\u017c\u017a\u0001"+
		"\u0000\u0000\u0000\u017d\u0182\u0003P(\u0000\u017e\u017f\u0007\u0002\u0000"+
		"\u0000\u017f\u0181\u0003P(\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0181"+
		"\u0184\u0001\u0000\u0000\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0182"+
		"\u0183\u0001\u0000\u0000\u0000\u0183O\u0001\u0000\u0000\u0000\u0184\u0182"+
		"\u0001\u0000\u0000\u0000\u0185\u018a\u0003R)\u0000\u0186\u0187\u0007\u0003"+
		"\u0000\u0000\u0187\u0189\u0003R)\u0000\u0188\u0186\u0001\u0000\u0000\u0000"+
		"\u0189\u018c\u0001\u0000\u0000\u0000\u018a\u0188\u0001\u0000\u0000\u0000"+
		"\u018a\u018b\u0001\u0000\u0000\u0000\u018bQ\u0001\u0000\u0000\u0000\u018c"+
		"\u018a\u0001\u0000\u0000\u0000\u018d\u0192\u0003T*\u0000\u018e\u018f\u0007"+
		"\u0004\u0000\u0000\u018f\u0191\u0003T*\u0000\u0190\u018e\u0001\u0000\u0000"+
		"\u0000\u0191\u0194\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000"+
		"\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193S\u0001\u0000\u0000\u0000"+
		"\u0194\u0192\u0001\u0000\u0000\u0000\u0195\u019a\u0003V+\u0000\u0196\u0197"+
		"\u0007\u0005\u0000\u0000\u0197\u0199\u0003V+\u0000\u0198\u0196\u0001\u0000"+
		"\u0000\u0000\u0199\u019c\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000"+
		"\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019bU\u0001\u0000\u0000"+
		"\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019d\u01a0\u0003X,\u0000\u019e"+
		"\u019f\u0005&\u0000\u0000\u019f\u01a1\u0003V+\u0000\u01a0\u019e\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1W\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a3\u0007\u0006\u0000\u0000\u01a3\u01a6\u0003X,\u0000"+
		"\u01a4\u01a6\u0003Z-\u0000\u01a5\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a6Y\u0001\u0000\u0000\u0000\u01a7\u01b3\u0003"+
		"n7\u0000\u01a8\u01b3\u0003\\.\u0000\u01a9\u01b3\u0003d2\u0000\u01aa\u01b3"+
		"\u0003`0\u0000\u01ab\u01b3\u0003^/\u0000\u01ac\u01b3\u0003h4\u0000\u01ad"+
		"\u01b3\u0003f3\u0000\u01ae\u01af\u00050\u0000\u0000\u01af\u01b0\u0003"+
		"D\"\u0000\u01b0\u01b1\u00051\u0000\u0000\u01b1\u01b3\u0001\u0000\u0000"+
		"\u0000\u01b2\u01a7\u0001\u0000\u0000\u0000\u01b2\u01a8\u0001\u0000\u0000"+
		"\u0000\u01b2\u01a9\u0001\u0000\u0000\u0000\u01b2\u01aa\u0001\u0000\u0000"+
		"\u0000\u01b2\u01ab\u0001\u0000\u0000\u0000\u01b2\u01ac\u0001\u0000\u0000"+
		"\u0000\u01b2\u01ad\u0001\u0000\u0000\u0000\u01b2\u01ae\u0001\u0000\u0000"+
		"\u0000\u01b3[\u0001\u0000\u0000\u0000\u01b4\u01b5\u0005\u0006\u0000\u0000"+
		"\u01b5\u01b6\u0005<\u0000\u0000\u01b6\u01b8\u00050\u0000\u0000\u01b7\u01b9"+
		"\u0003B!\u0000\u01b8\u01b7\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000"+
		"\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01bb\u00051\u0000"+
		"\u0000\u01bb]\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005<\u0000\u0000\u01bd"+
		"\u01bf\u00050\u0000\u0000\u01be\u01c0\u0003B!\u0000\u01bf\u01be\u0001"+
		"\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c2\u00051\u0000\u0000\u01c2_\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c4\u0003b1\u0000\u01c4\u01c5\u00058\u0000\u0000\u01c5"+
		"\u01c6\u0005<\u0000\u0000\u01c6\u01c8\u00050\u0000\u0000\u01c7\u01c9\u0003"+
		"B!\u0000\u01c8\u01c7\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000"+
		"\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cb\u00051\u0000\u0000"+
		"\u01cba\u0001\u0000\u0000\u0000\u01cc\u01d0\u0005<\u0000\u0000\u01cd\u01cf"+
		"\u0003l6\u0000\u01ce\u01cd\u0001\u0000\u0000\u0000\u01cf\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d0\u01d1\u0001\u0000"+
		"\u0000\u0000\u01d1\u01db\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000"+
		"\u0000\u0000\u01d3\u01d7\u0005\u0007\u0000\u0000\u01d4\u01d6\u0003l6\u0000"+
		"\u01d5\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d9\u0001\u0000\u0000\u0000"+
		"\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000"+
		"\u01d8\u01db\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000"+
		"\u01da\u01cc\u0001\u0000\u0000\u0000\u01da\u01d3\u0001\u0000\u0000\u0000"+
		"\u01dbc\u0001\u0000\u0000\u0000\u01dc\u01dd\u0003\u0012\t\u0000\u01dd"+
		"\u01de\u00050\u0000\u0000\u01de\u01df\u0003D\"\u0000\u01df\u01e0\u0005"+
		"1\u0000\u0000\u01e0e\u0001\u0000\u0000\u0000\u01e1\u01e3\u00054\u0000"+
		"\u0000\u01e2\u01e4\u0003B!\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e3"+
		"\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5"+
		"\u01e6\u00055\u0000\u0000\u01e6g\u0001\u0000\u0000\u0000\u01e7\u01eb\u0003"+
		"j5\u0000\u01e8\u01ea\u0003l6\u0000\u01e9\u01e8\u0001\u0000\u0000\u0000"+
		"\u01ea\u01ed\u0001\u0000\u0000\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ec\u0001\u0000\u0000\u0000\u01eci\u0001\u0000\u0000\u0000\u01ed"+
		"\u01eb\u0001\u0000\u0000\u0000\u01ee\u01ef\u0007\u0007\u0000\u0000\u01ef"+
		"k\u0001\u0000\u0000\u0000\u01f0\u01f1\u00054\u0000\u0000\u01f1\u01f2\u0003"+
		"D\"\u0000\u01f2\u01f3\u00055\u0000\u0000\u01f3\u01f7\u0001\u0000\u0000"+
		"\u0000\u01f4\u01f5\u00058\u0000\u0000\u01f5\u01f7\u0005<\u0000\u0000\u01f6"+
		"\u01f0\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f7"+
		"m\u0001\u0000\u0000\u0000\u01f8\u01f9\u0007\b\u0000\u0000\u01f9o\u0001"+
		"\u0000\u0000\u0000.s|\u008d\u0095\u009b\u00a3\u00a7\u00a9\u00b6\u00bd"+
		"\u00c4\u00d0\u00d8\u00e2\u00eb\u00f4\u0104\u010e\u0112\u0127\u012b\u012f"+
		"\u0139\u0140\u014a\u0157\u015f\u0169\u0172\u017a\u0182\u018a\u0192\u019a"+
		"\u01a0\u01a5\u01b2\u01b8\u01bf\u01c8\u01d0\u01d7\u01da\u01e3\u01eb\u01f6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
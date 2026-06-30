grammar SimplifiedJSS;

program
    : topLevelDecl* EOF
    ;

topLevelDecl
    : functionDecl
    | classDecl
    | statement
    ;

varDecl
    : LET type declaratorList SEMI
    ;

constDecl
    : CONST type constDeclaratorList SEMI
    ;

declaratorList
    : declarator (COMMA declarator)*
    ;

constDeclaratorList
    : constDeclarator (COMMA constDeclarator)*
    ;

declarator
    : ID (ASSIGN expr)?
    ;

constDeclarator
    : ID ASSIGN expr
    ;

type
    : primitiveType arraySuffix*
    | ID arraySuffix*
    ;

primitiveType
    : INT
    | REAL
    | STR
    | BOOL
    ;

arraySuffix
    : LBRACK INT_LITERAL RBRACK
    ;

functionDecl
    : FUNCTION returnType ID LPAREN paramList? RPAREN block
    ;

returnType
    : type
    | VOID
    ;

paramList
    : param (COMMA param)*
    ;

param
    : type ID
    ;

classDecl
    : CLASS ID LBRACE classMember* RBRACE
    ;

classMember
    : attributeDecl
    | constructorDecl
    | methodDecl
    ;

attributeDecl
    : type ID SEMI
    ;

constructorDecl
    : ID CONSTRUCTOR LPAREN paramList? RPAREN block
    ;

methodDecl
    : returnType ID LPAREN paramList? RPAREN block
    ;

block
    : LBRACE statement* RBRACE
    ;

statement
    : varDecl
    | constDecl
    | ifStmt
    | whileStmt
    | forStmt
    | breakStmt
    | returnStmt
    | inputStmt
    | consoleLogStmt
    | exprStmt
    | block
    ;

ifStmt
    : IF LPAREN expr RPAREN block elseIfPart* elsePart?
    ;

elseIfPart
    : ELSE IF LPAREN expr RPAREN block
    ;

elsePart
    : ELSE block
    ;

whileStmt
    : WHILE LPAREN expr RPAREN block
    ;

forStmt
    : FOR LPAREN forInit? SEMI expr? SEMI expr? RPAREN block
    ;

forInit
    : varDeclNoSemi
    | expr
    ;

varDeclNoSemi
    : LET type declaratorList
    ;

breakStmt
    : BREAK SEMI
    ;

returnStmt
    : RETURN expr? SEMI
    ;

inputStmt
    : INPUT LPAREN assignableList? RPAREN SEMI
    ;

consoleLogStmt
    : CONSOLE DOT LOG LPAREN argumentList? RPAREN SEMI
    ;

exprStmt
    : expr SEMI
    ;

assignableList
    : assignable (COMMA assignable)*
    ;

argumentList
    : expr (COMMA expr)*
    ;

// --------------------
// Expressões
// --------------------

expr
    : assignment
    ;

assignment
    : assignable assignOp assignment
    | logicalOr
    ;

assignOp
    : ASSIGN
    | PLUS_ASSIGN
    | MINUS_ASSIGN
    | MUL_ASSIGN
    | DIV_ASSIGN
    | MOD_ASSIGN
    ;

logicalOr
    : logicalAnd (OR logicalAnd)*
    ;

logicalAnd
    : equality (AND equality)*
    ;

equality
    : relational ((EQ | NEQ) relational)*
    ;

relational
    : additive ((GT | GTE | LT | LTE) additive)*
    ;

additive
    : multiplicative ((PLUS | MINUS) multiplicative)*
    ;

multiplicative
    : power ((MUL | DIV | MOD) power)*
    ;

power
    : unary (POW power)?
    ;

unary
    : (NOT | PLUS | MINUS | INC | DEC) unary
    | postfix
    ;

postfix
    : primary (INC | DEC)?
    ;

primary
    : literal
    | newObject
    | castCall
    | methodCall
    | functionCall
    | assignable
    | arrayLiteral
    | LPAREN expr RPAREN
    ;

newObject
    : NEW ID LPAREN argumentList? RPAREN
    ;

functionCall
    : ID LPAREN argumentList? RPAREN
    ;

methodCall
    : methodReceiver DOT ID LPAREN argumentList? RPAREN
    ;

methodReceiver
    : ID accessSuffix*
    | THIS accessSuffix*
    ;

castCall
    : primitiveType LPAREN expr RPAREN
    ;

arrayLiteral
    : LBRACK argumentList? RBRACK
    ;

assignable
    : assignableBase accessSuffix*
    ;

assignableBase
    : ID
    | THIS
    ;

accessSuffix
    : LBRACK expr RBRACK
    | DOT ID
    ;

literal
    : INT_LITERAL
    | REAL_LITERAL
    | STRING_LITERAL
    | TRUE
    | FALSE
    | NULL
    ;

// --------------------
// Palavras reservadas
// --------------------

LET         : 'let';
CONST       : 'const';
FUNCTION    : 'function';
CLASS       : 'class';
CONSTRUCTOR : 'constructor';
NEW         : 'new';
THIS        : 'this';

IF          : 'if';
ELSE        : 'else';
WHILE       : 'while';
FOR         : 'for';
BREAK       : 'break';
RETURN      : 'return';

VOID        : 'void';

INT         : 'int';
REAL        : 'real';
STR         : 'str';
BOOL        : 'bool';

TRUE        : 'true';
FALSE       : 'false';
NULL        : 'null';

INPUT       : 'input';
CONSOLE     : 'console';
LOG         : 'log';

// --------------------
// Operadores
// --------------------

PLUS_ASSIGN  : '+=';
MINUS_ASSIGN : '-=';
MUL_ASSIGN   : '*=';
DIV_ASSIGN   : '/=';
MOD_ASSIGN   : '%=';

EQ          : '==';
NEQ         : '!=';
GTE         : '>=';
LTE         : '<=';
AND         : '&&';
OR          : '||';
INC         : '++';
DEC         : '--';
POW         : '**';

ASSIGN      : '=';
GT          : '>';
LT          : '<';
NOT         : '!';
PLUS        : '+';
MINUS       : '-';
MUL         : '*';
DIV         : '/';
MOD         : '%';

// --------------------
// Símbolos
// --------------------

LPAREN      : '(';
RPAREN      : ')';
LBRACE      : '{';
RBRACE      : '}';
LBRACK      : '[';
RBRACK      : ']';
SEMI        : ';';
COMMA       : ',';
DOT         : '.';

// --------------------
// Literais e ID
// --------------------

REAL_LITERAL
    : DIGIT+ DOT DIGIT+ EXP?
    | DIGIT+ EXP
    ;

INT_LITERAL
    : DIGIT+
    ;

STRING_LITERAL
    : '"' (ESC | ~["\\\r\n])* '"'
    ;

ID
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

fragment DIGIT
    : [0-9]
    ;

fragment EXP
    : [eE] [+-]? DIGIT+
    ;

fragment ESC
    : '\\' [btnr"\\]
    ;

// --------------------
// Ignorados
// --------------------

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
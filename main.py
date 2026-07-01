import sys
from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener
from SimplifiedJSSLexer import SimplifiedJSSLexer
from SimplifiedJSSParser import SimplifiedJSSParser
from checker import StaticChecker
from codegen import CodeGenerator

class SyntaxErrorListener(ErrorListener):

    def __init__(self, source_lines):
        super().__init__()
        self.source_lines = source_lines

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):

        token = offendingSymbol.text if offendingSymbol else "<EOF>"

        try:
            expected = recognizer.getExpectedTokens().toString(
                recognizer.literalNames,
                recognizer.symbolicNames
            )
            print(f"[Linha {line}]: erro léxico/sintático [encontrado: {token}], [esperava: {expected}]")

        except Exception:
            pass

def main():
    if len(sys.argv) not in (2, 3):
        print("Uso: python main.py entrada.txt [saida.ll]")
        return

    filename = sys.argv[1]

    with open(filename, encoding="utf-8") as f:
        source_lines = f.readlines()
    
    input_stream = FileStream(filename, encoding="utf-8")

    error_listener = SyntaxErrorListener(source_lines)

    # Substituimos o listener padrão do lexer e do parser do ANTLR 
    lexer = SimplifiedJSSLexer(input_stream)
    lexer.removeErrorListeners()
    lexer.addErrorListener(error_listener)

    tokens = CommonTokenStream(lexer)

    parser = SimplifiedJSSParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(error_listener)

    tree = parser.program()

    #Se existir erros léxicos ou sintáticos detectados, encerra sem chamar o checador semântico.
    if parser.getNumberOfSyntaxErrors() > 0:
        return

    checker = StaticChecker()
    ok, errors = checker.check(tree)

    if not ok:
        for err in errors:
            print(err)
    else:
        print("aceito")
        llvm_ir = CodeGenerator().generate(tree)

        output_path = sys.argv[2] if len(sys.argv) == 3 else "IR_gerado.ll"
    
        with open(output_path, "w", encoding="utf-8") as output_file:
            output_file.write(llvm_ir)
        print(f"IR LLVM salvo em {output_path}")


if __name__ == "__main__":
    main()

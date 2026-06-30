# Trabalho final Compiladores

Este projeto compõe a primeira parte do trabalho final da disciplina de compiladores.  
Nele é relizado a analise lexica/sintatica com ANTLR e checagem semantica em Python para uma linguagem simplificada de JSS fortemente tipada.

## Pre-requisitos 

- Python 3.x
- ANTLR 4.13.2
- Bibliotecas Python:

```bash
pip install antlr4-python3-runtime==4.13.2
```
OBS: Alguns comandos podem variar dependendo do sistema operacional utilizado.

## 1. Gerar os arquivos do ANTLR

Execute este comando na pasta do projeto apenas quando alterar `SimplifiedJSS.g4`:

```bash
antlr4 -Dlanguage=Python3 -visitor SimplifiedJSS.g4
```

Ele gera/atualiza arquivos como `SimplifiedJSSLexer.py`, `SimplifiedJSSParser.py` e `SimplifiedJSSVisitor.py`.

## 2. Como executar

Na pasta do projeto use:

```bash
python main.py entrada.jss
```
Por padrao, se o programa for aceito, o IR LLVM sera salvo em `IR_gerado.ll`.

Para escolher o nome do arquivo de saida:

```bash
python main.py <arquivo_entrada.jss> <nome_saida.ll>
```

## 3. Testando outras entradas

Troque o arquivo de entrada:

```bash
python main.py <outro_arquivo.jss>
```
ou:
```bash
python main.py testes\<arquivo.jss>
```

## 4. Executar o IR LLVM gerado

Se tiver `clang` instalado, compile o `.ll` gerado:

```bash
clang saida.ll -o saida.exe
```

Depois execute:

```bash
.\saida.exe
```

Caso queira usar WSL no windows (opcional):
```bash
sudo apt update
sudo apt upgrade
sudo apt install llvm clang
```

Depois execute no diretório do projeto ``` exemplo: cd /mnt/c/Users/[usuario]/Desktop/[projeto]```:

```bash
clang saida.ll -o saida.exe
./saida.exe
```

## Saida esperada do compilador

Quando a entrada estiver correta:

```text
aceito
IR LLVM salvo em saida.ll
```

Quando houver erro semantico:

```text
erro
[linha X] mensagem do erro
```

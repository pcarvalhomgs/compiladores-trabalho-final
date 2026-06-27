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

## 3. Testando outras entradas

Troque o arquivo de entrada:

```bash
python main.py <outro_arquivo.jss>
```
ou:
```bash
python main.py testes\<arquivo.jss>
```

## 4. Saida esperada 

Quando a entrada estiver correta:

```text
aceito
```

Quando houver erro léxico/sintático ou semântico:

```text
erro
[linha X] mensagem do erro
```

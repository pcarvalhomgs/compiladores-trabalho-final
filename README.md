# Trabalho final Compiladores

Este projeto consiste no desenvolvimento de um compilador para a linguagem Simplified JSS (JavaScript Simplificado), uma linguagem imperativa, \
orientada a objetos e fortemente tipada, criada para fins acadêmicos na disciplina de Compiladores.

O compilador foi implementado em Python, utilizando o ANTLR4 para a análise léxica e sintática e o LLVM, por meio da biblioteca llvmlite, \
para a geração de código intermediário (LLVM IR). O código gerado pode ser posteriormente compilado e executado utilizando o Clang.

A linguagem suporta um conjunto significativo de funcionalidades presentes em linguagens modernas, incluindo:

- Tipos primitivos (int, real, bool e str);
- Variáveis e constantes;
- Conversões explícitas por meio de casts;
- Expressões aritméticas, relacionais e lógicas;
- Estruturas de controle (if, else, while e for);
- Funções com parâmetros e retorno;
- Vetores e arrays multidimensionais;
- Classes, atributos, métodos e construtores;
- Criação e manipulação de objetos;
- Entrada e saída de dados.

O compilador está organizado nas etapas clássicas de construção de compiladores:

1. Análise Léxica – reconhecimento dos tokens da linguagem;
2. Análise Sintática – verificação da estrutura gramatical do programa;
3. Análise Semântica – validação de tipos, escopos e demais restrições da linguagem;
4. Geração de Código Intermediário – tradução do programa para LLVM IR;
5. Compilação e Execução – geração do executável por meio do Clang.

O objetivo do projeto é consolidar os conceitos fundamentais de construção de compiladores, abrangendo desde a especificação da \
linguagem até a geração de código executável, utilizando ferramentas e tecnologias amplamente empregadas em compiladores reais.

## Ambiente de Desenvolvimento

<b>OBS:</b> Caso o sistema operacional utilizado seja uma distribuição Linux, não é necessário instalar ou utilizar o WSL. \
Basta instalar as dependências mencionadas diretamente no sistema.

O desenvolvimento e os testes do compilador foram realizados utilizando o Windows Subsystem for Linux (WSL). \
A escolha desse ambiente ocorreu devido à facilidade de instalação e integração das ferramentas utilizadas no projeto, \
especialmente o LLVM, o Clang e a biblioteca llvmlite, que possuem melhor suporte e configuração mais simples em sistemas Linux.

As principais tecnologias empregadas foram:

- Python 3 – implementação do compilador;
- ANTLR4 – geração do analisador léxico e sintático;
- llvmlite – construção do código intermediário em LLVM IR;
- LLVM e Clang – compilação e execução do código gerado;
- WSL (Windows Subsystem for Linux) – ambiente de desenvolvimento e testes.

O uso do WSL permitiu reproduzir um ambiente Linux completo dentro do Windows, simplificando a instalação das dependências\
e a execução das ferramentas necessárias para as etapas de geração, compilação e execução do código intermediário\
produzido pelo compilador.\
Para usar WSL no windows as seguintes dependencias precisam ser instaladas:

- Dependências Python:
```bash
pip install antlr4-python3-runtime==4.13.2 llvmlite
``` 
- Dependências WSL:
```bash
sudo apt update
sudo apt upgrade
sudo apt install llvm clang
```

Após a instalação das dependências no WSL, recomenda-se abrir o ambiente Linux integrado à IDE utilizada (por exemplo, Visual Studio Code com a extensão WSL).\
Dessa forma, todo o projeto é executado diretamente no ambiente Linux, permitindo o uso nativo das ferramentas Python, ANTLR4, llvmlite,\
LLVM e Clang, além de simplificar a compilação, os testes e a depuração do compilador.

## Usuários Linux

Caso o sistema operacional utilizado seja uma distribuição Linux, não é necessário instalar ou utilizar o WSL. \
Basta instalar as dependências mencionadas diretamente no sistema.

## 1. Gerar os arquivos do ANTLR

Execute este comando na pasta do projeto <b>apenas</b> quando alterar `SimplifiedJSS.g4`:

```bash
antlr4 -Dlanguage=Python3 -visitor SimplifiedJSS.g4
```

Ele gera/atualiza arquivos como `SimplifiedJSSLexer.py`, `SimplifiedJSSParser.py` e `SimplifiedJSSVisitor.py`.

## 2. Como executar

Na pasta do projeto use:

```bash
python main.py <entrada>.jss
```
Por padrao, se o programa for aceito, o IR LLVM sera salvo em `IR_gerado.ll`.

Para escolher o nome do arquivo de saida:

```bash
python main.py <arquivo_entrada>.jss <nome_saida>.ll
```

## 3. Testando outras entradas

Troque o arquivo de entrada:

```bash
python main.py <outro_arquivo>.jss
```
ou:
```bash
python main.py <diretório>\<arquivo>.jss
```

## 4. Executar o IR LLVM gerado

Com `clang` instalado, compile o `.ll` gerado:
```bash
clang <arquivo_gerado>.ll -o <nome_saida> 
```

Depois execute:

```bash
./saida.exe
```

## 5. Saida esperada do compilador

Quando a entrada estiver correta:

```text
aceito
IR LLVM salvo em IR_gerado.ll
```

Quando houver erro semantico:

```text
erro
[linha X] mensagem do erro
```

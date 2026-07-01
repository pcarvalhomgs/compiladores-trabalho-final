# Relatorio do Code Generator LLVM

Este relatorio explica a implementacao da classe `CodeGenerator`, responsavel por transformar a arvore sintatica gerada pelo ANTLR em codigo intermediario LLVM usando `llvmlite`.

O objetivo do `codegen.py` nao e fazer analise semantica. Essa etapa ja foi feita pelo `checker.py`. O gerador parte do principio de que o programa esta correto e se concentra em emitir LLVM IR valido para ser compilado depois com `clang`, principalmente no WSL/Linux.

## Visao geral

A classe principal e:

```python
class CodeGenerator(SimplifiedJSSVisitor):
```

Ela herda de `SimplifiedJSSVisitor`, que e o visitor gerado pelo ANTLR. Cada metodo `visitX` corresponde a uma regra da gramatica, por exemplo:

- `visitProgram`
- `visitFunctionDecl`
- `visitVarDecl`
- `visitIfStmt`
- `visitAssignment`
- `visitFunctionCall`
- `visitMethodCall`

A estrategia geral e visitar a arvore sintatica e, durante a visita, emitir instrucoes LLVM usando objetos do `llvmlite.ir`, principalmente:

- `ir.Module`
- `ir.Function`
- `ir.FunctionType`
- `ir.IRBuilder`
- `ir.IntType`
- `ir.DoubleType`
- `ir.ArrayType`
- `ir.GlobalVariable`

No fim, o metodo `generate` retorna o modulo LLVM em formato textual:

```python
def generate(self, tree):
    self.visit(tree)
    return str(self.module)
```

Esse texto e salvo em um arquivo `.ll`.

## Estruturas auxiliares

O gerador usa tres dataclasses para organizar os dados internos.

### `Value`

```python
@dataclass
class Value:
    value: ir.Value
    type: str
    lvalue: ir.Value | None = None
```

Representa o resultado de uma expressao.

Exemplo:

```jss
10 + 20
```

Essa expressao vira um `Value` com:

- `value`: o valor LLVM produzido pela soma;
- `type`: `"int"`;
- `lvalue`: normalmente `None`, porque expressoes comuns nao representam um endereco modificavel.

A separacao entre valor LLVM e tipo da linguagem e importante porque o LLVM sabe que algo e `i32`, `double` ou `i1`, mas o gerador tambem precisa saber se aquilo veio de `int`, `real`, `bool`, `str`, classe ou array.

### `Slot`

```python
@dataclass
class Slot:
    name: str
    type: str
    ptr: ir.Value
    const: bool = False
    array_size: list[int] | None = None
```

Representa uma variavel dentro de um escopo.

O ponto mais importante: `Slot` guarda um ponteiro LLVM, nao necessariamente o valor final.

Por exemplo:

```jss
let int x = 10;
```

No LLVM, isso vira a ideia de:

```llvm
%x = alloca i32
store i32 10, i32* %x
```

O `Slot` de `x` guarda o ponteiro `%x`. Quando o programa usa `x` em uma expressao, o gerador faz `load`. Quando atribui em `x`, faz `store`.

### `ClassLayout`

```python
@dataclass
class ClassLayout:
    name: str
    struct: ir.IdentifiedStructType
    attrs: list[tuple[str, str, list[int] | None]]
    attr_index: dict[str, int]
    methods: dict[str, tuple[str, list[tuple[str, str]], ir.Function]]
    constructor: tuple[list[tuple[str, str]], ir.Function] | None
```

Guarda a representacao LLVM de uma classe.

Uma classe da linguagem e representada como uma `struct` no LLVM. Por exemplo:

```jss
class Pessoa {
    str nome;
    int idade;
}
```

Conceitualmente vira algo como:

```llvm
%Pessoa = type { i8*, i32 }
```

O campo `attr_index` guarda a posicao de cada atributo dentro da struct:

- `nome` -> indice `0`
- `idade` -> indice `1`

Isso e necessario para gerar `getelementptr` ao acessar:

```jss
this.idade
```

## Modulo LLVM e runtime

No construtor, o gerador cria o modulo:

```python
self.module = ir.Module(name="SimplifiedJSS")
self.module.triple = "x86_64-pc-linux-gnu"
```

O `triple` informa o alvo esperado. Neste projeto, foi escolhido Linux x86_64 porque o usuario compila no WSL com `clang`.

O gerador tambem declara algumas funcoes externas da libc:

```python
printf
scanf
malloc
sprintf
strchr
strcat
```

Elas nao sao implementadas no IR. Apenas sao declaradas, e o `clang` resolve essas chamadas na linkagem.

Uso de cada uma:

- `printf`: saida do `console.log`;
- `scanf`: entrada do `input`;
- `malloc`: alocar strings e objetos;
- `sprintf`: converter valores para string;
- `strchr`: verificar se um real formatado possui `.`, `e` ou `E`;
- `strcat`: acrescentar `.0` em reais inteiros, como `42.0`.

## Passadas de declaracao

O metodo `visitProgram` nao gera tudo em uma unica passada. Ele faz varias passadas:

```python
def visitProgram(self, ctx):
    # 1. predeclara classes
    # 2. predeclara funcoes
    # 3. preenche layouts de classes
    # 4. emite corpos de funcoes e metodos
    # 5. emite main real
```

Essa decisao existe por causa de referencias antecipadas.

Exemplo:

```jss
function int fatorial(int n) {
    return n * fatorial(n - 1);
}
```

Quando o corpo de `fatorial` e gerado, a funcao `fatorial` ja precisa existir no modulo LLVM. Por isso a assinatura e criada antes do corpo.

O mesmo vale para classes: antes de emitir metodos ou acessar atributos, o gerador precisa conhecer a struct da classe.

## Geracao do `main`

Existe uma diferenca entre:

```jss
function void main() {
}
```

e o `main` real esperado pelo sistema operacional.

Em C/LLVM, o ponto de entrada normalmente e:

```llvm
define i32 @main()
```

Mas a linguagem aceita:

```jss
function void main()
```

Para evitar conflito, o gerador renomeia a funcao da linguagem:

```python
llvm_name = "jss_main" if name == "main" else name
```

Depois cria um `main` real que:

1. executa statements globais;
2. chama `jss_main`, se existir;
3. retorna `0`.

Isso permite programas com statements globais e programas com `function void main()`.

## Escopos

Os escopos sao controlados por uma pilha:

```python
self.scopes: list[dict[str, Slot]] = []
```

Cada escopo e um dicionario:

```python
{
    "x": Slot(...),
    "y": Slot(...),
}
```

Quando entra em um bloco:

```python
self.push_scope()
```

Quando sai:

```python
self.pop_scope()
```

A busca de variavel acontece de dentro para fora:

```python
def resolve(self, name):
    for scope in reversed(self.scopes):
        if name in scope:
            return scope[name]
```

Isso implementa sombreamento natural:

```jss
let int x = 1;
{
    let int x = 2;
    console.log(x); // 2
}
console.log(x); // 1
```

O escopo mais interno e consultado primeiro.

## Variaveis e declaracoes

Declaracoes passam por `emit_var_decl`.

Exemplo:

```jss
let int x = 10;
```

Estrategia:

1. Descobrir o tipo da linguagem: `int`;
2. Converter para tipo LLVM: `i32`;
3. Criar espaco local com `alloca`;
4. Registrar no escopo atual;
5. Gerar o valor inicial;
6. Gravar com `store`.

Conceitualmente:

```llvm
%x = alloca i32
store i32 10, i32* %x
```

Para variaveis sem inicializador, o gerador usa `default_value`:

- `int`: `0`
- `real`: `0.0`
- `bool`: `false`
- `str`: `""`
- classe: `null`

## Arrays

Arrays sao tipos reais no LLVM, usando `ir.ArrayType`.

Exemplo:

```jss
let int[5] numeros;
```

Vira algo como:

```llvm
[5 x i32]
```

Array bidimensional:

```jss
let int[3][3] matriz;
```

Vira:

```llvm
[3 x [3 x i32]]
```

O metodo `llvm_type` monta isso de dentro para fora:

```python
out = self.llvm_type(base)
for dim in reversed(dims):
    out = ir.ArrayType(out, dim)
```

### Acesso a arrays

Para acessar:

```jss
numeros[i]
```

o gerador usa `getelementptr`, via:

```python
self.builder.gep(ptr, [self.i32(0), idx], inbounds=True)
```

O primeiro indice `0` entra no array alocado. O segundo indice seleciona o elemento.

Para arrays multidimensionais, cada acesso reduz uma dimensao do tipo:

```python
typ = typ[:-2]
```

Assim:

- `int[][]` apos `[i]` vira `int[]`;
- `int[]` apos `[j]` vira `int`.

## Parametros

Parametros primitivos sao copiados para um `alloca` local.

Exemplo:

```jss
function int soma(int a, int b)
```

Os argumentos LLVM chegam como valores. O gerador cria slots locais:

```llvm
%a = alloca i32
store i32 %.arg, i32* %a
```

Isso simplifica atribuicoes e leituras, porque parametros e variaveis locais passam a ser tratados do mesmo jeito.

Arrays, objetos e `this` sao diferentes: eles ja sao ponteiros. O gerador registra diretamente no escopo.

Motivo: copiar arrays e objetos inteiros seria mais caro e mais complicado. Passar por ponteiro combina melhor com a semantica esperada.

## Funcoes

Funcoes sao predeclaradas em `predeclare_function`.

Depois o corpo e emitido por `emit_function_body`.

O corpo de funcao segue esta estrategia:

1. criar bloco `entry`;
2. posicionar o `IRBuilder`;
3. abrir novo escopo;
4. registrar parametros;
5. visitar statements do bloco;
6. emitir retorno padrao se necessario;
7. fechar escopo;
8. restaurar contexto anterior.

O contexto anterior precisa ser restaurado porque uma funcao pode ser emitida enquanto o gerador estava em outro estado de classe, funcao ou builder.

## Classes

Classes sao implementadas como structs.

Exemplo:

```jss
class Contador {
    int valor;
}
```

Vira uma struct LLVM identificada:

```llvm
%Contador = type { i32 }
```

### Metodos

LLVM IR nao tem metodos de objeto como uma linguagem orientada a objetos. Entao o gerador transforma metodos em funcoes livres com `this` explicito.

Exemplo:

```jss
c.incrementar();
```

Conceitualmente vira:

```llvm
call void @Contador_incrementar(%Contador* %c)
```

O metodo:

```jss
void incrementar() {
    this.valor = this.valor + 1;
}
```

vira uma funcao:

```llvm
define void @Contador_incrementar(%Contador* %this)
```

### Constructor

Objetos sao alocados com `malloc`.

Para:

```jss
let Contador c = new Contador();
```

o gerador:

1. calcula o tamanho da struct;
2. chama `malloc`;
3. faz `bitcast` para `%Contador*`;
4. chama o constructor, se existir.

O tamanho da struct e calculado com a tecnica:

```python
ptr = ir.Constant(typ.as_pointer(), None)
gep = self.builder.gep(ptr, [ir.IntType(32)(1)])
return self.builder.ptrtoint(gep, ir.IntType(64))
```

Essa tecnica equivale a perguntar: "qual seria o endereco de `ptr[1]` se `ptr` fosse um ponteiro para essa struct?". A diferenca entre `ptr[0]` e `ptr[1]` e o tamanho do tipo.

## Lvalues

Um ponto central do gerador e diferenciar valor de endereco.

Em:

```jss
x + 1
```

precisamos do valor de `x`.

Em:

```jss
x = 10
```

precisamos do endereco de `x`.

O metodo `assignable_ptr` resolve o endereco final de algo atribuivel:

- variavel simples;
- `this`;
- acesso a array;
- acesso a atributo;
- combinacoes como `this.matriz[i][j]`.

Exemplo:

```jss
this.matriz[i][j] = valor;
```

O gerador resolve passo a passo:

1. pega o ponteiro de `this`;
2. acessa o campo `matriz` com `getelementptr`;
3. acessa o indice `[i]`;
4. acessa o indice `[j]`;
5. retorna o ponteiro final;
6. o `visitAssignment` faz `store`.

## Atribuicoes

O metodo `visitAssignment` cobre:

```jss
x = 10;
x += 2;
x -= 2;
x *= 2;
x /= 2;
x %= 2;
```

Para atribuicao simples:

```python
store rhs, lhs_ptr
```

Para atribuicao composta:

1. resolve endereco do lado esquerdo;
2. carrega valor atual;
3. calcula operacao;
4. grava resultado.

Exemplo:

```jss
x += 5;
```

Conceitualmente:

```llvm
%old = load i32, i32* %x
%new = add i32 %old, 5
store i32 %new, i32* %x
```

## Expressoes

As expressoes seguem a precedencia definida na gramatica:

```text
assignment
logicalOr
logicalAnd
equality
relational
additive
multiplicative
power
unary
postfix
primary
```

Cada metodo visita o nivel abaixo e combina os resultados.

Exemplo:

```jss
a + b * c
```

`visitAdditive` combina:

- lado esquerdo: `a`
- operador: `+`
- lado direito: resultado de `b * c`, calculado antes em `visitMultiplicative`

## Operacoes binarias

O metodo `binary` decide qual instrucao LLVM usar.

Para inteiros:

- `+`: `add`
- `-`: `sub`
- `*`: `mul`
- `/`: `sdiv`
- `%`: `srem`

Para reais:

- `+`: `fadd`
- `-`: `fsub`
- `*`: `fmul`
- `/`: `fdiv`

Se um dos lados for `real`, o outro e promovido para `real`.

Exemplo:

```jss
10 + 3.5
```

O `10` vira `double` com:

```llvm
sitofp i32 10 to double
```

Depois a soma usa:

```llvm
fadd double
```

## Comparacoes

O metodo `compare` usa:

- `icmp` para inteiros e bools;
- `fcmp` para reais.

Exemplo:

```jss
4 > 0
```

Vira:

```llvm
icmp sgt i32 4, 0
```

O resultado e `i1`, que representa `bool`.

## Booleanos

Internamente, `bool` e `i1` no LLVM.

Mas na impressao, a linguagem espera:

```text
true
false
```

Nao:

```text
1
0
```

Por isso existe:

```python
def bool_to_string(self, value):
    text = self.builder.select(value, self.string_const("true"), self.string_const("false"))
    return Value(text, "str")
```

O `select` do LLVM escolhe entre duas strings sem precisar criar um `if`.

## Reais

`real` e representado como `double`.

Na impressao, foi tomada uma decisao especifica:

- `3.14` imprime como `3.14`;
- `42.0` imprime como `42.0`, nao como `42`;
- evita `42.000000`.

Para isso, `real_to_string` faz:

1. `sprintf("%.15g", value)`;
2. verifica se a string possui `.`, `e` ou `E`;
3. se nao tiver, concatena `.0`.

Assim, um cast:

```jss
let real valor_real = real(42);
console.log(valor_real);
```

imprime:

```text
42.0
```

## Strings

Strings sao representadas como `i8*`, ou seja, ponteiro para char.

Literais de string viram globais constantes:

```python
glob = ir.GlobalVariable(self.module, ir.ArrayType(self.i8, len(data)), name=name)
glob.global_constant = True
```

Depois o gerador retorna um `char*` para o inicio da string.

Concatencao:

```jss
"Ola " + nome
```

usa `sprintf` em um buffer novo alocado com `malloc`.

## Potencia

Inicialmente seria possivel chamar `pow` da biblioteca matematica. Mas isso exigiria linkar com `-lm`.

Como a linguagem valida `**` apenas para inteiros, a decisao foi gerar potencia inteira diretamente em LLVM.

Exemplo:

```jss
a ** b
```

O metodo `int_power` gera um loop:

```text
result = 1
while exponent > 0:
    result = result * base
    exponent = exponent - 1
```

Isso evita dependencia externa de `pow`.

## Controle de fluxo

LLVM trabalha com blocos basicos e saltos explicitos.

### If

Um `if` gera blocos:

- `ifthen`
- `ifnext`
- `ifend`

Para `else if`, o gerador cria uma cadeia de testes. Cada teste falso pula para o proximo.

### While

Um `while` vira:

```text
while.cond
while.body
while.end
```

Fluxo:

1. pula para `while.cond`;
2. avalia condicao;
3. se true, vai para `while.body`;
4. se false, vai para `while.end`;
5. ao fim do corpo, volta para `while.cond`.

### For

Um `for` vira:

```text
for.cond
for.body
for.step
for.end
```

Fluxo:

1. executa inicializador;
2. testa condicao;
3. executa corpo;
4. executa passo;
5. volta para condicao.

### Break

O gerador usa:

```python
self.loop_stack
```

Quando entra em um loop, empilha o bloco de saida. Quando encontra `break`, gera:

```python
self.builder.branch(self.loop_stack[-1])
```

Assim, `break` sempre pula para o fim do loop mais interno.

## Input e output

### `console.log`

`console.log` aceita multiplos argumentos de tipos diferentes.

Exemplo:

```jss
console.log("x =", x, "ativo =", ativo);
```

O gerador imprime um argumento por vez, escolhendo a estrategia pelo tipo:

- `int`: `printf("%d")`
- `real`: converte para string formatada e imprime
- `bool`: converte para `"true"` ou `"false"`
- `str`: `printf("%s")`

Entre argumentos, o gerador imprime espaco. No final, imprime quebra de linha.

### `input`

`input` recebe lvalues:

```jss
input(a, b, nome);
```

O gerador resolve o endereco de cada variavel com `assignable_ptr` e chama `scanf`.

Para strings, aloca buffer com `malloc(4096)` e usa:

```c
%4095s
```

para limitar a leitura.

## Mapeamento de tipos

O metodo `llvm_type` centraliza o mapeamento:

| Linguagem | LLVM |
|---|---|
| `int` | `i32` |
| `real` | `double` |
| `bool` | `i1` |
| `str` | `i8*` |
| `void` | `void` |
| classe | ponteiro para struct |
| array | `ir.ArrayType` |

Classes sao ponteiros porque objetos sao alocados dinamicamente com `malloc`.

Arrays locais sao alocados por valor, mas arrays passados como parametro viram ponteiro para o array.

## Decisoes importantes

### Separar checagem semantica de geracao

O `CodeGenerator` nao tenta provar se os tipos estao corretos. Isso e trabalho do `StaticChecker`.

Vantagem:

- gerador menor;
- menos duplicacao de regra;
- erros de usuario aparecem antes da geracao;
- o codegen pode assumir um programa bem formado.

### Usar `alloca` para variaveis primitivas

Mesmo valores simples sao guardados em memoria local.

Isso torna uniforme:

- atribuicao;
- incremento;
- decremento;
- passagem por escopo;
- leitura com `load`.

### Passar objetos e arrays por ponteiro

Objetos e arrays podem ser grandes. Passar/copiar por valor complicaria o IR e mudaria o comportamento esperado.

Por ponteiro, metodos e funcoes podem acessar a mesma estrutura.

### Metodos como funcoes com `this`

LLVM nao entende classes diretamente. Entao:

```jss
obj.metodo(a, b)
```

vira:

```text
Classe_metodo(obj, a, b)
```

Essa e uma estrategia classica de compiladores para linguagens orientadas a objeto.

### Potencia inteira inline

Evita dependencia de `pow` e `-lm`.

Tambem combina com a regra semantica da linguagem, onde `**` exige inteiros.

## Fluxo completo de exemplo

Codigo fonte:

```jss
function bool ehPar(int n) {
    return (n % 2) == 0;
}

let bool par = ehPar(10);
console.log(par);
```

Passos:

1. `predeclare_function` declara `ehPar`;
2. `emit_function_body` gera o corpo;
3. parametro `n` ganha `alloca`;
4. `n % 2` gera `srem`;
5. comparacao com `0` gera `icmp`;
6. retorno devolve `i1`;
7. variavel `par` e alocada como `i1`;
8. chamada `ehPar(10)` grava resultado em `par`;
9. `console.log(par)` converte `i1` para `"true"` ou `"false"`;
10. `printf("%s")` imprime o texto.

## Como explicar em aula

Uma boa ordem para apresentar:

1. Mostrar que LLVM IR e uma linguagem intermediaria tipada.
2. Explicar `Module`, `Function`, `BasicBlock` e `IRBuilder`.
3. Mostrar o papel do visitor do ANTLR.
4. Explicar as dataclasses `Value`, `Slot` e `ClassLayout`.
5. Explicar a pilha de escopos.
6. Mostrar declaracao de variavel com `alloca`, `store` e `load`.
7. Mostrar expressoes aritmeticas.
8. Mostrar controle de fluxo com blocos e branches.
9. Mostrar funcoes e recursao por predeclaracao.
10. Mostrar classes como structs com `this` explicito.
11. Mostrar strings e runtime externo (`printf`, `scanf`, `malloc`).
12. Fechar com decisoes praticas: bool textual, real com `.0`, potencia sem `pow`.

## Resumo final

O `codegen.py` transforma a linguagem SimplifiedJSS em LLVM IR usando uma estrategia direta:

- AST do ANTLR e percorrida com visitor;
- escopos sao pilhas de dicionarios;
- variaveis sao ponteiros LLVM registrados em `Slot`;
- expressoes retornam `Value`;
- classes viram structs;
- metodos viram funcoes com `this`;
- controle de fluxo vira blocos basicos e branches;
- entrada/saida usa funcoes da libc;
- o resultado final e um `.ll` compilavel com `clang`.

Essa implementacao privilegia clareza didatica e compatibilidade com o pipeline usado no projeto.

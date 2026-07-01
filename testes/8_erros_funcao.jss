// Testes de erros semanticos em funcoes (arquivo deve falhar na compilacao)

// ERRO: funcao int sem return
function int semReturn() {
    let int x = 10;
    console.log(x);
    return x;
}

// ERRO: funcao void com return de valor
function void voidComValor() {
    return;
}

// ERRO: funcao int com return sem valor
function int intSemValor() {
    return 10;
}

// ERRO: tipo de retorno incompativel
function str tipoRetornoErrado() {
    return "string";
}

// ERRO: funcao str sem return
function str strSemReturn() {
    let str s = "hello";
    console.log(s);
    return s;
}


// Funcao com multiplos parametros
function real calcularMedia(int a, int b, int c) {
    let int soma = a + b + c;
    return real(soma) / 3.0;
}


// ERRO: parâmetro incorreto quantidade
console.log(calcularMedia(2, 3, 4));

// ERRO: parâmetro incorreto tipo
console.log(calcularMedia(2, 3, 4));

// ERRO: parâmetro incorreto tipo e quantidade
console.log(calcularMedia(2, int(3.0), 4));

console.log(semReturn());
console.log(intSemValor());
console.log(tipoRetornoErrado());
console.log(strSemReturn());
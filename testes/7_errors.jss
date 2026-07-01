// Testes de erros semanticos (arquivo deve falhar na compilacao)

let int x = 10;



// ERRO: atribuicao em constante
const int c = 100;
console.log(c);


// ERRO: tipo incompativel em operacao
let real r = 5.5;
let int b = int(r) + 10;


// ERRO: cast invalido de string para bool
let bool flag = bool(b);

// ERRO: concatenacao invalida (string + int)
let str msg = "Valor: " + 10;
console.log(msg);

// ERRO: operacao entre tipos incompativeis
let int resultado = b * 2;

let int n=4;
//variavel nao declarado em for
for(let int i = 0+0; i < n; i++){
    console.log(i);
}

//variavel i local do bloco anterior nao declarada
let int i;
x = 89;
let int y = 0;
for(i = 0+0; i < n; i++){
    console.log(x, y);
    x++;
    y++;
    
}

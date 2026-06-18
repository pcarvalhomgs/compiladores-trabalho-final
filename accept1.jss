class Pessoa {

    str nome;

    Pessoa constructor(str nome) {
        this.nome = nome;
    }

    str getNome() {
        return this.nome;
    }
}

function int soma(int a, int b) {
    return a + b;
}

function void main() {

    let int x = 10;
    let int y = 20;

    let int resultado;
    resultado = soma(x, y);

    let Pessoa p;
    p = new Pessoa("Pablo");

    console.log(resultado);
    console.log(p.getNome());
}
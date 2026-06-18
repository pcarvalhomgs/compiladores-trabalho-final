class Vetor {

    int valor;

    Vetor constructor(int v) {
        this.valor = v;
    }

    int get() {
        return this.valor;
    }
}

function void main() {

    let Vetor[2] lista;

    lista[0] = new Vetor(10);
    lista[1] = new Vetor(20);

    console.log(lista[0].get());
    console.log(lista[1].get());
}
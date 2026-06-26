function void main() {

    let int a = 10;
    let real b = 5.5;
    let bool ativo = true;

    console.log(a < b);
    console.log(a >= b);

    console.log(a == 10);
    console.log(b != 10.0);

    console.log((a < b) && ativo);
    console.log((a > b) || ativo);

    console.log(!(a > b));
}
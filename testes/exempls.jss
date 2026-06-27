// declarações globais
let int i1; 
let int i2 = 10; 
let int i3, i4, i5; 

i1 = 1; 
i2 = 2 + 3; 
i3 = 10; 
i4 = 100; 
i5 = 1000;

let int [3] l1; 
let int [3] l2 = [0+1 ,1+2 ,2+3]; 
const str[3] nomes = ["Ana", "Bruno", "Carlos"];

// classes
class Ponto { 
    int x; 
    int y; 
 
    Ponto constructor (int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
 
    int soma () { 
        return this.x + this.y; 
    } 
}

let Ponto p1; 
p1 = new Ponto (1 ,2); 
p1 = null; 
const Ponto p2 = new Ponto (10 ,100);

// Funçoes
function real media3(real n1 , real n2 , real n3 ) { 
    let real media = (n1+n2+n3)/3; 
    return media ; 
} 
 
function int somarArray(int[5] arr) { 
    let int total = 0; 
    for (let int i = 0; i < 5; i = i + 1) { 
        total += arr[i]; 
    } 
    return total; 
}

// nativas
let int a, b, c, d;
console.log("Digite um número "); 
input(a); 
console.log("Digite três números "); 
input(b, c, d); 
console.log ("Soma: ", a+b+c+d); 
console.log ( ); 
console.log(int (3.9) ); 
console.log (int(true)); 
console.log (real (10)); 
console.log (real(true)); 
console.log (bool (1)); 
console.log (bool (0.0) ); 
console.log (str (10 + 5)); 
console.log (str(true));

// main
function int fatorial (int fat) { 
    if (fat > 1) { 
            console.log(fat); 
            return fat * fatorial (fat - 1); 
    } else { 
            return 1; 
    } 
} 
 
function void printMedia (int v1 , int v2) { 
    const real x = media (real(v1) ,real(v2)); 
    console.log (" Resultado : ", x); 
} 
 
function real media ( real n1 , real n2) { 
    return (n1 + n2)/2; 
} 
 
function void main( ) {  // facultativo a declaração de uma função main 
    let int numero ; 
    let int n1 , n2; 
    console.log (" Programa Fatorial. Digite o valor: "); 
    input( numero ); 
    console.log ( fatorial ( numero )); 
    console.log (" Programa Media . Digite os valores: "); 
    input(n1 , n2); 
    console.log(media (real(n1) , real(n2))); 
}
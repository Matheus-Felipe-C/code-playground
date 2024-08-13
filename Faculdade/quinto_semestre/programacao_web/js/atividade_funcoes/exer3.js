let lista1 = [5, 8, 5.6, 9.9];
let lista2 = [3,2,1];

console.log(max(lista1));
console.log(max(lista2));

function max(lista) {
    let maior = lista[0];

    lista.forEach(num => {
        if (num > maior) maior = num;    
    });

    return maior;
}
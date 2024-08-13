let array = [1,2,3,4];
let result = multArray(array, 3);

function multArray(array, valor) {
    for (let i = 0; i < array.length; i++) {
        array[i] *= valor;
    }

    console.log(array);
    return array;
}
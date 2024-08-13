function calculaFatorial() {
    let valor = document.getElementById('valor').value;
    let resultado = document.getElementById('resultado');
    let n = parseInt(valor);
    let fat = 1;

    for (n; n > 1; n--) {
        fat *= n;
        console.log(fat);
        console.log('n:' + n);
    }

    resultado.value = fat;
}
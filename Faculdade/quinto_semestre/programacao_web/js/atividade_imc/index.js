let massa = window.prompt("Digite sua massa");
let altura = window.prompt("Digite sua altura");

let result = imc(massa, altura);

window.alert(result);

function imc(massa, altura) {
    let imc = (massa * 10000)/(altura * altura);
    let result = "Você está: ";

    if (imc > 30) result += "Obesidade";
    else if (imc > 25 && imc < 30) result += "Sobrepeso";
    else if (imc > 18 && imc < 25) result += "Saudável";
    else result += "Magreza leve";

    return result;
}
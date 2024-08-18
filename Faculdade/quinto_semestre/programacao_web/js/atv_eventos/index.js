function valida() {
    if (regform.nome.value == "") {
        alert("Voce esqueceu de fornecer seu nome");
        return;
    }
    else if (!emailValido(regform.email.value)) {
        alert('Email inválido, insida um email válido');
        return;
    }
    else if (regform.cidade.value == "") {
        alert("Você esqueceu de fornecer sua cidade");
        return;
    }
    else if (regform.estado.value == "") {
        alert("Você esqueceu de fornecer seu estado");
        return;
    }
    else if (regform.mensagem.value == "") {
        alert("Você esqueceu de adicionar sua mensagem");
        return;
    }
    else regform.submit();
}

/**
 * Valida o email
 * @param {string} email 
 * @returns {boolean}
 */
function emailValido(email) {
    const arrobaIndex = email.indexOf('@');
    if (arrobaIndex < 1) return false;

    const pontoIndex = email.indexOf('.', arrobaIndex);
    if (pontoIndex <= arrobaIndex + 1) return false;

    if (pontoIndex === email.length - 1) return false;

    return true;
}
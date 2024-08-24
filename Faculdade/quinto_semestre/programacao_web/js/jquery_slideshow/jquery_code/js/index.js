/**
 * Função que realiza a manipulação dos slides
 */
function slide() {
    if ($(".ativo").next().length) {
        $(".ativo").fadeOut().removeClass("ativo").next().fadeIn().addClass("ativo");
    } else {
        $(".ativo").fadeOut().removeClass("ativo");
        $("#slide img:eq(0)").fadeIn().addClass("ativo");
    }

    let texto = $(".ativo").attr("alt");
    $("#slide p").hide().html(texto).delay(100).fadeIn();
}

// Estilização do slideshow

$(document).ready(() => {
    $("#slide img:eq(0)").addClass("ativo").show();
    //Adiciona legenda das imagems
    
    var texto = $(".ativo").attr("alt");
    $("#slide").prepend("<p>" + texto + "</p>");

    setInterval(slide, 3000);
})


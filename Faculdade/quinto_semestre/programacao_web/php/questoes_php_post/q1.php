<?php
    $nome = $_POST['nome'];
    $nota1 = $_POST['nota1'];
    $nota2 = $_POST['nota2'];
    $nota3 = $_POST['nota3'];

    if (empty($nome) || empty($nota1) || empty($nota2) || empty($nota3)) {
        echo "Algum campo obrigatório em branco";
    } else {
        $media = ($nota1 + $nota2 + $nota3) / 3;

        if ($media >= 6) {
            echo "Aprovado";
        } else {
            echo "Reprovado";
        }
    }

<?php
    $altura = $_POST['altura'];
    $peso = $_POST['peso'];

    $imc = $peso / ($altura * $altura);
    $nivel_obesidade = "";

    if ($imc < 16) $nivel_obesidade = "Magreza grave";
    else if ($imc < 17) $nivel_obesidade = "Magreza moderada";
    else if ($imc < 18.5) $nivel_obesidade = "Magreza leve";
    else if ($imc < 25) $nivel_obesidade = "Saudável";
    else if ($imc < 30) $nivel_obesidade = "Obeso";
    else if ($imc < 35) $nivel_obesidade = "Obesidade grau I";
    else if ($imc < 40) $nivel_obesidade = "Obesidade grau II (severa)";
    else $nivel_obesidade = "Obesidade grau III (mórbida)";

    echo "Nível de obesidade: $nivel_obesidade";
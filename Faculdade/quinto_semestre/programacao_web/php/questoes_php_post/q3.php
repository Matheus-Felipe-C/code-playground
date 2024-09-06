<?php
    $num1 = $_POST['num1'];
    $num2 = $_POST['num2'];

    $soma = $num1 + $num2;
    $multiplicacao  = $num1 * $num2;
    $divisao = $num1 / $num2;

    echo "Soma $num1 + $num2 = $soma\n";
    echo "\nMultiplicação $num1 * $num2 = $multiplicacao\n";
    echo "\nDivisão $num1 / $num2 = $divisao\n";
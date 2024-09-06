<?php
    $idade = $_POST['idade'];

    if (empty($idade)) {
        echo "Idade não pode estar vazia";
    } else if (is_numeric($idade)) {
        if ($idade >= 18) {
            echo "Usuário maior de idade";
        } else {
            echo "Usuário menor de idade";   
        }
    } else {
        echo "Idade não é um número";
    }
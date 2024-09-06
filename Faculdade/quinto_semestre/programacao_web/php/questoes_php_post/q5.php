<?php
    $nome = $_POST['nome-q5'];
    $data_nascimento = $_POST['nascimento'];

    $data_nascimento_obj = new DateTime($data_nascimento);

    $data_atual = new DateTime();

    $data_diff = $data_atual->diff($data_nascimento_obj);

    $idade = $data_diff->y;

    echo "Nome $nome\nIdade: $idade";
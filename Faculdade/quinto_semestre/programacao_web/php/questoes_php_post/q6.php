<?php
    $valores = $_POST['valores'];
    $valores_array = explode(",", $valores);
    $media = 0;

    foreach ($valores_array as $valor) {
        $media += $valor;
    }

    $media /= sizeof($valores_array);

    echo "Media: $media";
<?php
    $num1 = $_POST['num1'];
    $num2 = $_POST['num2'];

    $result = "";

    for( $i = $num1; $i <= $num2; $i++ ) {
        $result .= strval($i) . " ";
    }

    echo $result;

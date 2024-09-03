<?php
// Path to the php.ini file. Modify this path as needed.
$phpIniPath = php_ini_loaded_file();

if (!$phpIniPath) {
    die("php.ini file not found.\n");
}

// Read the contents of php.ini
$phpIniContents = file_get_contents($phpIniPath);

if ($phpIniContents === false) {
    die("Failed to read php.ini file.\n");
}

// Check if the intl extension line exists
if (strpos($phpIniContents, 'extension=intl') === false) {
    // Add the line to enable intl extension
    $phpIniContents .= "\nextension=intl\n";
    file_put_contents($phpIniPath, $phpIniContents);
    echo "Intl extension has been added to php.ini.\n";
} else {
    // If the line exists but is commented out, uncomment it
    $phpIniContents = preg_replace('/;\s*extension=intl/', 'extension=intl', $phpIniContents);
    file_put_contents($phpIniPath, $phpIniContents);
    echo "Intl extension has been uncommented in php.ini.\n";
}


// Define o fuso horário
date_default_timezone_set('America/Sao_Paulo');

// Cria um objeto DateTime para a data desejada
$data = new DateTime('2023-02-04');

// Configura a formatação de data para português do Brasil utilizando IntlDateFormatter
$formatter = new IntlDateFormatter(
    'pt_BR',                   // Locale para português do Brasil
    IntlDateFormatter::FULL,   // Formato de data completo (incluindo dia da semana)
    IntlDateFormatter::NONE    // Nenhum formato para a hora (apenas data)
);

// Formata a data
$dataFormatada = $formatter->format($data);

// Exibe a data formatada
echo $dataFormatada;
?>

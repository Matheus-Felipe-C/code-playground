#include <stdio.h>
#include <string.h>
/*
void inverteBinario(char *dest, char *y) {
    for (int i = 0; i < 32; i++) {
        if (y[i] == '1') dest[i] = '0';
        else dest[i] = '1';
    }

    if (dest[31] == '0') dest[31] = '1';
}

char* calcBinario(char *x, char *y, int operacao) {
    char zero[32], novoY[32];
    strcpy(zero, "0000000000000000000000000000000");

    //Verifica se algum número é igual a 0
    if (strcmp(x, zero) == 0) return y;
    if (strcmp(y, zero) == 0) return x;

    //Verifica se é subtração ou soma. 1 para soma e 0 para subtração
    if (operacao == 0) {
        //Inverte os valores de y
        inverteBinario(novoY, y);
    } else strcpy(novoY, y);

    printf("%s\n", novoY);


    return NULL;
}
*/

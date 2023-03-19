#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void inverteBinario(char *y, int size) {
    char dest[size];

    for (int i = 0; i < size; i++) {
        if (y[i] == '1') dest[i] = '0';
        else dest[i] = '1';
    }

    strcpy(y, dest);
}

void igualaExpoentes(char *a, char *b, int size) {
    int exp_a = 0, exp_b = 0, diff;

    for (int i = 1; i <= 8; i++) {
        exp_a = exp_a * 2 + (a[i] - '0');
        exp_b = exp_b * 2 + (b[i] - '0');
    }
    exp_a -= 127;
    exp_b -= 127;

    // Determine which exponent is larger and adjust the smaller one
    if (exp_a > exp_b) {
        // Adjust b's exponent to match a's exponent
        int diff = exp_a - exp_b;
        for (int i = 9; i <= 31; i++) {
            b[i] = (diff >= 0 && diff < 23) ? a[i - diff] : '0';
            diff--;
        }

        printf("%s\n", b);
    } else if (exp_b > exp_a) {
        // Adjust a's exponent to match b's exponent
        int diff = exp_b - exp_a;
        for (int i = 9; i <= 31; i++) {
            a[i] = (diff >= 0 && diff < 23) ? b[i - diff] : '0';
            diff--;
        }

        printf("%s\n", a);
    }
}

int main() {

  char num1[100], num2[100];
    strcpy(num1, "01000000100000000000000000000000");
    strcpy(num2, "00111111011000000000000000000000");

    igualaExpoentes(num1, num2, strlen(num2));


  return 0;
}

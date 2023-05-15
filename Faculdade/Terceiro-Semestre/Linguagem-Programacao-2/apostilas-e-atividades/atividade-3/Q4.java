package testes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[50];
		int valor = 100;
		for (int i = 0; i < 50; i++) {
			numeros[i] = ++valor;
			System.out.println("Valor da posição " + (i+1) + "é: " + numeros[i]);
		}
		
		scan.close();
	}

}

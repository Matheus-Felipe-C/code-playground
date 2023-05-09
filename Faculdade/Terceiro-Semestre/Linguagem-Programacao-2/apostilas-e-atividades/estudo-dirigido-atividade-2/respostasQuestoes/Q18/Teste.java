package testesLp2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculadora calculadora = new Calculadora();
		int input, n1, n2;
		
		while (true) {
			System.out.println("Digite o numero correspondente a operação desejada e aperte <enter>");
			System.out.println("********************************************************\n");
			System.out.println("********************************************************");
			
			System.out.println("* 1 - Adição de dois números");
			System.out.println("* 2 - Subtração de dois números");
			System.out.println("* 3 - Multiplicação de dois números");
			System.out.println("* 4 - Divisão de dois números");
			System.out.println("* 5 - O resto da divisão(módulo) de dois números");
			System.out.println("* 9 - Encerrar o programa");
			System.out.println("********************************************************");
			
			input = scan.nextInt();
			
			if (input == 9) {
				System.out.println("Obrigado por usar a calculadora!");
				break;
			} else {
				System.out.println("Digite o primeiro número");
				n1 = scan.nextInt();
				
				System.out.println("Digite o segundo número");
				n2 = scan.nextInt();
			}
			
			//TODO - chamar funções da classe Calculadora
			switch(input) {
			case 1:
				System.out.println("Resultado da soma: " + calculadora.soma(n1, n2) );
				break;
			case 2:
				System.out.println("Resultado da subtracao: " + calculadora.subtracao(n1, n2));
				break;
			case 3:
				System.out.println("Resultado da multiplicação: " + calculadora.multiplicacao(n1, n2));
				break;
			case 4:
				System.out.println("Resultado da divisão: " + calculadora.divisao(n1, n2));
				break;
			case 5:
				System.out.println("Resultado do resto da soma: " + calculadora.modulo(n1, n2));
				break;
			default:
				System.out.println("Operação inválida, tente novamente");
			}
				
		}
	}

}

package testes;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double salario = 0, reajuste;
		ArrayList<Double> salarios = new ArrayList<Double>();
		
		while (salario != -1) {
			System.out.println("Digite o valor do salário");
			salario = scan.nextDouble();
			
			salarios.add(salario);
		}
		
		//Retira o último salário adicionado (-1)
		salarios.remove(salarios.size() - 1);
		
		System.out.println("Digite a porcentagem de reajuste salarial");
		reajuste = scan.nextDouble();
		
		for (double novoSalario : salarios) {
			novoSalario += novoSalario * (reajuste/100);
			System.out.println("O novo salário reajustado é: " + novoSalario);
		}
		
		scan.close();
	}

}

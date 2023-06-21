package q1;

public class Main {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Stevão Ferreira", 120, 15);
		
		f1.exibeDados();
		
		Conta c1 = new Conta("1234", "Stevão Ferreira", 200);
		
		if (c1.saque(200.1f) == 1) {
			System.out.println("Não é possível sacar um valor maior que o em conta");
		} else System.out.println("Saque realizado");
	}
}

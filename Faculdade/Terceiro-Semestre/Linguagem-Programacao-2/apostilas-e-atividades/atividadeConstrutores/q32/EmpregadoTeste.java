package q32;

public class EmpregadoTeste {

	public static void main(String[] args) {
		Empregado e1 = new Empregado("Joazin", "Silva", 100);
		Empregado e2 = new Empregado("Ana Maria", "Braga", 2000);
		
		double aumento = e1.getSalario() + e1.getSalario() * 0.1;
		e1.setSalario(aumento);
		
		aumento = e2.getSalario() + e2.getSalario() * 0.1;
		e2.setSalario(aumento);
		
		System.out.println("Salario de " + e1.getNome() + ": " + e1.getSalario());
		System.out.println("Salario de " + e2.getNome() + ": " + e2.getSalario());
	}

}

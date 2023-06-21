package q2;

public class Main {

	public static void main(String[] args) {
		Produto p1 = new Produto(1, "Canoa", 900, 100, 10);
		
		p1.relatorio();
		p1.setEstoque(9);
		p1.relatorio();
		p1.setEstoque(10);
		p1.relatorio();
	}

}

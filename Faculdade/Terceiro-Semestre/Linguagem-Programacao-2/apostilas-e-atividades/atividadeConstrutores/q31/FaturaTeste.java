package q31;

public class FaturaTeste {

	public static void main(String[] args) {
		Fatura f = new Fatura("123", "Uma fatura mucho loca", -1, -5000);
		
		System.out.println(f.getTotalFatura());//Não entendi, mas tá retornando -0.0????????
		f.setPreco(80);
		f.setQuantidade(10);
		System.out.println(f.getTotalFatura());
	}

}

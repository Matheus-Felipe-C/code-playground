package br.com.bytebank.banco.teste;


public class TesteArrayDePrimitivos {

	public static void main(String[] args) {
		int[] idades = new int[5];
		
		for (int i = 0; i < idades.length; i++) {
			idades[i] = i * i;
			
			System.out.println(idades[i]);
		}
	}

}

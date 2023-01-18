package br.com.bytebank.banco.teste;

public class TesteString {

	public static void main(String[] args) {
		String nome = "Mario"; //Object Literal
		String outro = new String("Alura"); //má prática
		
		// String novo = outro.replace("A", "a");
		// String novo = outro.toUpperCase();
		// String novo = outro.toLowerCase();
		
		// System.out.println(novo);
		
		char c = nome.charAt(3);
		System.out.println(c);
		
		int pos = nome.indexOf("rio");
		System.out.println(pos);
		
		String sub = nome.substring(1);
		System.out.println(sub);
		
		for(int i = 0; i < nome.length(); i++) {
			System.out.println(nome.charAt(i));
		}
	}

}

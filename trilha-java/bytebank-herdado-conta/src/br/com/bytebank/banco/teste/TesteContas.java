package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException{
		
		Object cc = new ContaCorrente(22, 33);
		Object cp = new ContaPoupanca(33, 22);
		
		
		System.out.println(cc);
		System.out.println(cp);
	}

}

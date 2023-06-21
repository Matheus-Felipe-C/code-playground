package q1;

public class Conta {
	private String conta;
	private String cliente;
	private float saldo;
	
	public Conta(String conta, String cliente, float saldo) {
		this.conta = conta;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public void deposito(float qtd) {
		this.setSaldo(this.getSaldo() + qtd);
	}
	
	public int saque(float qtd) {
		if (qtd > this.getSaldo())return 1;
		
		this.setSaldo(this.getSaldo() - qtd);
		return 0;
	}

	//Getters e setters
	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}
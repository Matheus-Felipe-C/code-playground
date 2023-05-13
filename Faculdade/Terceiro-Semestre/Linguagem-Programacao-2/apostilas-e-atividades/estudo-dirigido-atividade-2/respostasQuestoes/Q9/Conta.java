public class Conta {
    private int numero;
    private String nome;
    private double saldo;

    public Conta(int numero, String nome, double saldo) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Valor de R$" + valor + " depositado com sucesso!");
    }

    public void sacar(double valor) {
        if (this.saldo - valor < 0) {
            System.out.println("Você é muito pobre para sacar esse valor");
        } else this.saldo -= valor;
    }
}
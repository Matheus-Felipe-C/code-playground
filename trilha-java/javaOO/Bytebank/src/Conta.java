public class Conta{

    private double saldo;
    private int agencia;
    private int numero;
    Cliente titular;
    private static int total = 0;

    public Conta(int agencia, int numero){
        Conta.total++;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 100; //isso significa que toda conta começa com 100 de saldo.
        System.out.println("Estou criando uma conta");
    }

    public void depositar(double saldo) {
        this.saldo += + saldo;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
}
public class Conta{

    double saldo;
    int agencia;
    int numero;
    String titular;

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
}
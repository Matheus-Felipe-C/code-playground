public class ContaCorrente extends Conta {

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void sacar(double valor) {
        double valorASacar = valor + 0.2;
        super.sacar(valorASacar);
    }
}

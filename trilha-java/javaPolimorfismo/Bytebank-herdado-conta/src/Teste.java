public class Teste {

    public static void main(String[] args) {
        Conta conta = new ContaCorrente(123, 321);

        conta.depositar(200.0);

        try {
            conta.sacar(210.0);
        } catch(SaldoInsuficienteException ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        System.out.println(conta.getSaldo());
    }
}
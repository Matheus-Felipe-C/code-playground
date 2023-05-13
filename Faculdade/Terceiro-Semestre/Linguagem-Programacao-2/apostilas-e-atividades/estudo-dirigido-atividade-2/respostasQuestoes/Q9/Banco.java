public class Banco {
    public static void main(String[] args) {
        Conta conta = new Conta(222, "Pobre Premium", 2000);

        conta.depositar(200);
        conta.sacar(3000);
    }
}
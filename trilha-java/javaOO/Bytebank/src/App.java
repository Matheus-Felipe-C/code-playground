public class App {
    public static void main(String[] args) throws Exception {
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();

        conta1.depositar(100);
        conta2.depositar(500);

        if (conta2.transferir(3000, conta1)) {
            System.out.println("Transferência feita com sucesso");
        } else System.out.println("Você é muito pobre pra isso");

        System.out.println("Conta1 - " + conta1.getSaldo());
        System.out.println("Conta2 - " + conta2.getSaldo());
        
    }
}

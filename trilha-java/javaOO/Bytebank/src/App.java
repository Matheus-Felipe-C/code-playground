public class App {
    public static void main(String[] args) throws Exception {
        Conta conta = new Conta(123,456);
        Conta conta2 = new Conta(123,456);
        
        System.out.println(Conta.getTotal());
    }
}

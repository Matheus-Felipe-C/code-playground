public class Teste {
    public static void main(String[] args) throws Exception {

        ContaCorrente cc = new ContaCorrente(111, 111);
        cc.depositar(100.0);

        ContaPoupanca cp = new ContaPoupanca(222, 222);
        cp.depositar(100.0);

        cc.transferir(10.0, cp);
        System.out.println("CC: " + cc.getSaldo());
        System.out.println("CP: " + cp.getSaldo());
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Autenticavel g1 = new Gerente();
        g1.setSenha(2222);

        Autenticavel adm = new Administrador();
        adm.setSenha(3);

        Autenticavel cliente = new Cliente();
        cliente.setSenha(1);

        SistemaInterno sistema = new SistemaInterno();

        sistema.autentica(g1);
        sistema.autentica(adm);
        sistema.autentica(cliente);
    }
}

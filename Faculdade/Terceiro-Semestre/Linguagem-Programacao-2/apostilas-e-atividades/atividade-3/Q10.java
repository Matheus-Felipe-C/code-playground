import java.util.ArrayList;
import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        int id = 0, idade, telefone;
        String nome;

        while (true) {
            System.out.println("Digite o seu id");
            id = (int) scan.nextInt();

            if (id <= -1) break;

            scan.nextLine(); //Tirando o maldito "\n" do Scanner

            System.out.println("Digite o seu nome");
            nome = scan.nextLine();
            System.out.println("Digite sua idade");
            idade = scan.nextInt();
            System.out.println("Digite o seu telefone");
            telefone = scan.nextInt();

            Cliente cliente = new Cliente(id, nome, idade, telefone);

            listaClientes.add(cliente);

            System.out.println("Cliente criado!\n");
        }

        for (Cliente c : listaClientes) {
            System.out.println(c + "\n"); //Por causa do método toString, ele vira do jeito que foi mostrado
        }

        scan.close();
    }
}

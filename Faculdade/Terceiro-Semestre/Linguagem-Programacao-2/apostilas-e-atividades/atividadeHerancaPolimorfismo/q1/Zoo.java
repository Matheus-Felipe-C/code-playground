import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the mato!\n");

        while (true) {
            System.out.println("\nDigite qual animal deseja criar");
            System.out.println("1 - Leão\n2 - Cachorro\n3 - Gato\n4 - Tigre\n5 - Hipopotamo\n0 - Sair da aplicação");

            System.out.print("\nSua resposta: ");
            char input = scan.next().charAt(0);

            switch(input) {
                case '0':
                    System.out.println("Obrigado por usar a aplicação!");
                    return;
                case '1':
                    Leao leao = new Leao();
                    leao.andar();
                    leao.comer();
                    leao.comunicar();
                    break;
                case '2':
                    Cachorro c = new Cachorro();
                    c.andar();
                    c.comer();
                    c.comunicar();
                    break;
                case '3':
                    Gato g = new Gato();
                    g.andar();
                    g.comer();
                    g.comunicar();
                    break;
                case '4':
                    Tigre t = new Tigre();
                    t.andar();
                    t.comer();
                    t.comunicar();
                    break;
                case '5':
                    Hipopotamo h = new Hipopotamo();
                    h.andar();
                    h.comer();
                    h.comunicar();
                    break;
                default:
                    System.out.println("Opção incorreta, por favor digite uma opção válida\n");
                    break;
            }

            System.out.println("\nDeseja continuar? s/n\nP.S. - Não utilize acentos");
            System.out.print("\nSua resposta: ");
            String resposta = scan.next();

            if (resposta.toLowerCase() == "n" || resposta.toLowerCase() == "nao") break;

        }

        System.out.println("Obrigado por usar a aplicação!");
        scan.close();
    }
}

import java.util.Scanner;

public class Q151 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 0;

        while (num != -999) {
            System.out.println("Digite um número, digite -999 para sair");
            num = scan.nextInt();

            System.out.println("O valor do número multiplicado por 3 é: " + num * 3);
        }
        scan.close();
    }
}
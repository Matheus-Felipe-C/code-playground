import java.util.Scanner;

public class Q152 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 1;

        while (num % 6 != 0) {
            System.out.println("Digite um número, digite um número múltiplo de 6 para sair");
            num = scan.nextInt();

            System.out.println("Valor do número ao quadrado: " + num * num);
        }
        
        scan.close();
    }
}
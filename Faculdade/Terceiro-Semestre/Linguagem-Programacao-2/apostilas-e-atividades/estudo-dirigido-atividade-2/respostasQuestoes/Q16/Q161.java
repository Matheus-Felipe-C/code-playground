import java.util.Scanner;

public class Q161 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numero = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite um número inteiro");
            numero = scan.nextInt();
            System.out.println("O dobro deste número é: " + numero * numero + "\n");
        }
        
        scan.close();
    }
}
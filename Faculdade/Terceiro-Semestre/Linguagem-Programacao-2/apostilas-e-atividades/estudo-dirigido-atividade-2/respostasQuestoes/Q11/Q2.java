import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um número inteiro");
        int num = scan.nextInt();

        if (num % 2 == 0) System.out.println("O número é par");
        else System.out.println("O número é ímpar");

        scan.close();
    }
}
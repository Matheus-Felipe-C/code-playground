import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um número");
        double num = scan.nextDouble();

        if (num > 20) num /= 2;
        System.out.println("Número - " + num);

        scan.close();
    }
}
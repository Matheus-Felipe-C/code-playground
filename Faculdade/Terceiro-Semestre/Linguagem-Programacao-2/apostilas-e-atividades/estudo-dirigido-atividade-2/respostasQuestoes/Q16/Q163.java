import java.util.Scanner;

public class Q163 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int soma = 0;

        for (int i = 0; i < 100; i++) {
            System.out.println("Número: " + (i + 1));

            soma += i + 1;
            System.out.println("Soma: " + soma + "\n");
        }
        scan.close();
    }
}
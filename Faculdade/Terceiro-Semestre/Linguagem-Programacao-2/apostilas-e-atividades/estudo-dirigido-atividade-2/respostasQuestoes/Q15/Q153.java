import java.util.Scanner;

public class Q153 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        int soma = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um número inteiro");
            num = scan.nextInt();
            if(num % 3 == 0) soma += num;
        }
        System.out.println("Média de números múltiplos de 3: " + soma/10.0);
        
        scan.close();
    }
}
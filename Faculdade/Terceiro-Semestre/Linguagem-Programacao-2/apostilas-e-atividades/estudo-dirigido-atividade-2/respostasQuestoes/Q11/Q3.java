import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o primeiro número inteiro");
        int num1 = scan.nextInt();
        System.out.println("Digite o segundo número inteiro");
        int num2 = scan.nextInt();

        int soma = num1 + num2;
        
        if (soma > 20) soma += 8;
        else soma -= 5;

        System.out.println("Valor final da soma: " + soma);

        scan.close();
    }
}
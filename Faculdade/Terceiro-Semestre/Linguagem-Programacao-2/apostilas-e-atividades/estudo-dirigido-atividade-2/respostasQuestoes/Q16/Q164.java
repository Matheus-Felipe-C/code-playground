import java.util.Scanner;

public class Q164 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o número de entradas totais");
        int n = scan.nextInt();
        
        System.out.println("Digite um número");
        int num = scan.nextInt();
        int maior = num;
        int menor = num;

        for (int i = 1; i < n; i++) {
            System.out.println("Digite um número");
            num = scan.nextInt();

            if (num > maior) maior = num;
            else if (num < menor) menor = num;
        }

        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);
        scan.close();
    }
}
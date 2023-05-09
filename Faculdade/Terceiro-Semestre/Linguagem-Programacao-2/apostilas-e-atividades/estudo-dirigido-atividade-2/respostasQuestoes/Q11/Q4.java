import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double desconto;

        System.out.println("Digite seu salário");
        double salarioBruto = scan.nextDouble();

        if (salarioBruto <= 600) desconto = 0;
        else if (salarioBruto > 600 && salarioBruto <= 1200) desconto = 0.2;
        else if (salarioBruto > 1200 && salarioBruto <= 2000) desconto = 0.25;
        else desconto = 0.3;

        double salarioLiquido = salarioBruto - salarioBruto * desconto;

        System.out.println("Seu salário líquido é: R$" + salarioLiquido);

        scan.close();
    }
}
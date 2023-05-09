import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double peso = 0;

        System.out.println("Digite a sua altura");
        double altura = scan.nextDouble();
        System.out.println("Digite o seu sexo\nM - Masculino\nF - Feminino");
        char sexo = scan.next().charAt(0);
        sexo = Character.toUpperCase(sexo); //Transforma o caractere em maiúsculo

        if (sexo == 'M') peso = Math.round( (72.7 * altura) - 58);
        else if (sexo == 'F') peso = Math.round( (62.1 * altura) - 44.7);
        else System.out.println("O que você é, um alienígena???");

        System.out.println("Seu peso ideal é - " + peso + "kg");
        
        scan.close();
    }
}
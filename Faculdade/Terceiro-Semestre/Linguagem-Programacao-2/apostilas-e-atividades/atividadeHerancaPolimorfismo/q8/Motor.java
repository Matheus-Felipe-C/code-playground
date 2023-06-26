import java.util.Scanner;

public class Motor {
    private int numCilindro;
    private int potencia;

    public Motor() {
        this.numCilindro = 0;
        this.potencia = 0;
    }

    public Motor(int numCilindro, int potencia) {
        this.numCilindro = numCilindro;
        this.potencia = potencia;
    }

    public void get() {
        Scanner scan = new Scanner(System.in); // Muito provavelmente eu não deveria tar fazenod isso kkkkk

        System.out.println("Digite o número do Cilindro");
        this.numCilindro = scan.nextInt();
        System.out.println("Digite a potência do motor");
        this.potencia = scan.nextInt();

        scan.close();
    }

    public void print() {
        System.out.println("Número do cilíndro: " + numCilindro);
        System.out.println("Potência: " + potencia);
    }
}

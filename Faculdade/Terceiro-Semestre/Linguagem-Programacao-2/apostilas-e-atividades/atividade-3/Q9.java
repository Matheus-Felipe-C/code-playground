import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o " + (i + 1) + "a valor");
            numeros.add(scan.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(numeros.get(i));
        }

        scan.close();
    }
}

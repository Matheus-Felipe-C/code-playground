import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		String[] nomes = new String[5];
		double[] notas = new double[5];
		double[] medias = new double[5];
		double mediaTurma = 0;
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Digite o seu nome");
			nomes[i] = scan.next();
			
			for (int j = 0; j < 5; j++) {
				System.out.println(nomes[i] + ", Digite a sua "+ (j+1) + "a nota");
				notas[i] = scan.nextDouble();
				medias[i] = notas[i];
			}
			
			medias[i] /= 5;
			mediaTurma += medias[i];
		}
		
		mediaTurma /= 5;
		
		for (int i = 0; i < 5; i++) {
			if (medias[i] > mediaTurma) System.out.println(nomes[i] + " Ficou acima da média");
		}
		
		scan.close();
	}

}

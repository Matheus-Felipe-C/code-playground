import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a quantidade de alunos para receber as notas");
        int i = scan.nextInt();

        System.out.println("Digite a quantidade de notas a serem lidas");
        int j = scan.nextInt();

        double[] notas = new double[j];
        double[] medias = new double[i];
        double mediaTurma = 0;

        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                System.out.println((a + 1) + "a aluno, Digite a sua " + (b + 1) + "a nota");
                notas[b] = scan.nextDouble();
                medias[a] += notas[b];
            }

            medias[a] /= i;
            mediaTurma += medias[a];
        }

        mediaTurma /= i;

        System.out.println("Media da turma: " + mediaTurma);

        for (int a = 0; a < i; a++) {
            if (medias[a] > mediaTurma)
                System.out.println("Aluno " + (a + 1) + " ficou acima da média");
        }

        for (int a = 0; a < i; a++) {
            if (medias[a] < mediaTurma)
                System.out.println("Aluno " + (a + 1) + " ficou abaixo da média");
        }

        scan.close();
    }

}

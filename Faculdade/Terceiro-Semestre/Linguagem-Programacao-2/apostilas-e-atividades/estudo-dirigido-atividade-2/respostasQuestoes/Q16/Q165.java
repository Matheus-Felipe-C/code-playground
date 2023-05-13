import java.util.Scanner;

public class Q165 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[][] notas = new double[10][5];
        double[] mediaAluno = new double[10];
        double percMediaIgualOuMaiorQue5 = 0;
        double mediaTurma = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("Digite a nota " + (j+1) + " do Aluno " + (i+1) );
                notas[i][j] = scan.nextDouble();
                mediaAluno[i] += notas[i][j];
            }

            mediaAluno[i] /= 5;
            mediaTurma += mediaAluno[i];
            System.out.println("Média do aluno " + (i + 1) + ": " + mediaAluno[i]);

            if (mediaAluno[i] >= 5) percMediaIgualOuMaiorQue5 += 1;
        }
        mediaTurma /= 3;
        percMediaIgualOuMaiorQue5 /= 3;

        System.out.println("Média da turma: " + mediaTurma);
        System.out.println("Porcentagem de alunos na média: " + (percMediaIgualOuMaiorQue5 * 100) + "%");
            
        scan.close();
    }
}
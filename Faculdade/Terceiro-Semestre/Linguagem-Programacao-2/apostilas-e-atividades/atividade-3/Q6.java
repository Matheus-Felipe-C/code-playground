public class Q6 {
    public static void main(String[] args) throws Exception {
        int[][] valores = new int[20][10];
        int[] soma = new int[20];
        int[][] resultado = new int[20][10];
        int count = 0;

        //loops que preenchem a matriz valores e o vetor soma
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                valores[i][j] += count + 1;
                soma[i] += valores[i][j];
                count++;
            }
        }

        //loops que preenchem o vetor soma
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                resultado[i][j] = valores[i][j] * soma[i];
            }
        }

        //Loops que mostram a matriz
        //PS - a matriz tá mal formatada pq os números são muito grandes
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(resultado[i][j] + "   ");
            }
            System.out.println("\n");
        }
    }
}

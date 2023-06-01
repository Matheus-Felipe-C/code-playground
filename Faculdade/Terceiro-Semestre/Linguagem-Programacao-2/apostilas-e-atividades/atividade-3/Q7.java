import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o número de linhas da sua matriz");
        int linhas = scan.nextInt();

        System.out.println("Digite o número de colunas da sua matriz");
        int colunas = scan.nextInt();
        
        int[][] matriz = new int[linhas][colunas];
        int count = 0;

        //loops que preenchem a matriz
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                count++;
                matriz[i][j] = count;
            }
        }

        int[][] novaMatriz = substituiNumeros(matriz, linhas, colunas);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(novaMatriz[i][j] + "  ");
            }
        }

        scan.close();
    }
    
    public static int[][] substituiNumeros(int[][] matriz, int linhas, int colunas) {
        int[][] novaMatriz = new int[linhas][colunas];
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] % 2 == 0) novaMatriz[i][j] = -1;
                else novaMatriz[i][j] = 1;
            }
        }
        return novaMatriz;
    }
}

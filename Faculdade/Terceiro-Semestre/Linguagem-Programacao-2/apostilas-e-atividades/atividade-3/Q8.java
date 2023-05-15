import java.util.Random;

public class Q8 {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int[][] matriz = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 matriz[i][j] = rand.nextInt(100);
                 System.out.print(matriz[i][j] + "   ");
            }
            System.out.println("");
        }
    }
}

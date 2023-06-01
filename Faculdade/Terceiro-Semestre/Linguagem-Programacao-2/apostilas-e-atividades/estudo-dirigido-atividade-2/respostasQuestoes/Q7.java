import java.util.Scanner;

public class Q7 {
    
    //Por mais preguiça, vou manter esse negócio como estático pra reusar nos métodos
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /**
         * Por não ter sido instruído a como fazer laços de repetição (que já possuo conhecimento sobre),
         * evitarei utilizar eles, execute o programa duas vezes para ver o resultado das questões 7.1 e 7.2
         */

         System.out.println("Selecione a questão a ser analisada:\n1 - 7.1\n2 - 7.2\n\nSua resposta: ");
         int input = scan.nextInt();

         //Vou usar um operador ternário por pura preguiça
         if (input == 1) calculaDesconto();
         else if (input == 2) calculaLitros();
         else System.out.println("Opção inválida, tente outra opção!");
    }

    public static void calculaDesconto() {
        System.out.println("Questão selecionada - 7.1\n");
        System.out.println("Digite o valor do produto (em reais)\n");
        float valor = scan.nextFloat();
        valor -= valor * 0.09;

        System.out.println("Valor com desconto - R$" + valor);
    }

    public static void calculaLitros() {
        System.out.println("Questão selecionada - 7.2\n");
        System.out.println("Digite o tempo gasto na viagem (em horas)\n");
        float tempo = scan.nextFloat();
        System.out.println("DIgite a velocidade média do veículo (em km/h)\n");
        float velocidade = scan.nextFloat(); 

        float distancia = tempo * velocidade;
        float litros = distancia/12;

        System.out.println("Distância percorrida - " + distancia + "Kilômetros");
        System.out.println("Litros de gasolina gastos - " + litros);
    }
}
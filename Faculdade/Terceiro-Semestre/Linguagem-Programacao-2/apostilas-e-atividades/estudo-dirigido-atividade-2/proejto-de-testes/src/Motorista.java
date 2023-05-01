import java.util.Scanner;

public class Motorista {
    String nome;
    int idade;
    int idCarteira;
    Carro carro;

    public Motorista(String nome, int idade, int idCarteira) {
        this.nome = nome;
        this.idade = idade;
        this.idCarteira = idCarteira;
    }

    public void dirigir() {
        this.carro.ligar();
        this.carro.acelerar(20);
    }

    public void comprar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Diga a marca do carro");
        String marca = scan.nextLine();
        System.out.println("Diga a cor do carro");
        String cor = scan.nextLine();
        System.out.println("Diga a placa do carro");
        String placa = scan.nextLine();
        System.out.println("Diga a capacidade do tanque de gasolina");
        int capacidadeTanque = scan.nextInt();
        System.out.println("Diga o ano do carro");
        int ano = scan.nextInt();

        Carro carro = new Carro(marca, cor, placa, capacidadeTanque, ano);
        this.carro = carro;
        scan.close();
    }

    public void vender() {
        this.carro = null;
        System.out.println("Vendido!");
    }

    public void abastecer(float litros) {
        System.out.println("Abastecendo tanque...");

        while (litros > 0) {
            if (litros < 5) litros = 0;
            else litros -= 5;

            System.out.println("Litros restantes para abastecer: " + litros);
        }
    }

    public void frear(int velocidade) {
        carro.frear(velocidade);
    }
}

public class Carro {
    String marca;
    String cor;
    final String placa;
    float capacidadeTanque;
    int velocidade;
    final int ano;
    
    public Carro(String marca, String cor, String placa, float capacidadeTanque, int ano) {
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
        this.capacidadeTanque = capacidadeTanque;
        this.ano = ano;
    }

    public void ligar() {
        System.out.println("Carro ligado!");
    }

    public void desligar() {
        parar();

        System.out.println("Carro desligado!");
    }

    public void parar() {
        frear(0);
    }

    public void acelerar(int velocidade) {
        System.out.println("Acelerando " + this.marca + "...");

        while(this.velocidade < velocidade) {
            if (velocidade - this.velocidade < 5) this.velocidade += this.velocidade - velocidade;
            else this.velocidade += 5;    

            System.out.println("Velocidade atual: " + this.velocidade + "km/h");
        }
    }    

    public void frear(int velocidade) {
        System.out.println("Freando " + this.marca + "...");

        while(this.velocidade > velocidade) {
            if (this.velocidade - velocidade < 5) this.velocidade -= this.velocidade - velocidade;
            else this.velocidade -= 5;    

            System.out.println("Velocidade atual: " + this.velocidade + "km/h");
        }
    }
}

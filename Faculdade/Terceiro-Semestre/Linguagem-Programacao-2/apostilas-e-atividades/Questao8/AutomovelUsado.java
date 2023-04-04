package Questao8;

public class AutomovelUsado {
    private final int ano;
    private final String modelo;
    private double kilometragem;
    private float combustivel;
    private float preco;

    public AutomovelUsado(int ano, String modelo, double kilometragem, float combustivel, float preco) {
        this.ano = ano;
        this.modelo = modelo;
        this.kilometragem = kilometragem;
        this.combustivel = combustivel;
        this.preco = preco;
    }

    public void setKilometragem(double kilometragem) {
        this.kilometragem = kilometragem;
    }

    public void setCombustivel(float combustivel) {
        this.combustivel = combustivel;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void mostraInformações() {
        System.out.println("Ano - " + ano);
        System.out.println("Modelo - " + modelo);
        System.out.println("Kilometragem - " + kilometragem + " Km");
        System.out.println("Combustível atual - " + combustivel + "l");
        System.out.println("Preço - R$" + preco);
    }
}

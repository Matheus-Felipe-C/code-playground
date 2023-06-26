public class Automovel extends Veiculo {

    public float acelerar(float velocidade) {
        this.velocidade += velocidade;
        return this.velocidade;
    }

    public void parar() {
        this.velocidade = 0;
        System.out.println("Automóvel parado");
    }
    
}

public class Bicicleta  extends Veiculo {

    public float acelerar(float velocidade) {
        this.velocidade = velocidade;
        return this.velocidade;
    }

    public void parar() {
        System.out.println("Bicicleta parada"); 
    }
        
}

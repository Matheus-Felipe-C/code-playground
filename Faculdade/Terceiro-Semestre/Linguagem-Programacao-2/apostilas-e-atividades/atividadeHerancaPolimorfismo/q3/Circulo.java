public class Circulo extends Figura {

    public Circulo(double diametro) {
        super(diametro, 0);
    }
    
    public double area() {
        return 3.14 * (this.getb() * this.getb() );
    }
}

public class Triangulo extends Figura {

    public Triangulo(double base, double altura) {
        super(base, altura);
    }
    
    public double area() {
        return (this.geta() * this.getb() );
    }
}

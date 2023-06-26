public class Figura {
    private double b;
    private double a;
    
    public Figura(double b, double a) {
        this.b = b;
        this.a = a;
    }
    
    public double area() {
        return b * a;
    }

    public void mostrar() {
        System.out.println("Área calculada: " + this.area() );
    }

    // Getters e Setters

    public double getb() {
        return b;
    }

    public void setb(double b) {
        this.b = b;
    }

    public double geta() {
        return a;
    }

    public void seta(double a) {
        this.a = a;
    }

}

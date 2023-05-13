public class Detran {
    public static void main(String[] args) {
        var monstrorista = new Motorista("Garimpos", 900, 420456);
        monstrorista.comprar();
        monstrorista.dirigir();
        monstrorista.frear(0);
        monstrorista.abastecer(5);
        monstrorista.dirigir();
        monstrorista.frear(0);
        monstrorista.vender();
    }
}
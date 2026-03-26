class Circulo {
    double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

public class Main {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(5);
        Circulo c2 = new Circulo(3);

        System.out.println(c1.calcularArea());
        System.out.println(c2.calcularArea());
    }
}

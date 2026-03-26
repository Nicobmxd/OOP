class Punto {
    int x;
    int y;


    public Punto() {
        this.x = 0;
        this.y = 0;
    }


    public Punto(int x) {
        this.x = x;
        this.y = 0;
    }


    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5);
        Punto p3 = new Punto(3, 4);

        System.out.println(p1.x + ", " + p1.y);
        System.out.println(p2.x + ", " + p2.y);
        System.out.println(p3.x + ", " + p3.y);
    }
}

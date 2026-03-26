class Numeros {
    private int[] lista;

    public Numeros(int[] lista) {
        this.lista = lista;
    }

    public int valorMaximo() {
        int max = lista[0];
        for (int n : lista) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public int contarPares() {
        int contador = 0;
        for (int n : lista) {
            if (n % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }
}

public class Main {
    public static void main(String[] args) {
        Numeros n1 = new Numeros(new int[]{1, 2, 3, 4, 5, 6});
        Numeros n2 = new Numeros(new int[]{7, 9, 11, 13});
        Numeros n3 = new Numeros(new int[]{10, 20, 30, 40});

        System.out.println(n1.valorMaximo() + " " + n1.contarPares());
        System.out.println(n2.valorMaximo() + " " + n2.contarPares());
        System.out.println(n3.valorMaximo() + " " + n3.contarPares());
    }
}

class Matriz {
    private int[][] matriz;

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void sumaFilas() {
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            System.out.println(suma);
        }
    }

    public void diagonalPrincipal() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i][i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] datos = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Matriz m = new Matriz(datos);

        m.sumaFilas();
        m.diagonalPrincipal();
    }
}

package arrays1;

import java.util.Scanner;

public class Arrays1 {
    public int[] data;
    public int n;

    public Arrays1(int n) {
        this.n = n;
        this.data = new int[n];   // Crear el arreglo
    }

    public void print(String name) {
        System.out.print(name + " = [ ");
        for (int i = 0; i < n; i++) {
            System.out.print(data[i]);
            if (i < n - 1) {
                System.out.print(" , ");
            }
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamano n: ");
        int n = sc.nextInt();

        Arrays1 v = new Arrays1(n);

        for (int i = 0; i < n; i++) {   // Aquí faltaba n
            System.out.print("v[" + i + "]: ");
            v.data[i] = sc.nextInt();
        }

        v.print("v");

        sc.close();
    }
}
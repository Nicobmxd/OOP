class Estudiante {
    private String nombre;
    private double nota;

    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        setNota(nota);
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(double nota) {
        if (nota >= 0) {
            this.nota = nota;
        } else {
            System.out.println("Nota inválida");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Estudiante e = new Estudiante("Juan", 4.5);
        System.out.println(e.getNombre() + " " + e.getNota());

        e.setNota(-2);
        e.setNota(3.8);
        System.out.println(e.getNota());
    }
}

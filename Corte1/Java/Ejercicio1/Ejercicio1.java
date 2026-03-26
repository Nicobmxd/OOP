class Libro {
    String titulo;
    String autor;


    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }


    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        Libro libro2 = new Libro("1984", "George Orwell");


        libro1.mostrarInfo();
        libro2.mostrarInfo();
    }
}

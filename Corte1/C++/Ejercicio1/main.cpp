#include <iostream>
using namespace std;

class Libro {
private:
    string titulo;
    string autor;

public:
    Libro(string t, string a) {
        titulo = t;
        autor = a;
    }

    void mostrarInfo() {
        cout << "Título: " << titulo << endl;
        cout << "Autor: " << autor << endl;
        cout << "----------------------" << endl;
    }
};

int main() {
    Libro libro1("Cien años de soledad", "Gabriel García Márquez");
    Libro libro2("1984", "George Orwell");

    libro1.mostrarInfo();
    libro2.mostrarInfo();

    return 0;
}

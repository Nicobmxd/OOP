#include <iostream>
using namespace std;

class Estudiante {
private:
    string nombre;
    double nota;

public:
    Estudiante(string n, double no) {
        nombre = n;
        setNota(no);
    }

    string getNombre() {
        return nombre;
    }

    double getNota() {
        return nota;
    }

    void setNombre(string n) {
        nombre = n;
    }

    void setNota(double no) {
        if (no >= 0) {
            nota = no;
        } else {
            cout << "Nota inválida" << endl;
        }
    }
};

int main() {
    Estudiante e("Juan", 4.5);
    cout << e.getNombre() << " " << e.getNota() << endl;

    e.setNota(-2);
    e.setNota(3.8);
    cout << e.getNota() << endl;

    return 0;
}

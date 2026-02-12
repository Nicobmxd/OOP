#include <iostream>
#include <string>
using namespace std;

//primera clase: entender  "clase" vs "objeto"
class Persona {
public:
    string nombre; // atributo
    int edad; // atributo
    //metodo (funcion dentro de una clase)
    void saludar() {
       cout << "Hola, soy " << nombre << " y tengo " << edad << "años.\n";
    }
};

int main () {
    //Crear in objeto (una "Persona" real)
    Persona p1;
    Persona p2;
    Persona p3;

    //Asignar valores a los atributos
    p1.nombre = "Nicolas";
    p1.edad = 19;
    p2.nombre = "Daniel";
    p2.edad = 21;
    p3.nombre = "Juan Manuel";
    p3.edad = 24;

    //Llamar un metodo del objeto
    p1.saludar();
    p2.saludar();
    p3.saludar();

    return 0;
}

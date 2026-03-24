#include <iostream>
#include <string>
using namespace std;

const int MAX_ESTUDIANTES = 50;
const int NUM_NOTAS = 3;

// Clase Estudiante
class Estudiante {
private:
    int codigo;
    string nombre;
    int edad;

public:
    // Constructores
    Estudiante() {
        codigo = 0;
        nombre = "";
        edad = 0;
    }

    Estudiante(int c, string n, int e) {
        codigo = c;
        nombre = n;
        edad = e;
    }

    // Métodos getters
    int getCodigo() { return codigo; }
    string getNombre() { return nombre; }
    int getEdad() { return edad; }

    // Mostrar datos
    void mostrar() {
        cout << "Codigo: " << codigo << endl;
        cout << "Nombre: " << nombre << endl;
        cout << "Edad: " << edad << endl;
    }
};

// Variables globales
Estudiante estudiantes[MAX_ESTUDIANTES];
float notas[MAX_ESTUDIANTES][NUM_NOTAS];
int totalEstudiantes = 0;

// Buscar estudiante por código
int buscarEstudiante(int codigo) {
    for (int i = 0; i < totalEstudiantes; i++) {
        if (estudiantes[i].getCodigo() == codigo) {
            return i;
        }
    }
    return -1;
}

// Registrar estudiante
void registrarEstudiante() {
    if (totalEstudiantes >= MAX_ESTUDIANTES) {
        cout << "Limite alcanzado.\n";
        return;
    }

    int codigo, edad;
    string nombre;

    cout << "Codigo: ";
    cin >> codigo;

    // Validación
    if (buscarEstudiante(codigo) != -1) {
        cout << "El codigo ya existe.\n";
        return;
    }

    cout << "Nombre: ";
    cin.ignore();
    getline(cin, nombre);

    cout << "Edad: ";
    cin >> edad;

    estudiantes[totalEstudiantes] = Estudiante(codigo, nombre, edad);

    // Inicializar notas en 0
    for (int j = 0; j < NUM_NOTAS; j++) {
        notas[totalEstudiantes][j] = 0;
    }

    totalEstudiantes++;
    cout << "Estudiante registrado.\n";
}

// Mostrar estudiantes
void mostrarEstudiantes() {
    if (totalEstudiantes == 0) {
        cout << "No hay estudiantes.\n";
        return;
    }

    for (int i = 0; i < totalEstudiantes; i++) {
        cout << "\n--- Estudiante " << i + 1 << " ---\n";
        estudiantes[i].mostrar();
    }
}

//  Mostrar notas
void asignarNotas() {
    int codigo;
    cout << "Codigo del estudiante: ";
    cin >> codigo;

    int pos = buscarEstudiante(codigo);

    if (pos == -1) {
        cout << "No encontrado.\n";
        return;
    }

    for (int i = 0; i < NUM_NOTAS; i++) {
        cout << "Nota " << i + 1 << ": ";
        cin >> notas[pos][i];
    }

    cout << "Notas actualizadas.\n";
}

// Mostrar promedio
void mostrarPromedio() {
    int codigo;
    cout << "Codigo del estudiante: ";
    cin >> codigo;

    int pos = buscarEstudiante(codigo);

    if (pos == -1) {
        cout << "No encontrado.\n";
        return;
    }

    float suma = 0;
    for (int i = 0; i < NUM_NOTAS; i++) {
        suma += notas[pos][i];
    }

    cout << "Promedio: " << suma / NUM_NOTAS << endl;
}

// Mostrar matriz
void mostrarMatriz() {
    if (totalEstudiantes == 0) {
        cout << "No hay datos.\n";
        return;
    }

    for (int i = 0; i < totalEstudiantes; i++) {
        cout << estudiantes[i].getNombre() << ": ";
        for (int j = 0; j < NUM_NOTAS; j++) {
            cout << notas[i][j] << " ";
        }
        cout << endl;
    }
}

// Menú principal
int main() {
    int opcion;

    do {
        cout << "\n===== MENU =====\n";
        cout << "1. Registrar estudiante\n";
        cout << "2. Mostrar estudiantes\n";
        cout << "3. Buscar estudiante\n";
        cout << "4. Asignar notas\n";
        cout << "5. Mostrar promedio\n";
        cout << "6. Mostrar matriz de notas\n";
        cout << "7. Salir\n";
        cout << "Opcion: ";
        cin >> opcion;

        if (opcion == 1) {
            registrarEstudiante();
        } else if (opcion == 2) {
            mostrarEstudiantes();
        } else if (opcion == 3) {
            int codigo;
            cout << "Codigo: ";
            cin >> codigo;
            int pos = buscarEstudiante(codigo);
            if (pos != -1) {
                estudiantes[pos].mostrar();
            } else {
                cout << "No encontrado.\n";
            }
        } else if (opcion == 4) {
            asignarNotas();
        } else if (opcion == 5) {
            mostrarPromedio();
        } else if (opcion == 6) {
            mostrarMatriz();
        } else if (opcion == 7) {
            cout << "Saliendo...\n";
        } else {
            cout << "Opcion invalida.\n";
        }

    } while (opcion != 7);

    return 0;
}

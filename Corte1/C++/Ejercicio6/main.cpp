#include <iostream>
#include <vector>
using namespace std;

class Matriz {
private:
    vector<vector<int> > matriz;

public:
    Matriz(vector<vector<int> > m) {
        matriz = m;
    }

    void sumaFilas() {
        for (size_t i = 0; i < matriz.size(); i++) {
            int suma = 0;
            for (size_t j = 0; j < matriz[i].size(); j++) {
                suma += matriz[i][j];
            }
            cout << suma << endl;
        }
    }

    void diagonalPrincipal() {
        for (size_t i = 0; i < matriz.size(); i++) {
            cout << matriz[i][i] << endl;
        }
    }
};

int main() {
    vector<vector<int> > datos;
    datos.push_back({1, 2, 3});
    datos.push_back({4, 5, 6});
    datos.push_back({7, 8, 9});

    Matriz m(datos);

    m.sumaFilas();
    m.diagonalPrincipal();

    return 0;
}

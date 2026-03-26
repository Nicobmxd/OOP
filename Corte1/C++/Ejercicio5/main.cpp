#include <iostream>
#include <vector>
using namespace std;

class Numeros {
private:
    vector<int> lista;

public:
    Numeros(vector<int> l) {
        lista = l;
    }

    int valorMaximo() {
        int max = lista[0];
        for (int n : lista) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    int contarPares() {
        int contador = 0;
        for (int n : lista) {
            if (n % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }
};

int main() {
    Numeros n1({1, 2, 3, 4, 5, 6});
    Numeros n2({7, 9, 11, 13});
    Numeros n3({10, 20, 30, 40});

    cout << n1.valorMaximo() << " " << n1.contarPares() << endl;
    cout << n2.valorMaximo() << " " << n2.contarPares() << endl;
    cout << n3.valorMaximo() << " " << n3.contarPares() << endl;

    return 0;
}
}

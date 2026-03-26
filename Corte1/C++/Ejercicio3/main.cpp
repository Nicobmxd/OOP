#include <iostream>
using namespace std;

class Punto {
private:
    int x, y;

public:
    Punto() {
        x = 0;
        y = 0;
    }

    Punto(int xVal) {
        x = xVal;
        y = 0;
    }

    Punto(int xVal, int yVal) {
        x = xVal;
        y = yVal;
    }

    void mostrar() {
        cout << x << ", " << y << endl;
    }
};

int main() {
    Punto p1;
    Punto p2(5);
    Punto p3(3, 4);

    p1.mostrar();
    p2.mostrar();
    p3.mostrar();

    return 0;
}

#include <iostream>
#include <cmath>
using namespace std;

class Circulo {
private:
    double radio;

public:
    Circulo(double r) {
        radio = r;
    }

    double calcularArea() {
        return M_PI * radio * radio;
    }
};

int main() {
    Circulo c1(5);
    Circulo c2(3);

    cout << c1.calcularArea() << endl;
    cout << c2.calcularArea() << endl;

    return 0;
}

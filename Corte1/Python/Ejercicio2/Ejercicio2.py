import math

class Circulo:
    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        return math.pi * self.radio ** 2


c1 = Circulo(5)
c2 = Circulo(3)

print(c1.calcular_area())
print(c2.calcular_area())

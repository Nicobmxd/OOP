class Numeros:
    def __init__(self, lista):
        self.lista = lista

    def valor_maximo(self):
        return max(self.lista)

    def contar_pares(self):
        return sum(1 for n in self.lista if n % 2 == 0)


n1 = Numeros([1, 2, 3, 4, 5, 6])
n2 = Numeros([7, 9, 11, 13])
n3 = Numeros([10, 20, 30, 40])

print(n1.valor_maximo(), n1.contar_pares())
print(n2.valor_maximo(), n2.contar_pares())
print(n3.valor_maximo(), n3.contar_pares())

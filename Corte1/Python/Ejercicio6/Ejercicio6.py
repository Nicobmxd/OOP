class Matriz:
    def __init__(self, matriz):
        self.matriz = matriz

    def suma_filas(self):
        for fila in self.matriz:
            print(sum(fila))

    def diagonal_principal(self):
        for i in range(len(self.matriz)):
            print(self.matriz[i][i])


m = Matriz([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
])

m.suma_filas()
m.diagonal_principal()

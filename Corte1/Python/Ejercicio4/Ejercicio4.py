class Estudiante:
    def __init__(self, nombre, nota):
        self.__nombre = nombre
        self.__nota = 0
        self.set_nota(nota)

    def get_nombre(self):
        return self.__nombre

    def get_nota(self):
        return self.__nota

    def set_nombre(self, nombre):
        self.__nombre = nombre

    def set_nota(self, nota):
        if nota >= 0:
            self.__nota = nota
        else:
            print("Nota inválida")

e = Estudiante("Juan", 4.5)
print(e.get_nombre(), e.get_nota())

e.set_nota(-2)
e.set_nota(3.8)
print(e.get_nota())

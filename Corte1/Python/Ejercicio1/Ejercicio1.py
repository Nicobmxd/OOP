
class Libro:
    def __init__(self, titulo, autor):
        self.titulo = titulo
        self.autor = autor

   
    def mostrar_info(self):
        print(f"Título: {self.titulo}")
        print(f"Autor: {self.autor}")
        print("-" * 30)



libro1 = Libro("Cien años de soledad", "Gabriel García Márquez")
libro2 = Libro("1984", "George Orwell")


libro1.mostrar_info()
libro2.mostrar_info()

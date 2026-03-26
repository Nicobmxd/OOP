class Punto:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y


p1 = Punto()
p2 = Punto(5)
p3 = Punto(3, 4)

print(p1.x, p1.y)
print(p2.x, p2.y)
print(p3.x, p3.y)

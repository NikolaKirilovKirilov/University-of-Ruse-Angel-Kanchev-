class Rectangle:
    def __init__(self, length, width):
        self.length = length
        self.width = width
    
    def perimeter(self):
        return 2*self.length+2*self.width
    
    def area(self):
        return self.length*self.width
    
    def display(self):
        print(self.length)
        print(self.width)
        print(self.perimeter())
        print(self.area())
    
x = Rectangle(2, 3)
x.display()
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

class Student(Person):
    def __init__(self, name, age, faculty):
        super().__init__(name, age)
        self.faculty = faculty

    def displayStudent(self):
        print(self.name)
        print(self.age)
        print(self.faculty)

s = Student("Pencho", 21, "Natural science and Education")
s.displayStudent()
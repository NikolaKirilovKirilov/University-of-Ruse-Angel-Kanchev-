class BankAccount:
    def __init__(self, accountNumber, name, balance):
        self.accountNumber = accountNumber
        self.name = name
        self.balance = balance
    
    def deposit(self, money):
        self.balance += money

    def withdraw(self, money):
        self.balance -= money

    def bankFees(self):
        self.balance *= 0.95

    def display(self):
        print(self.accountNumber)
        print(self.name)
        print(self.balance)
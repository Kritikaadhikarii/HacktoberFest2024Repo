import json
from datetime import datetime

class ExpenseManager:
    def __init__(self):
        self.expense_list = []
        self.load_expenses()

    def load_expenses(self):
        """Load expenses from a JSON file."""
        try:
            with open('expenses.json', 'r') as file:
                self.expense_list = json.load(file)
        except FileNotFoundError:
            self.expense_list = []

    def save_expenses(self):
        """Save the current expenses to a JSON file."""
        with open('expenses.json', 'w') as file:
            json.dump(self.expense_list, file)

    def add_expense(self, amount, category):
        """Add a new expense to the tracker."""
        expense = {
            'amount': amount,
            'category': category,
            'date': str(datetime.now())
        }
        self.expense_list.append(expense)
        self.save_expenses()

    def display_expenses(self):
        """Display all recorded expenses."""
        for expense in self.expense_list:
            print(f"Amount: {expense['amount']}, Category: {expense['category']}, Date: {expense['date']}")

if __name__ == "__main__":
    manager = ExpenseManager()
    manager.add_expense(50, 'Food')
    manager.display_expenses()
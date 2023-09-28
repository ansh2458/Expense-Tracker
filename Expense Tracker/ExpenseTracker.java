import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String name;
    double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add an Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense name: ");
        String name = scanner.next();

        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();

        expenses.add(new Expense(name, amount));
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("Expense List:");
        System.out.println("Name\tAmount");
        for (Expense expense : expenses) {
            System.out.println(expense.name + "\t$" + expense.amount);
        }
        double total = expenses.stream().mapToDouble(expense -> expense.amount).sum();
        System.out.println("Total Expenses: $" + total);
    }
}

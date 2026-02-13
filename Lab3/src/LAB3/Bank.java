package LAB3;

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // No‑argument constructor
    public BankAccount() {
        accountNumber = "default";
        accountHolder = "Physic";
        balance = 0.0;
    }

    // Parameterized constructor
    public BankAccount(String a, String b, double c) {
        accountNumber = a;
        accountHolder = b;
        balance = c;
    }

    // Deposit method
    public void deposit(double a) {
        if (a > 0) {
            balance += a;   // FIXED
            System.out.println("Deposited: " + a);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method
    public void withdraw(double a) {
        if (a <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (a > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= a;
            System.out.println("Withdrawn: " + a);
        }
    }

    // Display details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
        System.out.println("------------------------");
    }
}

public class Bank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Default account
        BankAccount acc1 = new BankAccount();
        System.out.println("Default Account:");
        acc1.displayAccountDetails();

        // 2. User-created account
        System.out.print("\nEnter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holder = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        BankAccount acc2 = new BankAccount(accNo, holder, bal);
        System.out.println("\nUser Created Account:");
        acc2.displayAccountDetails();

        // 3. Menu-driven operations
        int choice;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    acc2.deposit(d);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    acc2.withdraw(w);
                    break;

                case 3:
                    acc2.displayAccountDetails();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}

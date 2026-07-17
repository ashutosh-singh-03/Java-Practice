package model;

import java.util.Scanner;

public class ATM {
    private Scanner sc;
    private Account account;

    public ATM(Account account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\t\tWELCOME");
        System.out.println("\t===================");

        if (login()) {
            System.out.println("Welcome, " + account.getHolderName() + "!");
            showMenu();
        }
    }

    public boolean login() {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter your 4-digit pin: ");
            int enteredPin = sc.nextInt();
            if (account.verifyPin(enteredPin)) {
                System.out.println("Login Successful.\n");
                return true;
            }

            attempts--;

            if (attempts > 0)
                System.out.println("Attempts Left: " + attempts);
            else
                System.out.println("Too many failed attempts. Card Blocked.");
        }
        return false;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            exit = performOperation(choice);
        }
    }

    public void logout() {
    }

    private boolean performOperation(int choice) {
        switch (choice) {
            case 1 -> System.out.println("Current Balance: " + account.checkBalance());
            case 2 -> {
                System.out.print("Enter Withdrawal Amount: ");
                double amount = sc.nextDouble();
                if (account.withdraw(amount))
                    System.out.println("Withdrawal Successful.");
                else
                    System.out.println("Invalid amount or Insufficient Balance");
            }
            case 3 -> {
                System.out.print("Enter Deposit Amount: ");
                double amount = sc.nextDouble();
                if (account.deposit(amount))
                    System.out.println("Deposit Successful");
                else
                    System.out.println("Invalid Amount");
            }
            case 4 -> account.printMiniStatement();
            case 5 -> {
                System.out.print("Enter Old Pin: ");
                int oldPin = sc.nextInt();
                System.out.print("Enter New Pin: ");
                int newPin = sc.nextInt();

                if (account.changePin(oldPin, newPin))
                    System.out.println("Pin changed successfully.");
                else
                    System.out.println("PIN change failed. Check your old PIN or enter a valid 4-digit new PIN.");
            }
            case 6 -> {
                exit();
                return true;
            }
            default -> System.out.println("Enter a valid choice.");
        }
        return false;
    }

    private void exit() {
        System.out.println("\nThank you for using our ATM.");
        System.out.println("Have a nice day!");
    }
}
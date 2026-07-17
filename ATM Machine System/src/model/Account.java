package model;

import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private int pin;
    private final ArrayList<Transaction> transactions;

    // Constructor
    public Account(String accountNumber, String holderName, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holderName = holderName;
        this.pin = pin;
        this.transactions = new ArrayList<>();
    }

    // Getters - Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }


    // Methods
    private void addTransaction(String transactionType, double amount) {
        Transaction transaction = new Transaction(transactionType, amount, balance);
        transactions.add(transaction);
    }

    public boolean deposit(double amount) {
        if (amount <= 0)
            return false;
        balance += amount;
        addTransaction("Deposit", amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            return false;
        balance -= amount;
        addTransaction("Withdraw", amount);
        return true;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean changePin(int oldPin, int newPin) {
        if (oldPin != pin)
            return false;

        String newPinString = String.valueOf(newPin);
        if (newPinString.length() != 4)
            return false;
        pin = newPin;
        return true;
    }

    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    public void printMiniStatement() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;

        }
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
            System.out.println("------------------");
        }

    }
}

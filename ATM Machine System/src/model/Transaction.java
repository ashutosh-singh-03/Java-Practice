package model;

public class Transaction {
    private String transactionType;
    private double amount;
    private double balanceAfterTransaction;

    public Transaction(String transactionType, double amount, double balanceAfterTransaction) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return transactionType + ": " + amount + "\nBalance: " + balanceAfterTransaction;
    }
}

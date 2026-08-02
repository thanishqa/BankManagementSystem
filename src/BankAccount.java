import java.util.ArrayList;

public class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private int pin;
    private double balance;

    private ArrayList<String> transactionHistory;

    public BankAccount(int accountNumber, String accountHolderName, int pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = 0.0;

        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created successfully.");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;

        transactionHistory.add(
                "Deposited: ₹" + amount
        );

        System.out.println("Amount deposited successfully.");
        System.out.println("Current Balance: ₹" + balance);
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;

        transactionHistory.add(
                "Withdrawn: ₹" + amount
        );

        System.out.println("Amount withdrawn successfully.");
        System.out.println("Current Balance: ₹" + balance);

        return true;
    }

    public boolean transfer(BankAccount receiver, double amount) {

        if (receiver == null) {
            System.out.println("Receiver account not found.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;
        receiver.balance += amount;

        transactionHistory.add(
                "Transferred ₹" + amount +
                " to Account " + receiver.accountNumber
        );

        receiver.transactionHistory.add(
                "Received ₹" + amount +
                " from Account " + accountNumber
        );

        System.out.println("Money transferred successfully.");
        System.out.println("Current Balance: ₹" + balance);

        return true;
    }

    public void changePin(int oldPin, int newPin) {

        if (pin != oldPin) {
            System.out.println("Incorrect current PIN.");
            return;
        }

        if (newPin < 1000 || newPin > 9999) {
            System.out.println("PIN must contain exactly 4 digits.");
            return;
        }

        pin = newPin;

        transactionHistory.add("PIN changed successfully.");

        System.out.println("PIN changed successfully.");
    }

    public void displayAccountDetails() {

        System.out.println("\n---------- Account Details ----------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("-------------------------------------");
    }

    public void displayTransactionHistory() {

        System.out.println("\n---------- Transaction History ----------");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {

            for (String transaction : transactionHistory) {
                System.out.println("- " + transaction);
            }
        }

        System.out.println("------------------------------------------");
    }
}
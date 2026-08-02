import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private int pin;

    protected double balance;

    private ArrayList<String> transactionHistory;

    public BankAccount(
            int accountNumber,
            String accountHolderName,
            int pin) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = 0.0;

        transactionHistory = new ArrayList<>();

        addTransaction("Account created successfully.");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }
    public void addLoadedTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    protected void addTransaction(String message) {

        LocalDateTime now =
                LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss");

        String dateTime =
                now.format(formatter);

        transactionHistory.add(
                "[" + dateTime + "] " + message);
    }

    public void deposit(double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Invalid deposit amount.");

            return;
        }

        balance += amount;

        addTransaction(
                "Deposited: ₹" + amount);

        System.out.println(
                "Amount deposited successfully.");

        System.out.println(
                "Current Balance: ₹" + balance);
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {

            System.out.println(
                    "Invalid withdrawal amount.");

            return;
        }

        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient balance. " +
                    "Available balance: ₹" +
                    balance);
        }

        balance -= amount;

        addTransaction(
                "Withdrawn: ₹" + amount);

        System.out.println(
                "Amount withdrawn successfully.");

        System.out.println(
                "Current Balance: ₹" + balance);
    }

    public void transfer(
            BankAccount receiver,
            double amount)
            throws InsufficientBalanceException {

        if (receiver == null) {

            System.out.println(
                    "Receiver account not found.");

            return;
        }

        if (receiver == this) {

            System.out.println(
                    "You cannot transfer money " +
                    "to your own account.");

            return;
        }

        if (amount <= 0) {

            System.out.println(
                    "Invalid transfer amount.");

            return;
        }

        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient balance. " +
                    "Available balance: ₹" +
                    balance);
        }

        balance -= amount;

        receiver.balance += amount;

        addTransaction(
                "Transferred ₹" + amount +
                " to Account " +
                receiver.accountNumber);

        receiver.addTransaction(
                "Received ₹" + amount +
                " from Account " +
                accountNumber);

        System.out.println(
                "Money transferred successfully.");

        System.out.println(
                "Current Balance: ₹" + balance);
    }

    public void changePin(
            int oldPin,
            int newPin) {

        if (pin != oldPin) {

            System.out.println(
                    "Incorrect current PIN.");

            return;
        }

        if (newPin < 1000 ||
                newPin > 9999) {

            System.out.println(
                    "PIN must contain exactly 4 digits.");

            return;
        }

        pin = newPin;

        addTransaction(
                "PIN changed successfully.");

        System.out.println(
                "PIN changed successfully.");
    }

    public abstract String getAccountType();

    public abstract double calculateInterest();

    public void displayAccountDetails() {

        System.out.println(
                "\n---------- Account Details ----------");

        System.out.println(
                "Account Number : " +
                accountNumber);

        System.out.println(
                "Account Holder : " +
                accountHolderName);

        System.out.println(
                "Account Type   : " +
                getAccountType());

        System.out.println(
                "Balance        : ₹" +
                balance);

        System.out.println(
                "Interest       : ₹" +
                calculateInterest());

        System.out.println(
                "-------------------------------------");
    }

    public void displayTransactionHistory() {

        System.out.println(
                "\n---------- Transaction History ----------");

        if (transactionHistory.isEmpty()) {

            System.out.println(
                    "No transactions found.");

        } else {

            for (String transaction :
                    transactionHistory) {

                System.out.println(
                        "- " + transaction);
            }
        }

        System.out.println(
                "------------------------------------------");
    }
}
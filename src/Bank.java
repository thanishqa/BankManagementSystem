import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(int accountNumber, String accountHolderName) {

        BankAccount account =
                new BankAccount(accountNumber, accountHolderName);

        accounts.add(account);

        System.out.println("\nAccount created successfully!");
        System.out.println("Account Number: " + accountNumber);
    }

    public BankAccount findAccount(int accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts) {
            account.displayAccountDetails();
        }
    }
}
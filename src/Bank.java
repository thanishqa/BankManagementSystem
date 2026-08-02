import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private ArrayList<BankAccount> accountList;

    private HashMap<Integer, BankAccount> accountMap;

    public Bank() {

        accountList = new ArrayList<>();

        accountMap = new HashMap<>();
    }

    public boolean createAccount(
            int accountNumber,
            String accountHolderName,
            int pin,
            int accountType) {

        if (accountMap.containsKey(accountNumber)) {

            System.out.println(
                    "Account number already exists.");

            return false;
        }

        if (pin < 1000 || pin > 9999) {

            System.out.println(
                    "PIN must contain exactly 4 digits.");

            return false;
        }

        BankAccount account;

        if (accountType == 1) {

            account = new SavingsAccount(
                    accountNumber,
                    accountHolderName,
                    pin);

        } else {

            account = new CurrentAccount(
                    accountNumber,
                    accountHolderName,
                    pin);
        }

        accountList.add(account);

        accountMap.put(
                accountNumber,
                account);

        System.out.println(
                "\nAccount created successfully!");

        System.out.println(
                "Account Number: " +
                accountNumber);

        System.out.println(
                "Account Type: " +
                account.getAccountType());

        return true;
    }

    public BankAccount findAccount(
            int accountNumber) {

        return accountMap.get(accountNumber);
    }

    public BankAccount login(
            int accountNumber,
            int pin) {

        BankAccount account =
                accountMap.get(accountNumber);

        if (account == null) {

            System.out.println(
                    "Account not found.");

            return null;
        }

        if (!account.verifyPin(pin)) {

            System.out.println(
                    "Incorrect PIN.");

            return null;
        }

        System.out.println(
                "\nLogin successful!");

        System.out.println(
                "Welcome, " +
                account.getAccountHolderName() +
                "!");

        return account;
    }

    public void displayAllAccounts() {

        System.out.println(
                "\n---------- All Accounts ----------");

        if (accountList.isEmpty()) {

            System.out.println(
                    "No accounts available.");

        } else {

            for (BankAccount account :
                    accountList) {

                System.out.println(
                        "Account Number : " +
                        account.getAccountNumber());

                System.out.println(
                        "Account Holder : " +
                        account.getAccountHolderName());

                System.out.println(
                        "Account Type   : " +
                        account.getAccountType());

                System.out.println(
                        "Balance        : ₹" +
                        account.getBalance());

                System.out.println(
                        "Interest       : ₹" +
                        account.calculateInterest());

                System.out.println(
                        "---------------------------------");
            }
        }
    }
}
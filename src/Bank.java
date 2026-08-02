import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private ArrayList<BankAccount> accountList;

    private HashMap<Integer, BankAccount> accountMap;

    public Bank() {

        accountList = new ArrayList<>();

        accountMap = new HashMap<>();

        loadBankData();
    }

    private void loadBankData() {

        accountList =
                BankDataManager.loadAccounts();

        for (BankAccount account :
                accountList) {

            accountMap.put(
                    account.getAccountNumber(),
                    account);
        }

        if (!accountList.isEmpty()) {

            System.out.println(
                    accountList.size() +
                    " account(s) loaded.");
        }
    }

    public boolean createAccount(
            int accountNumber,
            String accountHolderName,
            int pin,
            int accountType) {

        if (accountMap.containsKey(
                accountNumber)) {

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

        } else if (accountType == 2) {

            account = new CurrentAccount(
                    accountNumber,
                    accountHolderName,
                    pin);

        } else {

            System.out.println(
                    "Invalid account type.");

            return false;
        }

        accountList.add(account);

        accountMap.put(
                accountNumber,
                account);

        BankDataManager.saveAccounts(
                accountList);

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

        return accountMap.get(
                accountNumber);
    }

    public BankAccount login(
            int accountNumber,
            int pin) {

        BankAccount account =
                accountMap.get(
                        accountNumber);

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

    public void saveData() {

        BankDataManager.saveAccounts(
                accountList);
    }

    public ArrayList<BankAccount> getAccountList() {

        return accountList;
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
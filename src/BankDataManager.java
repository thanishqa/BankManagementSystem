import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BankDataManager {

    private static final String FILE_NAME =
            "../data/bank_data.txt";

    public static void saveAccounts(
            ArrayList<BankAccount> accounts) {

        try {

            File dataFolder = new File("../data");

            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            FileWriter writer =
                    new FileWriter(FILE_NAME);

            for (BankAccount account : accounts) {

                writer.write(
                        "ACCOUNT|" +
                        account.getAccountNumber() +
                        "|" +
                        account.getAccountHolderName() +
                        "|" +
                        account.getAccountType() +
                        "|" +
                        account.getPin() +
                        "|" +
                        account.getBalance() +
                        "\n");

                for (String transaction :
                        account.getTransactionHistory()) {

                    writer.write(
                            "TRANSACTION|" +
                            account.getAccountNumber() +
                            "|" +
                            transaction +
                            "\n");
                }
            }

            writer.close();

            System.out.println(
                    "Bank data saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving bank data: " +
                    e.getMessage());
        }
    }

    public static ArrayList<BankAccount> loadAccounts() {

        ArrayList<BankAccount> accounts =
                new ArrayList<>();

        HashMap<Integer, BankAccount> accountMap =
                new HashMap<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return accounts;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split("\\|", 3);

                if (data[0].equals("ACCOUNT")) {

                    String[] accountData =
                            line.split("\\|");

                    int accountNumber =
                            Integer.parseInt(
                                    accountData[1]);

                    String accountHolderName =
                            accountData[2];

                    String accountType =
                            accountData[3];

                    int pin =
                            Integer.parseInt(
                                    accountData[4]);

                    double balance =
                            Double.parseDouble(
                                    accountData[5]);

                    BankAccount account;

                    if (accountType.equals(
                            "Savings Account")) {

                        account =
                                new SavingsAccount(
                                        accountNumber,
                                        accountHolderName,
                                        pin);

                    } else {

                        account =
                                new CurrentAccount(
                                        accountNumber,
                                        accountHolderName,
                                        pin);
                    }

                    account.setBalance(balance);

                    accounts.add(account);

                    accountMap.put(
                            accountNumber,
                            account);
                }

               else if (data[0].equals("TRANSACTION")) {

    int accountNumber =
            Integer.parseInt(data[1]);

    String transaction =
            data[2];

    BankAccount account =
            accountMap.get(accountNumber);

    if (account != null &&
            !transaction.contains(
                    "Account created successfully.")) {

        account.addLoadedTransaction(
                transaction);
    }
}
            }

            reader.close();

            System.out.println(
                    "Bank data loaded successfully.");

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading bank data: " +
                    e.getMessage());
        }

        return accounts;
    }
}
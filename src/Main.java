import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        boolean running = true;

        while (running) {

            System.out.println(
                    "\n=================================");

            System.out.println(
                    "       WELCOME TO MY BANK");

            System.out.println(
                    "=================================");

            System.out.println(
                    "1. Create Account");

            System.out.println(
                    "2. Login");

            System.out.println(
                    "3. Display All Accounts");

            System.out.println(
                    "4. Exit");

            System.out.println(
                    "=================================");

            System.out.print(
                    "Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter Account Number: ");

                    int accountNumber =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Account Holder Name: ");

                    String name =
                            scanner.nextLine();

                    System.out.println(
                            "\nSelect Account Type:");

                    System.out.println(
                            "1. Savings Account");

                    System.out.println(
                            "2. Current Account");

                    System.out.print(
                            "Enter choice: ");

                    int accountType =
                            scanner.nextInt();

                    System.out.print(
                            "Create a 4-digit PIN: ");

                    int pin =
                            scanner.nextInt();

                    bank.createAccount(
                            accountNumber,
                            name,
                            pin,
                            accountType);

                    break;

                case 2:

                    System.out.print(
                            "Enter Account Number: ");

                    int loginAccountNumber =
                            scanner.nextInt();

                    System.out.print(
                            "Enter PIN: ");

                    int loginPin =
                            scanner.nextInt();

                    BankAccount loggedInAccount =
                            bank.login(
                                    loginAccountNumber,
                                    loginPin);

                    if (loggedInAccount != null) {

                        boolean loggedIn = true;

                        while (loggedIn) {

                            System.out.println(
                                    "\n=================================");

                            System.out.println(
                                    "          BANK MENU");

                            System.out.println(
                                    "=================================");

                            System.out.println(
                                    "1. Deposit Money");

                            System.out.println(
                                    "2. Withdraw Money");

                            System.out.println(
                                    "3. Check Balance");

                            System.out.println(
                                    "4. Transfer Money");

                            System.out.println(
                                    "5. Transaction History");

                            System.out.println(
                                    "6. Account Details");

                            System.out.println(
                                    "7. Change PIN");

                            System.out.println(
                                    "8. Logout");

                            System.out.println(
                                    "=================================");

                            System.out.print(
                                    "Enter your choice: ");

                            int bankChoice =
                                    scanner.nextInt();

                            switch (bankChoice) {

                                case 1:

                                    System.out.print(
                                            "Enter Deposit Amount: ");

                                    double depositAmount =
                                            scanner.nextDouble();

                                    loggedInAccount.deposit(
                                            depositAmount);

                                    bank.saveData();

                                    break;

                                case 2:

                                    System.out.print(
                                            "Enter Withdrawal Amount: ");

                                    double withdrawalAmount =
                                            scanner.nextDouble();

                                    try {

                                        loggedInAccount.withdraw(
                                                withdrawalAmount);

                                        bank.saveData();

                                    } catch (
                                            InsufficientBalanceException e) {

                                        System.out.println(
                                                "Transaction failed: " +
                                                e.getMessage());
                                    }

                                    break;

                                case 3:

                                    System.out.println(
                                            "Current Balance: ₹" +
                                            loggedInAccount.getBalance());

                                    break;

                                case 4:

                                    System.out.print(
                                            "Enter Receiver Account Number: ");

                                    int receiverNumber =
                                            scanner.nextInt();

                                    BankAccount receiver =
                                            bank.findAccount(
                                                    receiverNumber);

                                    System.out.print(
                                            "Enter Transfer Amount: ");

                                    double transferAmount =
                                            scanner.nextDouble();

                                    try {

                                        loggedInAccount.transfer(
                                                receiver,
                                                transferAmount);

                                        bank.saveData();

                                    } catch (
                                            InsufficientBalanceException e) {

                                        System.out.println(
                                                "Transfer failed: " +
                                                e.getMessage());
                                    }

                                    break;

                                case 5:

                                    loggedInAccount
                                            .displayTransactionHistory();

                                    break;

                                case 6:

                                    loggedInAccount
                                            .displayAccountDetails();

                                    break;

                                case 7:

                                    System.out.print(
                                            "Enter Current PIN: ");

                                    int oldPin =
                                            scanner.nextInt();

                                    System.out.print(
                                            "Enter New 4-digit PIN: ");

                                    int newPin =
                                            scanner.nextInt();

                                    loggedInAccount.changePin(
                                            oldPin,
                                            newPin);

                                    bank.saveData();

                                    break;

                                case 8:

                                    loggedIn = false;

                                    System.out.println(
                                            "Logged out successfully.");

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid choice.");
                            }
                        }
                    }

                    break;

                case 3:

                    bank.displayAllAccounts();

                    break;

                case 4:

                    bank.saveData();

                    running = false;

                    System.out.println(
                            "\nThank you for using My Bank!");

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
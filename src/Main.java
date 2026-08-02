import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("       WELCOME TO MY BANK");
            System.out.println("=================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();

                    bank.createAccount(accountNumber, name);

                    break;

                case 2:

                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();

                    BankAccount depositAccount =
                            bank.findAccount(accountNumber);

                    if (depositAccount != null) {

                        System.out.print("Enter Deposit Amount: ");
                        double amount = scanner.nextDouble();

                        depositAccount.deposit(amount);

                    } else {

                        System.out.println("Account not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();

                    BankAccount withdrawAccount =
                            bank.findAccount(accountNumber);

                    if (withdrawAccount != null) {

                        System.out.print("Enter Withdrawal Amount: ");
                        double amount = scanner.nextDouble();

                        withdrawAccount.withdraw(amount);

                    } else {

                        System.out.println("Account not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();

                    BankAccount balanceAccount =
                            bank.findAccount(accountNumber);

                    if (balanceAccount != null) {

                        System.out.println(
                                "Current Balance: ₹"
                                        + balanceAccount.getBalance()
                        );

                    } else {

                        System.out.println("Account not found.");
                    }

                    break;

                case 5:

                    bank.displayAllAccounts();

                    break;

                case 6:

                    System.out.println("\nThank you for using My Bank!");
                    break;

                default:

                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
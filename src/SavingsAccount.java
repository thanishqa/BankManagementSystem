public class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(
            int accountNumber,
            String accountHolderName,
            int pin) {

        super(
                accountNumber,
                accountHolderName,
                pin);
    }

    @Override
    public String getAccountType() {

        return "Savings Account";
    }

    @Override
    public double calculateInterest() {

        return getBalance() * INTEREST_RATE;
    }
}
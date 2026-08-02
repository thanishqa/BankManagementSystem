public class CurrentAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(
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

        return "Current Account";
    }

    @Override
    public double calculateInterest() {

        return getBalance() * INTEREST_RATE;
    }
}
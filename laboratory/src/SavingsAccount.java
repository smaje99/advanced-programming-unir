import java.util.Date;

public final class SavingsAccount extends AccountProduct {
    public SavingsAccount(
            String accountNumber,
            Date openingDate,
            float interestRate,
            double balance
    ) {
        super(accountNumber, openingDate, interestRate, balance);
    }

    @Override
    public double calculateMonthlyInterest() {
        return getBalance() * (getInterestRate() / 100);
    }
}

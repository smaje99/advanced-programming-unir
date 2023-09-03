import java.util.Date;

public abstract class AccountProduct extends FinancialProduct implements InterestCalculable {
    private float interestRate;
    private double balance;

    public AccountProduct(
            String accountNumber,
            Date openingDate,
            float interestRate,
            double balance
    ) {
        super(accountNumber, openingDate);
        this.interestRate = interestRate;
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public float getInterestRate() {
        return interestRate;
    }


    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
}

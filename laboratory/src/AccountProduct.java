import java.util.Date;

public abstract class AccountProduct extends FinancialProduct implements InterestCalculable {
    private AccountNumber accountNumber;
    private float interestRate;
    private double balance;

    public AccountProduct(
        String accountNumber,
        Date openingDate,
        float interestRate,
        double balance
    ) {
        super(openingDate);
        this.accountNumber = new AccountNumber(accountNumber);
        this.interestRate = interestRate;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber.getValue();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.setValue(accountNumber);
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

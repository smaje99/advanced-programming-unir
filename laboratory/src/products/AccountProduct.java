package products;

import objects.AccountNumber;

import java.util.Date;
import java.util.Objects;

public abstract class AccountProduct extends FinancialProduct implements
        InterestCalculable, Depositable, Withdrawable {
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

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("No se puede retirar más de lo que hay en la cuenta");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("No se puede retirar una cantidad negativa");
        }

        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber.getValue();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = new AccountNumber(accountNumber);
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        AccountProduct that = (AccountProduct) object;

        return Objects.equals(accountNumber.getValue(), that.accountNumber.getValue());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNumber != null ? accountNumber.getValue().hashCode() : 0;
        temp = getOpeningDate().getTime();
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

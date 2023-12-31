package products;

import java.util.Date;

public final class CheckingAccount extends AccountProduct {
    private double overdraftAllowed;

    public CheckingAccount(
            String accountNumber,
            Date openingDate,
            double balance,
            float interestRate,
            double overdraftAllowed
    ) {
        super(accountNumber, openingDate, interestRate, balance);
        this.overdraftAllowed = overdraftAllowed;
    }

    @Override
    public double calculateMonthlyInterest() {
        return getBalance() * (getInterestRate() / (getInterestRate() > 1 ? 100 : 1));
    }

    public double getOverdraftAllowed() {
        return overdraftAllowed;
    }

    public void setOverdraftAllowed(double overdraftAllowed) {
        this.overdraftAllowed = overdraftAllowed;
    }

    public String toString() {
        return "Cuenta Corriente(número: " + getAccountNumber() + ", monto: " + getBalance() + ")";
    }
}

package products;

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
        return getBalance() * (getInterestRate() / (getInterestRate() > 1 ? 100 : 1));
    }

    @Override
    public String toString() {
        return "Cuenta de Ahorros(número: " + getAccountNumber() + ", monto ahorrado: " + getBalance() + ")";
    }
}

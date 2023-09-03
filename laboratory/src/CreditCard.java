import java.util.Date;

public class CreditCard extends FinancialProduct implements InterestCalculable {
    private Date expirationDate;
    private float interestOnUsage;
    private double creditLimit;
    private double usedAmount;

    public CreditCard(
            String accountNumber,
            Date openingDate,
            Date expirationDate,
            float interestOnUsage,
            double creditLimit,
            double usedAmount
    ) {
        super(accountNumber, openingDate);
        this.expirationDate = expirationDate;
        this.interestOnUsage = interestOnUsage;
        this.creditLimit = creditLimit;
        this.usedAmount = usedAmount;
    }

    @Override
    public double calculateMonthlyInterest() {
        return usedAmount * (interestOnUsage / 100);
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getInterestOnUsage() {
        return interestOnUsage;
    }

    public void setInterestOnUsage(float interestOnUsage) {
        this.interestOnUsage = interestOnUsage;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(double usedAmount) {
        this.usedAmount = usedAmount;
    }
}
package products;

import objects.CardNumber;

import java.util.Date;

public class CreditCard extends FinancialProduct implements InterestCalculable, Depositable {
    private CardNumber cardNumber;
    private Date expirationDate;
    private float interestOnUsage;
    private double creditLimit;
    private double usedAmount;

    public CreditCard(
        String cardNumber,
        Date openingDate,
        Date expirationDate,
        float interestOnUsage,
        double creditLimit,
        double usedAmount
    ) {
        super(openingDate);
        this.cardNumber = new CardNumber(cardNumber);
        this.expirationDate = expirationDate;
        this.interestOnUsage = interestOnUsage;
        this.creditLimit = creditLimit;
        this.usedAmount = usedAmount;
    }

    public CreditCard(
        String cardNumber,
        Date openingDate,
        Date expirationDate,
        float interestOnUsage,
        double creditLimit
    ) {
        this(
            cardNumber,
            openingDate,
            expirationDate,
            interestOnUsage,
            creditLimit,
            0d
        );
    }

    @Override
    public double calculateMonthlyInterest() {
        return usedAmount * (interestOnUsage / (interestOnUsage > 1 ? 100 : 1));
    }

    @Override
    public void deposit(double amount) {
        usedAmount += amount;
    }

    public String getCardNumber() {
        return cardNumber.getValue();
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = new CardNumber(cardNumber);
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

    @Override
    public String toString() {
        return "Tarjeta de Crédito(número: " + cardNumber.getValue() + "fondos usados:  " + usedAmount + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CreditCard that = (CreditCard) object;

        return cardNumber.getValue().equals(that.cardNumber.getValue());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cardNumber != null ? cardNumber.getValue().hashCode() : 0;
        temp = getOpeningDate().getTime();
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

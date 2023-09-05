package products;

import objects.CdtNumber;

import java.util.Date;
import java.util.Objects;

public final class TermDepositCertificate extends FinancialProduct
        implements MaturityCalculable, Depositable {
    private CdtNumber cdtNumber;
    private int monthsTerm;
    private double amount;
    private float monthlyInterest;

    public TermDepositCertificate(
            String cdtNumber,
            Date openingDate,
            int monthsTerm,
            double amount,
            float monthlyInterest
    ) {
        super(openingDate);
        this.cdtNumber = new CdtNumber(cdtNumber);
        this.monthsTerm = monthsTerm;
        this.amount = amount;
        this.monthlyInterest = monthlyInterest;
    }

    @Override
    public double calculateValueAtMaturity() {
        return amount * (monthlyInterest * monthsTerm / (monthlyInterest > 1 ? 100 : 1));
    }

    @Override
    public void deposit(double amount) {
        this.amount += amount;
    }

    public String getCdtNumber() {
        return cdtNumber.getValue();
    }

    public void setCdtNumber(String cdtNumber) {
        this.cdtNumber = new CdtNumber(cdtNumber);
    }

    public int getMonthsTerm() {
        return monthsTerm;
    }

    public void setMonthsTerm(int monthsTerm) {
        this.monthsTerm = monthsTerm;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public float getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(float monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    @Override
    public String toString() {
        return "CDT(n´´umero:  " + getCdtNumber() + ", fondos:  " + getAmount() + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        TermDepositCertificate that = (TermDepositCertificate) object;

        return Objects.equals(cdtNumber.getValue(), that.cdtNumber.getValue());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cdtNumber != null ? cdtNumber.getValue().hashCode() : 0;
        temp = getOpeningDate().getTime();
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

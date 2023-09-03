import java.util.Date;

public final class TermDepositCertificate extends FinancialProduct implements MaturityCalculable {
    private int monthsTerm;
    private double amount;
    private float monthlyInterest;

    public TermDepositCertificate(
            String accountNumber,
            Date openingDate,
            int monthsTerm,
            double amount,
            float monthlyInterest
    ) {
        super(accountNumber, openingDate);
        this.monthsTerm = monthsTerm;
        this.amount = amount;
        this.monthlyInterest = monthlyInterest;
    }

    @Override
    public double calculateMonthlyInterest() {
        return 0;
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
}

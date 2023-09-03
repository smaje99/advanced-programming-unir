import java.util.Date;

public abstract class FinancialProduct {
    private String accountNumber;
    private Date openingDate;

    public FinancialProduct(String accountNumber, Date openingDate) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }
}

package products;

import java.util.Date;

public abstract class FinancialProduct {
    private Date openingDate;

    public FinancialProduct(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }
}

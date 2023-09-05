package transations;

import java.util.Date;

public class FinancialTransaction {
    private double amount;
    private Date transactionDate;
    private Transaction transactionType;
    private String description;

    public FinancialTransaction(
        double amount,
        Date transactionDate,
        Transaction transactionType,
        String description
    ) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Transaction getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Transaction transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transacción: " + transactionType +
                " monto: " + amount +
                " descripción: " + description +
                " fecha: " + transactionDate;
    }
}

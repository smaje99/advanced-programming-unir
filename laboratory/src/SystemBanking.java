import customers.Customer;
import products.*;
import transations.FinancialTransaction;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemBanking {
    private final static ArrayList<Customer> CUSTOMERS;
    private final static HashMap<
            Customer, ArrayList<FinancialProduct>
            > FINANCIAL_PRODUCTS_BY_CUSTOMERS;
    private final static HashMap<
            FinancialProduct, ArrayList<FinancialTransaction>
            > FINANCIAL_TRANSACTIONS_BY_PRODUCTS;

    static {
        CUSTOMERS = new ArrayList<>();
        FINANCIAL_PRODUCTS_BY_CUSTOMERS = new HashMap<>();
        FINANCIAL_TRANSACTIONS_BY_PRODUCTS = new HashMap<>();
    }

    public void registerCustomer(Customer customer) {
        CUSTOMERS.add(customer);
        FINANCIAL_PRODUCTS_BY_CUSTOMERS.put(customer, new ArrayList<>());
    }

    public void registerProduct(Customer customer, FinancialProduct financialProduct) {
        FINANCIAL_PRODUCTS_BY_CUSTOMERS.get(customer).add(financialProduct);
        FINANCIAL_TRANSACTIONS_BY_PRODUCTS.put(financialProduct, new ArrayList<>());
    }

    public void registerTransaction(
        FinancialProduct financialProduct, FinancialTransaction financialTransaction
    ) {
        FINANCIAL_TRANSACTIONS_BY_PRODUCTS.get(financialProduct).add(financialTransaction);
    }

    public ArrayList<Customer> getCustomers() {
        return CUSTOMERS;
    }

    public ArrayList<FinancialProduct> getFinancialProducts(Customer customer) {
        return FINANCIAL_PRODUCTS_BY_CUSTOMERS.get(customer);
    }


    public ArrayList<FinancialTransaction> getFinancialTransactions(
        FinancialProduct financialProduct
    ) {
        return FINANCIAL_TRANSACTIONS_BY_PRODUCTS.get(financialProduct);
    }

    public void makeDeposit(Depositable depositable, double amount) {
        depositable.deposit(amount);
    }

    public void makeWithdrawal(Withdrawable withdrawable, double amount) {
        withdrawable.withdraw(amount);
    }

    public void makeTransfer(
        Withdrawable withdrawable,
        Depositable depositable,
        double amount
    ) {
        withdrawable.withdraw(amount);
        depositable.deposit(amount);
    }

    public double getMonthlyInterest(InterestCalculable financialProduct) {
        return financialProduct.calculateMonthlyInterest();
    }

    public double getMaturityInterest(MaturityCalculable  financialProduct) {
        return financialProduct.calculateValueAtMaturity();
    }

    public String sendExtractToEmail(String productNumber,  Customer customer) {
        return "Extracto del producto " + productNumber + " enviado al correo electrónico " + customer.getEmail();
    }

    public String sendExtractToAddress(String productNumber,  Customer customer) {
        return "Extracto del producto " + productNumber + " enviado a la dirección " + customer.getAddress();
    }
}

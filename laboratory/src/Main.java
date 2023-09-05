import customers.Customer;
import exceptions.FinancialProductNumberException;
import products.*;
import transations.FinancialTransaction;
import transations.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Laboratorio #1: Diseño e implementación de clasesTarea
 *
 * @author Sergio Andrés Majé Franco
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SystemBanking systemBanking = new SystemBanking();

        while (true) {
            System.out.print(
                    """
                            Bienvenido al sistema de banco.
                            Por favor, seleccione una opción:
                            1. Registrar cliente
                            2. Registrar producto financiero
                            3. Ver clientes
                            4. Ver productos financieros de un cliente
                            5. Ver extracto de un producto financiero de un cliente
                            6. Realizar una transacción
                            0. Salir
                            
                            >"""
            );
            int option = Integer.parseInt(reader.readLine());
            System.out.println();
            switch (option) {
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                case 1 -> {
                    System.out.println("Registrar Cliente");
                    try {
                        System.out.print("Número de identificación: ");
                        String dni = reader.readLine();
                        System.out.print("Nombre: ");
                        String name = reader.readLine();
                        System.out.print("Email: ");
                        String email = reader.readLine();
                        System.out.print("Número de celular: ");
                        String phoneNumber = reader.readLine();
                        System.out.print("Dirección: ");
                        String address = reader.readLine();

                        var customer = new Customer(dni, name, email, phoneNumber, address);
                        systemBanking.registerCustomer(customer);

                        System.out.println("Cliente registrado con éxito");
                    } catch (Exception e) {
                        System.err.println("Los valores del cliente no corresponden a este");
                    }
                }
                case 2 -> {
                    var customers = systemBanking.getCustomers();

                    if (customers.isEmpty()) {
                        System.out.println("No hay clientes registrados");
                        break;
                    }


                    System.out.println("Seleccione un cliente:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println(i + 1 + ". " + customers.get(i));
                    }
                    System.out.print(">");
                    int customerOption = Integer.parseInt(reader.readLine());

                    Customer customer;

                    try {
                        customer = customers.get(customerOption - 1);
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Usuario no encontrado");
                        break;
                    }

                    System.out.print(
                            """
                                    Registrar Cuenta
                                    Por favor, seleccione un producto financiero:
                                    1. Cuenta Corriente
                                    2. Cuenta de ahorro
                                    3. Tarjeta de crédito
                                    4. CDT
                                    0. Volver
                                    
                                    >"""
                    );
                    int productOption = Integer.parseInt(reader.readLine());

                    FinancialProduct financialProduct = null;

                    System.out.println();
                    switch (productOption) {
                        case 0 -> System.out.println("Regresando al menú principal");
                        case 1 -> {
                            System.out.println("Registrar Cuenta Corriente");
                            try {
                                System.out.print("Número de cuenta: ");
                                String accountNumber = reader.readLine();
                                System.out.print("Saldo inicial: ");
                                double balance = Double.parseDouble(reader.readLine());
                                System.out.print("Tasa de interés: ");
                                float interestRate = Float.parseFloat(reader.readLine());
                                System.out.print("Sobregiro permitido: ");
                                double overdraft = Double.parseDouble(reader.readLine());

                                financialProduct = new CheckingAccount(
                                    accountNumber,
                                    new Date(),
                                    balance,
                                    interestRate,
                                    overdraft
                                );
                            } catch (FinancialProductNumberException | IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Los valores del producto no corresponden a este");
                            }
                        }
                        case 2 -> {
                            System.out.println("Registrar Cuenta de Ahorros");
                            try {
                                System.out.print("Número de cuenta: ");
                                String accountNumber = reader.readLine();
                                System.out.print("Saldo inicial: ");
                                double balance = Double.parseDouble(reader.readLine());
                                System.out.print("Tasa de interés: ");
                                float interestRate = Float.parseFloat(reader.readLine());

                                financialProduct = new SavingsAccount(
                                    accountNumber,
                                    new Date(),
                                    interestRate,
                                    balance
                                );
                            } catch (FinancialProductNumberException | IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Los valores del producto no corresponden a este");
                            }
                        }
                        case 3 -> {
                            System.out.println("Registrar Tarjeta de Crédito");
                            try {
                                System.out.print("Número de tarjeta: ");
                                String cardNumber = reader.readLine();
                                System.out.print("Fecha de vencimiento (dd/mm/yyyy): ");
                                Date expirationDate = new SimpleDateFormat("dd/MM/yyyy")
                                        .parse(reader.readLine());
                                System.out.print("Interés por uso: ");
                                float interestOnUsage = Float.parseFloat(reader.readLine());
                                System.out.print("Cupo máximo: ");
                                double creditLimit = Double.parseDouble(reader.readLine());

                                financialProduct = new CreditCard(
                                    cardNumber,
                                    new Date(),
                                    expirationDate,
                                    interestOnUsage,
                                    creditLimit
                                );
                            } catch (FinancialProductNumberException | IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            } catch (ParseException e) {
                                System.err.println("La fecha no corresponde a este formato dd/MM/yyyy");
                            } catch (Exception e) {
                                System.err.println("Los valores del producto no corresponden a este");
                            }
                        }
                        case 4 -> {
                            System.out.println("Registrar CDT");
                            try {
                                System.out.print("Número de CDT: ");
                                String cdtNumber = reader.readLine();
                                System.out.print("Meses de termino: ");
                                int monthsTerm = Integer.parseInt(reader.readLine());
                                System.out.print("Monto: ");
                                double amount = Double.parseDouble(reader.readLine());
                                System.out.print("Interés mensual: ");
                                float monthlyInterest = Float.parseFloat(reader.readLine());

                                financialProduct = new TermDepositCertificate(
                                    cdtNumber,
                                    new Date(),
                                    monthsTerm,
                                    amount,
                                    monthlyInterest
                                );
                            } catch (FinancialProductNumberException | IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Los valores del producto no corresponden a este");
                            }
                        }
                        default -> System.out.println("Opción inválida");
                    }

                    if (financialProduct != null) {
                        systemBanking.registerProduct(customer, financialProduct);
                        System.out.println("Cuenta registrada con éxito");
                    }
                }
                case 3 -> {
                    System.out.println("Clientes del sistema bancario");
                    var customers = systemBanking.getCustomers();

                    if (customers.isEmpty()) {
                        System.out.println("No hay clientes registrados");
                    }

                    customers.forEach(System.out::println);
                }
                case 4 -> {
                    var customers = systemBanking.getCustomers();

                    if (customers.isEmpty()) {
                        System.out.println("No hay clientes registrados");
                        break;
                    }

                    System.out.println("Seleccione un cliente:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println(i + 1 + ". " + customers.get(i));
                    }
                    System.out.print(">");
                    int customerOption = Integer.parseInt(reader.readLine());

                    Customer customer;

                    try {
                        customer = customers.get(customerOption - 1);
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Usuario no encontrado");
                        break;
                    }

                    var products = systemBanking.getFinancialProducts(customer);


                    if (products.isEmpty()) {
                        System.out.println("El cliente no tiene productos registrados");
                        break;
                    }

                    System.out.println("Productos de " + customer.getName());
                    products.forEach(System.out::println);
                }
                case 5 -> {
                    var customers = systemBanking.getCustomers();

                    if (customers.isEmpty()) {
                        System.out.println("No hay clientes registrados");
                        break;
                    }

                    System.out.println("Seleccione un cliente:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println(i + 1 + ". " + customers.get(i));
                    }
                    System.out.print(">");
                    int customerOption = Integer.parseInt(reader.readLine());

                    Customer customer;

                    try {
                        customer = customers.get(customerOption - 1);
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Usuario no encontrado");
                        break;
                    }

                    var products = systemBanking.getFinancialProducts(customer);

                    if (products.isEmpty()) {
                        System.out.println("El cliente no tiene productos registrados");
                        break;
                    }

                    System.out.println("Seleccione un producto:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(i + 1 + ". " + products.get(i));
                    }
                    System.out.print(">");
                    int productOption = Integer.parseInt(reader.readLine());

                    FinancialProduct financialProduct;

                    try {
                        financialProduct = products.get(productOption - 1);
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Producto no encontrado");
                        break;
                    }

                    var transactions = systemBanking.getFinancialTransactions(financialProduct);

                    if (transactions.isEmpty()) {
                        System.out.println("El producto no tiene transacciones registradas");
                        break;
                    }

                    String productNumber = "";
                    if (financialProduct instanceof CreditCard a) {
                        productNumber = a.getCardNumber();
                    } else if (financialProduct instanceof TermDepositCertificate b) {
                        productNumber = b.getCdtNumber();
                    } else if (financialProduct instanceof AccountProduct c) {
                        productNumber = c.getAccountNumber();
                    }

                    System.out.println("Extracto del producto " + productNumber);
                    transactions.forEach(System.out::println);

                    System.out.print("""

                            ¿Desea recibir el extracto al correo electrónico o su dirección?
                            1. Correo electrónico
                            2. Dirección
                            >"""
                    );
                    int optionSend = Integer.parseInt(reader.readLine());
                    switch (optionSend) {
                        case 1 -> System.out.println(systemBanking.sendExtractToEmail(productNumber, customer));
                        case 2 -> System.out.println(systemBanking.sendExtractToAddress(productNumber, customer));
                        default -> System.out.println("Opción inválida");
                    }
                }
                case 6 -> {
                    System.out.print("""
                            Realizar transacción
                            1. Deposito
                            2. Retiro
                            3. Transferencia
                            4. Pago de Intereses
                            0. Volver
                            >"""
                    );
                    int optionTransaction = Integer.parseInt(reader.readLine());
                    switch (optionTransaction) {
                        case 1 -> {
                            var customers = systemBanking.getCustomers();

                            if (customers.isEmpty()) {
                                System.out.println("No hay clientes registrados");
                                break;
                            }

                            System.out.println("Seleccione un cliente:");
                            for (int i = 0; i < customers.size(); i++) {
                                System.out.println(i + 1 + ". " + customers.get(i));
                            }
                            System.out.print(">");
                            int customerOption = Integer.parseInt(reader.readLine());

                            Customer customer;

                            try {
                                customer = customers.get(customerOption - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Usuario no encontrado");
                                break;
                            }

                            var products = systemBanking.getFinancialProducts(customer);

                            if (products.isEmpty()) {
                                System.out.println("El cliente no tiene productos registrados");
                                break;
                            }

                            System.out.println("Seleccione un producto:");
                            for (int i = 0; i < products.size(); i++) {
                                System.out.println(i + 1 + ". " + products.get(i));
                            }
                            System.out.print(">");
                            int productOption = Integer.parseInt(reader.readLine());

                            FinancialProduct financialProduct;

                            try {
                                financialProduct = products.get(productOption - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Producto no encontrado");
                                break;
                            }

                            System.out.print("Ingrese el monto a depositar:");
                            double amount = Double.parseDouble(reader.readLine());

                            try {
                                systemBanking.makeDeposit((Depositable) financialProduct, amount);

                                systemBanking.registerTransaction(financialProduct, new FinancialTransaction(
                                    amount,
                                    new Date(),
                                    Transaction.DEPOSIT,
                                    "Consignación de fondos"
                                ));
                            } catch (ClassCastException e) {
                                System.err.println("El producto no es de tipo Depositable");
                            }
                        }
                        case 2 -> {
                            var customers = systemBanking.getCustomers();

                            if (customers.isEmpty()) {
                                System.out.println("No hay clientes registrados");
                                break;
                            }

                            System.out.println("Seleccione un cliente:");
                            for (int i = 0; i < customers.size(); i++) {
                                System.out.println(i + 1 + ". " + customers.get(i));
                            }
                            System.out.print(">");
                            int customerOption = Integer.parseInt(reader.readLine());

                            Customer customer;

                            try {
                                customer = customers.get(customerOption - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Usuario no encontrado");
                                break;
                            }

                            var products = systemBanking.getFinancialProducts(customer);

                            if (products.isEmpty()) {
                                System.out.println("El cliente no tiene productos registrados");
                                break;
                            }

                            System.out.println("Seleccione un producto:");
                            for (int i = 0; i < products.size(); i++) {
                                System.out.println(i + 1 + ". " + products.get(i));
                            }
                            System.out.print(">");
                            int productOption = Integer.parseInt(reader.readLine());

                            FinancialProduct financialProduct;

                            try {
                                financialProduct = products.get(productOption - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Producto no encontrado");
                                break;
                            }

                            System.out.print("Ingrese el monto a retirar:");
                            double amount = Double.parseDouble(reader.readLine());

                            try {
                                systemBanking.makeWithdrawal((Withdrawable) financialProduct, amount);

                                systemBanking.registerTransaction(financialProduct, new FinancialTransaction(
                                        amount,
                                        new Date(),
                                        Transaction.WITHDRAWAL,
                                        "Retiro de fondos"
                                ));
                            } catch (IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            } catch (ClassCastException e) {
                                System.err.println("El producto no es de tipo Retirable");
                            }
                        }
                        case 3 -> {
                            var customers = systemBanking.getCustomers();

                            if (customers.isEmpty()) {
                                System.out.println("No hay clientes registrados");
                                break;
                            }

                            System.out.println("Seleccione dos clientes:");
                            for (int i = 0; i < customers.size(); i++) {
                                System.out.println(i + 1 + ". " + customers.get(i));
                            }
                            System.out.print("Cliente 1: ");
                            int customer1Option = Integer.parseInt(reader.readLine());
                            System.out.print("Cliente 2: ");
                            int customer2Option = Integer.parseInt(reader.readLine());

                            Customer customer1;
                            Customer customer2;

                            try {
                                customer1 = customers.get(customer1Option - 1);
                                customer2 = customers.get(customer2Option - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Usuario no encontrado");
                                break;
                            }

                            var products1 = systemBanking.getFinancialProducts(customer1);
                            var products2 = systemBanking.getFinancialProducts(customer2);

                            if (products1.isEmpty()) {
                                System.out.println("El cliente 1 no tiene productos registrados");
                                break;
                            }

                            if (products2.isEmpty()) {
                                System.out.println("El cliente 2 no tiene productos registrados");
                                break;
                            }

                            System.out.println("Seleccione un producto del cliente 1:");
                            for (int i = 0; i < products1.size(); i++) {
                                System.out.println(i + 1 + ". " + products1.get(i));
                            }
                            System.out.print(">");
                            int productOption1 = Integer.parseInt(reader.readLine());

                            System.out.println("Seleccione un producto del cliente 2:");
                            for (int i = 0; i < products2.size(); i++) {
                                System.out.println(i + 1 + ". " + products2.get(i));
                            }
                            System.out.print(">");
                            int productOption2 = Integer.parseInt(reader.readLine());

                            FinancialProduct financialProduct1;
                            FinancialProduct financialProduct2;

                            try {
                                financialProduct1 = products1.get(productOption1 - 1);
                                financialProduct2 = products2.get(productOption2 - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Producto no encontrado");
                                break;
                            }

                            System.out.print("Ingrese el monto a transferir: ");
                            double amount = Double.parseDouble(reader.readLine());

                            try {
                                systemBanking.makeWithdrawal((Withdrawable) financialProduct1, amount);
                            } catch (IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            } catch (ClassCastException e) {
                                System.err.println("El producto no es de tipo Retirable");
                            }

                            try {
                                systemBanking.makeDeposit((Depositable) financialProduct2, amount);
                            } catch (ClassCastException e) {
                                System.err.println("El producto no es de tipo Depositable");
                            }

                            var transaction = new FinancialTransaction(
                                    amount,
                                    new Date(),
                                    Transaction.TRANSFER,
                                    "Transferencia de fondos"
                            );
                            systemBanking.registerTransaction(financialProduct1, transaction);
                            systemBanking.registerTransaction(financialProduct2, transaction);
                        }
                        case 4 -> {
                            var customers = systemBanking.getCustomers();

                            if (customers.isEmpty()) {
                                System.out.println("No hay clientes registrados");
                                break;
                            }

                            System.out.println("Seleccione un cliente:");
                            for (int i = 0; i < customers.size(); i++) {
                                System.out.println(i + 1 + ". " + customers.get(i));
                            }
                            System.out.print(">");
                            int customerOption = Integer.parseInt(reader.readLine());

                            Customer customer;

                            try {
                                customer = customers.get(customerOption - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Usuario no encontrado");
                                break;
                            }

                            var products = systemBanking.getFinancialProducts(customer);

                            if (products.isEmpty()) {
                                System.out.println("El cliente no tiene productos registrados");
                                break;
                            }

                            System.out.println("Seleccione un producto:");
                            for (int i = 0; i < products.size(); i++) {
                                System.out.println(i + 1 + ". " + products.get(i));
                            }
                            System.out.print(">");
                            int productOption = Integer.parseInt(reader.readLine());

                            FinancialProduct financialProduct;

                            try {
                                financialProduct = products.get(productOption - 1);
                            } catch (IndexOutOfBoundsException e) {
                                System.err.println("Producto no encontrado");
                                break;
                            }

                            if (financialProduct instanceof AccountProduct a) {
                                var amount = systemBanking.getMonthlyInterest(a);
                                systemBanking.makeDeposit(a, amount);
                                systemBanking.registerTransaction(a, new FinancialTransaction(
                                        amount,
                                        new Date(),
                                        Transaction.INTEREST,
                                        "Interés mensual"
                                ));

                                System.out.println("El interés mensual es de " + amount);
                            } else if (financialProduct instanceof CreditCard b) {
                                var amount = systemBanking.getMonthlyInterest(b);
                                systemBanking.makeDeposit(b, amount);
                                systemBanking.registerTransaction(b, new FinancialTransaction(
                                        amount,
                                        new Date(),
                                        Transaction.INTEREST,
                                        "Interés mensual por uso"
                                ));


                                System.out.println("El interés mensual por uso es de " + amount);
                            } else if (financialProduct instanceof TermDepositCertificate c) {
                                var amount = systemBanking.getMaturityInterest(c);
                                systemBanking.makeDeposit(c, amount);
                                systemBanking.registerTransaction(c, new FinancialTransaction(
                                        amount,
                                        new Date(),
                                        Transaction.INTEREST,
                                        "Interés por vencimiento"
                                ));

                                System.out.println("El interés por vencimiento es de " + amount);
                                System.out.println("Se le recomienda retirar su dinero del CDT");
                            }
                        }
                        default -> System.out.println("Regresando al menú principal");
                    }
                }
                default -> System.out.println("Opción inválida");
            }
            System.out.println();
        }
    }
}

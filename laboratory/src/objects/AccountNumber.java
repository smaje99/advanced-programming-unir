package objects;

import exceptions.FinancialProductNumberException;

import java.util.regex.Pattern;

public final class AccountNumber {
    private static final Pattern PATTERN;

    static {
        PATTERN = Pattern.compile("^\\d{10}$");
    }

    private String value;

    public AccountNumber(String value) {
        this.value = value;

        ensureValueIsDefined(value);
        ensureValueIsNumber(value);
        ensureIsValidAccountNumber(value);
    }

    public void ensureValueIsDefined(String value) throws IllegalArgumentException {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Número de cuenta debe ser definido");
        }
    }

    public void ensureValueIsNumber(String value) throws IllegalArgumentException {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número de cuenta debe contener solo números");
        }
    }

    public void ensureIsValidAccountNumber(
        String value
    ) throws FinancialProductNumberException {
        if (!PATTERN.matcher(value).find()) {
            throw new FinancialProductNumberException("##########");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}

package objects;

import exceptions.FinancialProductNumberException;

import java.util.regex.Pattern;

public class CardNumber {
    private static final Pattern PATTERN;

    static {
        PATTERN = Pattern.compile("^\\d{16}$");
    }

    private String value;

    public CardNumber(String value) {
        this.value = value;

        ensureValueIsDefined(value);
        ensureValueIsNumber(value);
        ensureIsValidCardNumber(value);
    }

    public void ensureValueIsDefined(String value) throws IllegalArgumentException {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Número de tarjeta debe ser definido");
        }
    }

    public void ensureValueIsNumber(String value) throws IllegalArgumentException {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número de tarjeta debe contener solo números");
        }
    }

    public void ensureIsValidCardNumber(String value) throws FinancialProductNumberException {
        if (!PATTERN.matcher(value).find()) {
            throw new FinancialProductNumberException("#### #### #### ####");
        }
    }

    public String getValue() {
        var formattedCardNumber = new StringBuilder();
        int length = value.length();
        int chuckSize = 4;

        for (int index = 0; index < length; index += chuckSize) {
            int endIndex = Math.min(length, index + chuckSize);
            formattedCardNumber.append(value, index, endIndex);

            if (endIndex < length) {
                formattedCardNumber.append(" ");
            }
        }

        return formattedCardNumber.toString();
    }

    @Override
    public String toString() {
        return getValue();
    }
}

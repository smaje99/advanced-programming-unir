package objects;

import java.util.regex.Pattern;

public class CardNumber {
    private static final String REGEX;
    private static final Pattern PATTERN;

    static {
        REGEX = "^[0-9]{10}$";
        PATTERN = Pattern.compile(REGEX);
    }

    private String value;

    public CardNumber(String value) {
        ensureIsValidCardNumber(value);
        this.value = value;
    }

    public void ensureIsValidCardNumber(
        String cardNumber
    ) throws FinancialProductNumberException {
        if (!PATTERN.matcher(cardNumber).find()) {
            throw new FinancialProductNumberException(REGEX);
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        ensureIsValidCardNumber(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

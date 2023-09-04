import java.util.regex.Pattern;

public final class AccountNumber {
    private static final String REGEX;
    private static final Pattern PATTERN;

    static {
        REGEX = "^[0-9]{10}$";
        PATTERN = Pattern.compile(REGEX);
    }

    private String value;

    public AccountNumber(String value) {
        this.value = value;

        ensureIsValidAccountNumber(value);
    }

    public void ensureIsValidAccountNumber(
        String accountNumber
    ) throws FinancialProductNumberException {
        if (!PATTERN.matcher(accountNumber).find()) {
            throw new FinancialProductNumberException(REGEX);
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        ensureIsValidAccountNumber(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

import java.util.regex.Pattern;

public class CdtNumber {
    private static final String REGEX;
    private static final Pattern PATTERN;

    static {
        REGEX = "^[0-9]{10}$";
        PATTERN = Pattern.compile(REGEX);
    }

    private String value;

    public CdtNumber(String value) {
        ensureIsValidCdtNumber(value);
        this.value = value;
    }

    public void ensureIsValidCdtNumber(
        String cdtNumber
    ) throws FinancialProductNumberException {
        if (!PATTERN.matcher(cdtNumber).find()) {
            throw new FinancialProductNumberException(REGEX);
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        ensureIsValidCdtNumber(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

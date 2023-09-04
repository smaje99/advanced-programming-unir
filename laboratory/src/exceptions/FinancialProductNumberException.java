package exceptions;

public class FinancialProductNumberException extends RuntimeException {
    private String pattern;

    public FinancialProductNumberException(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public String getMessage() {
        return "El número del producto financiero debe seguir el patrón: " + pattern;
    }
}

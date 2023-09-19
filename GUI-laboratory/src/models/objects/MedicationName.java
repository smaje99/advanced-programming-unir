package models.objects;

import java.util.regex.Pattern;

public class MedicationName {
    private static final Pattern PATTERN;

    static {
        PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    }

    private String value;

    public MedicationName(String value) {
        this.value = value;

        ensureNameIsDefined(value);
        ensureNameIsAlphaNumeric(value);
    }

    public void ensureNameIsDefined(String value) throws IllegalArgumentException {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Nombre del medicamento debe ser definido");
        }
    }

    public void ensureNameIsAlphaNumeric(String value) throws IllegalArgumentException {
        if (!PATTERN.matcher(value).find()) {
            throw new IllegalArgumentException("Nombre del medicamento debe contener valores alfanuméricos");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

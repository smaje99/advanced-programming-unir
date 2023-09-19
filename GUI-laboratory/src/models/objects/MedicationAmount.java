package models.objects;

public class MedicationAmount {
    private int value;

    public MedicationAmount(int value) {
        this.value = value;

        ensureAmountIsDefined(value);
        ensureAmountIsGreaterThanZero(value);
    }

    public static void ensureAmountIsDefined(Integer value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("La cantidad debe ser definida");
        }
    }

    public static void ensureAmountIsGreaterThanZero(int value) throws IllegalArgumentException {
        if (value <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

package models.objects;

import models.enums.Type;

public class MedicationType {
    Type value;

    public MedicationType(Type value) {
        this.value = value;

        ensureMedicationTypeIsDefined(value);
    }

    public static void ensureMedicationTypeIsDefined(Type value) {
		if (value == null) {
            throw new IllegalArgumentException("Tipo de medicación debe ser definido");
        }

    }

    public Type getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getType();
    }
}

package models.objects;

import models.enums.Branch;

public class MedicationBranch {
    private Branch[] values;

    public MedicationBranch(Branch[] values) {
        this.values = values;

        ensureBranchIsDefined(values);
    }

    public static void ensureBranchIsDefined(Branch[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Sucursal debe ser definida");
        }
    }

    public Branch[] getValues() {
        return values;
    }
}

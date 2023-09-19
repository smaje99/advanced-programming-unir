package models.objects;

import models.enums.Branch;

public class MedicationBranch {
    private Branch value;

    public MedicationBranch(Branch value) {
        this.value = value;

        ensureBranchIsDefined(value);
    }

    public void ensureBranchIsDefined(Branch value) {
        if (value == null) {
            throw new IllegalArgumentException("Sucursal must be defined");
        }
    }

    public Branch getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getAddress();
    }
}

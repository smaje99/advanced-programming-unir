package models.objects;

import models.enums.Distributor;

public class MedicationDistributor {
    private Distributor value;

    public MedicationDistributor(Distributor value) {
        this.value = value;

        ensureDistributorIsDefined(value);
    }

    public static void ensureDistributorIsDefined(Distributor value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("El distribuidor farmacéutico debe ser definido");
        }
    }


    public Distributor getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getDistributor();
    }
}

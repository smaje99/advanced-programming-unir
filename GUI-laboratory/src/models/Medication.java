package models;

import models.enums.Branch;
import models.enums.Distributor;
import models.enums.Type;
import models.objects.*;

public class Medication {
    private MedicationName name;
    private MedicationType type;
    private MedicationAmount amount;
    private MedicationDistributor distributor;

    private MedicationBranch branches;

    public Medication(String name, Type type, int amount, Distributor distributor, Branch[] branches) {
        this.name = new MedicationName(name);
        this.type = new MedicationType(type);
        this.amount = new MedicationAmount(amount);
        this.distributor = new MedicationDistributor(distributor);
        this.branches = new MedicationBranch(branches);
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name = new MedicationName(name);
    }

    public Type getType() {
        return type.getValue();
    }

    public void setType(Type type) {
        this.type = new MedicationType(type);
    }

    public int getAmount() {
        return amount.getValue();
    }

    public void setAmount(int amount) {
        this.amount = new MedicationAmount(amount);
    }

    public Distributor getDistributors() {
        return distributor.getValue();

    }

    public void setDistributors(Distributor distributor) {
        this.distributor = new MedicationDistributor(distributor);
    }

    public Branch[] getBranches() {
        return branches.getValues();
    }

    public void setBranch(Branch[] branches) {
        this.branches = new MedicationBranch(branches);
    }
}

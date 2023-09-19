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

    private MedicationBranch branch;

    public Medication(String name, Type type, int amount, Distributor distributor, Branch branch) {
        this.name = new MedicationName(name);
        this.type = new MedicationType(type);
        this.amount = new MedicationAmount(amount);
        this.distributor = new MedicationDistributor(distributor);
        this.branch = new MedicationBranch(branch);
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

    public Distributor getDistributor() {
        return distributor.getValue();

    }

    public void setDistributor(Distributor distributor) {
        this.distributor = new MedicationDistributor(distributor);
    }

    public Branch getBranch() {
        return branch.getValue();
    }

    public void setBranch(Branch branch) {
        this.branch = new MedicationBranch(branch);
    }
}

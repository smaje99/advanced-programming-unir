package models.enums;

public enum Branch {
    PRIMARY("Primaria", "Calle de la Rosa n. 28"),
    SECONDARY("Secundaria", "Calle Alcazabilla n. 3");

    private final String branch;
    private final String address;

    Branch(String branch, String address) {
        this.branch = branch;
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public String getAddress() {
        return address;
    }
}

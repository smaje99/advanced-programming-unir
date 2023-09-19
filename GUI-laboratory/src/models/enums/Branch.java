package models.enums;

public enum Branch {
    PRIMARY("Calle de la Rosa n. 28"),
    SECONDARY("Calle de la Rosa n. 28");

    private final String address;

    Branch(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

package models.enums;

public enum Type {
    ANALGESIC("analgésico"),
    ANALEPTIC("analéptico"),
    ANESTHETIC("anestésico"),
    ANTACID("antiácido"),
    ANTIDEPRESSANT("antidepresivo"),
    ANTIBIOTIC("antibiótico");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

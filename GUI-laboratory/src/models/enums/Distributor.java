package models.enums;

public enum Distributor {
    COFARMA("Cofarma"),
    EMPSEPHAR("Empsephar"),
    CEMEFAR("Cemefar");

    private final String distributor;

    Distributor(String distributor) {
        this.distributor = distributor;
    }

    public String getDistributor() {
        return distributor;
    }
}

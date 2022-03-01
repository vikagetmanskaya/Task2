package by.javacourse.task2.entity;

public enum Soil {
    PODZOLIC("podzolic"),
    GROUND("ground"),
    SOD_PODZOLIC("sod-podzolic");

    private String value;

    Soil(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

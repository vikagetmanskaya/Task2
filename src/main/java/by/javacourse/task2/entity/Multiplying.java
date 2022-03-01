package by.javacourse.task2.entity;

public enum Multiplying {
    LEAVES("leaves"),
    CUTTING("cutting"),
    SEEDS("seeds");
    private String value;

    Multiplying(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

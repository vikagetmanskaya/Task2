package by.javacourse.task2.entity;

public enum Lightning {
    LIGHT_LOVING("light_loving"),
    NOT_LIGHT_LOVING("not_light_loving");

    private String value;

    Lightning(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

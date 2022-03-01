package by.javacourse.task2.entity;

public enum FlowerType {
    FIELD("field"),
    DECORATIVE("decorative");
    private String value;
    FlowerType(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

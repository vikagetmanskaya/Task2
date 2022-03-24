package by.javacourse.task2.handler;

public enum FlowerXmlTag {
    FLOWERS("flowers"),
    FLOWER("flower"),
    TREE("tree"),
    BUSH("bush"),
    ID("id"),
    NAME("name"),
    TYPE_OF_FLOWER("type-of-flower"),
    SOIL("soil"),
    ORIGIN("origin"),
    STEAM_COLOR("steam-color"),
    LEAF_COLOR("leaf-color"),
    SIZE("size"),
    MULTIPLYING("multiplying"),
    DATE_OF_PLANTING("date-of-planting"),
    TEMPERATURE("temperature"),
    LIGHTNING("lightning"),
    WATERING("watering"),
    MAX_AGE("max-age"),
    AMOUNT_OF_TRUNKS("amount-of-trunks"),
    VISUAL_PARAMETERS("visual-parameters"),
    GROWING_TIPS("growing-tips");
    private String value;

    FlowerXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package by.javacourse.task2.entity;

public class VisualParameters {
    private String steamColor;
    private String leafColor;
    private String size;

    public VisualParameters() {
    }

    public VisualParameters(String stem_color, String leaf_color, String size) {
        this.steamColor = stem_color;
        this.leafColor = leaf_color;
        this.size = size;
    }

    public String getSteamColor() {
        return steamColor;
    }

    public void setSteamColor(String steamColor) {
        this.steamColor = steamColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

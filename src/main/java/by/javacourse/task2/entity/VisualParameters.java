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

    @Override
    public int hashCode() {
        int result = steamColor == null ? 0 : steamColor.hashCode();
        result = 31 * result + (leafColor == null ? 0 : leafColor.hashCode());
        result = 31 * result + (size == null ? 0 : size.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        VisualParameters visualParameters = (VisualParameters) obj;

        return steamColor.equals(visualParameters.steamColor) && leafColor.equals(visualParameters.leafColor) && size.equals(visualParameters.size);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("steam color = ").append(steamColor).append(" ");
        stringBuilder.append("leaf color = ").append(leafColor).append(" ");
        stringBuilder.append("size = ").append(size).append(" ");
        return stringBuilder.toString();

    }
}

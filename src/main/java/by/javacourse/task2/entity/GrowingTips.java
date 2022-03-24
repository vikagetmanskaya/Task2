package by.javacourse.task2.entity;

public class GrowingTips {
    private static final String REPLACE_THIS = "_";
    private static final String REPLACE_ON = " ";
    private String temperature;
    private Lightning lighting;
    private String watering;

    public GrowingTips() {
    }

    public GrowingTips(String temperature, Lightning lighting, String watering) {
        this.temperature = temperature;
        this.lighting = lighting;
        this.watering = watering;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Lightning getLighting() {
        return lighting;
    }

    public void setLighting(Lightning lighting) {
        this.lighting = lighting;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    @Override
    public int hashCode() {
        int result = temperature == null ? 0 : temperature.hashCode();
        result = 31 * result + (lighting == null ? 0 : lighting.hashCode());
        result = 31 * result + (watering == null ? 0 : watering.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        GrowingTips growingTips = (GrowingTips) obj;

        return temperature.equals(growingTips.temperature) && lighting.equals(growingTips.lighting) && watering.equals(growingTips.watering);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temperature = ").append(temperature).append(" ");
        stringBuilder.append("lighting = ").append(lighting.toString().toLowerCase().replace(REPLACE_THIS, REPLACE_ON)).append(" ");
        stringBuilder.append("watering = ").append(watering);
        return stringBuilder.toString();

    }
}

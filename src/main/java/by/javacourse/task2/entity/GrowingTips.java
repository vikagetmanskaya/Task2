package by.javacourse.task2.entity;

public class GrowingTips {
    private String temperature;
    private Lighting lighting;
    private String watering;

    public GrowingTips() {
    }

    public GrowingTips(String temperature, Lighting lighting, String watering) {
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

    public Lighting getLighting() {
        return lighting;
    }

    public void setLighting(Lighting lighting) {
        this.lighting = lighting;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }
}

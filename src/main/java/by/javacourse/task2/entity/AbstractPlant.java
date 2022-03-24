package by.javacourse.task2.entity;


import java.time.LocalDate;

public abstract class AbstractPlant {
    private static final String REPLACE_THIS = "_";
    private static final String REPLACE_ON = " ";
    private String id;
    private String name;
    private Soil soil;
    private String origin;
    private VisualParameters visualParameters = new VisualParameters();
    private Multiplying multiplying;
    private LocalDate dateOfPlanting;
    private GrowingTips growingTips = new GrowingTips();

    public AbstractPlant() {
    }

    public AbstractPlant(String id, String name, Soil soil, String origin, VisualParameters visualParameters, Multiplying multiplying, LocalDate date_of_planting, GrowingTips growingTips) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.multiplying = multiplying;
        this.dateOfPlanting = date_of_planting;
        this.growingTips = growingTips;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    public LocalDate getDateOfPlanting() {
        return dateOfPlanting;
    }

    public void setDateOfPlanting(LocalDate dateOfPlanting) {
        this.dateOfPlanting = dateOfPlanting;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    @Override
    public int hashCode() {
        int result = id == null ? 0 : id.hashCode();
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (soil == null ? 0 : soil.hashCode());
        result = 31 * result + (origin == null ? 0 : origin.hashCode());
        result = 31 * result + (visualParameters == null ? 0 : visualParameters.hashCode());
        result = 31 * result + (multiplying == null ? 0 : multiplying.hashCode());
        result = 31 * result + (dateOfPlanting == null ? 0 : dateOfPlanting.hashCode());
        result = 31 * result + (growingTips == null ? 0 : growingTips.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        AbstractPlant plant = (AbstractPlant) obj;

        return id.equals(plant.id) && name.equals(plant.name) && soil.equals(plant.soil) && origin.equals(plant.origin) && visualParameters.equals(plant.visualParameters) && multiplying.equals(plant.multiplying) && dateOfPlanting.equals(plant.dateOfPlanting) && growingTips.equals(plant.growingTips);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id = ").append(id).append(" ");
        stringBuilder.append("name = ").append(name).append(" ");
        stringBuilder.append("soil = ").append(soil.toString().toLowerCase().replace(REPLACE_THIS, REPLACE_ON)).append(" ");
        stringBuilder.append("origin = ").append(origin).append(" ");
        stringBuilder.append("visual parameters = ").append(visualParameters).append(" ");
        stringBuilder.append("multiplying = ").append(multiplying.toString().toLowerCase()).append(" ");
        stringBuilder.append("date of planting = ").append(dateOfPlanting).append(" ");
        stringBuilder.append("growing tips = ").append(growingTips).append(" ");
        return stringBuilder.toString();

    }
}

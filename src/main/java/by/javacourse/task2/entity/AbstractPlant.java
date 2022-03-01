package by.javacourse.task2.entity;


import java.time.LocalDate;

public abstract class AbstractPlant {
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
}

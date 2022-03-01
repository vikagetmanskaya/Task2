package by.javacourse.task2.entity;

import java.time.LocalDate;

public class Flower extends AbstractPlant{
    private FlowerType typeOfFLower;

    public FlowerType getType() {
        return typeOfFLower;
    }

    public void setType(FlowerType typeOfFLower) {
        this.typeOfFLower = typeOfFLower;
    }
}

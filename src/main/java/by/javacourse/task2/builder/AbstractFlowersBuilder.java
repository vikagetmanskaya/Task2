package by.javacourse.task2.builder;

import by.javacourse.task2.entity.AbstractPlant;
import by.javacourse.task2.exception.FlowerException;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AbstractFlowersBuilder {
    protected Set<AbstractPlant> plants;

    public AbstractFlowersBuilder() {
        plants = new LinkedHashSet<>();
    }

    public Set<AbstractPlant> getPlants() {
        return plants;
    }

    public abstract void buildSetPlants(String fileName) throws FlowerException;
}

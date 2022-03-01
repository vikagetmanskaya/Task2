package by.javacourse.task2.builder;

import by.javacourse.task2.entity.AbstractPlant;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractFlowersBuilder {
    protected Set<AbstractPlant> plants;

    public AbstractFlowersBuilder() {
        plants = new HashSet<AbstractPlant>();
    }
    public Set<AbstractPlant> getPlants(){
        return plants;
    }
    public abstract void buildSetPlants(String fileName);
}

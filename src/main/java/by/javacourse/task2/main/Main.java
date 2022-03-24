package by.javacourse.task2.main;

import by.javacourse.task2.builder.AbstractFlowersBuilder;
import by.javacourse.task2.builder.FlowerBuilderFactory;
import by.javacourse.task2.builder.FlowersSaxBuilder;
import by.javacourse.task2.builder.TypeParser;
import by.javacourse.task2.exception.FlowerException;


public class Main {
    public static void main(String[] args) throws FlowerException {
        AbstractFlowersBuilder abstractFlowersBuilder = FlowerBuilderFactory.createFlowerBuilder(TypeParser.DOM);
        abstractFlowersBuilder.buildSetPlants("src/main/resources/data/flowers.xml");
        System.out.println(abstractFlowersBuilder.getPlants().toString());

    }
}

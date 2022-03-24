package testFlowerXmlTask.builder;

import by.javacourse.task2.builder.AbstractFlowersBuilder;
import by.javacourse.task2.builder.FlowerBuilderFactory;
import by.javacourse.task2.builder.TypeParser;
import by.javacourse.task2.exception.FlowerException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FlowersDomBuilderTest {
    private static final String FLOWERS_XML_FILE = "src/test/resources/data/flowers1.xml";
    private AbstractFlowersBuilder builder;
    private String expected;

    @BeforeClass
    public void setUp() {
        String[] array = new String[]{"id = a1 name = chamomile type = field soil = ground origin = Altai visual parameters = steam color = green leaf color = white size = 0.2 m  multiplying = seeds date of planting = 2021-05-15 growing tips = temperature = 20 degree lighting = light loving watering = 200 ml", "id = a2 name = eucalyptus max age = 100 soil = ground origin = Australia visual parameters = steam color = brown leaf color = green size = 30 m  multiplying = cutting date of planting = 2021-03-20 growing tips = temperature = 15 degree lighting = light loving watering = 1000000 ml", "id = a3 name = jasmine amount of trunks = 10 soil = sod podzolic origin = Arabia visual parameters = steam color = green leaf color = green size = 3 m  multiplying = cutting date of planting = 2021-10-01 growing tips = temperature = 23 degree lighting = not light loving watering = 10000 ml"};
        expected = Arrays.toString(array);
    }

    @Test
    public void testParsingFlowers() {

        try {
            builder = FlowerBuilderFactory.createFlowerBuilder(TypeParser.DOM);
            builder.buildSetPlants(FLOWERS_XML_FILE);
        } catch (FlowerException e) {
            e.printStackTrace();
        }
        String actual = builder.getPlants().toString();
        Assert.assertEquals(expected, actual);
    }
}

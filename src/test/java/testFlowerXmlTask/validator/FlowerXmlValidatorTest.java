package testFlowerXmlTask.validator;

import by.javacourse.task2.validator.FlowerXMLValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlowerXmlValidatorTest {
    private static final String FIRST_XML_FILE = "src/test/resources/data/flowers1.xml";
    private static final String SECOND_XML_FILE = "src/test/resources/data/flowers2.xml";
    private static final String XSD_FILE = "src/test/resources/data/flowers.xsd";

    @Test
    public void testIsValidFile() {
        FlowerXMLValidator flowerXMLValidator = FlowerXMLValidator.getInstance();
        boolean actual;
        actual = flowerXMLValidator.validateXML(FIRST_XML_FILE, XSD_FILE);
        Assert.assertTrue(actual);

    }

    @Test
    public void testIsNotValidFile() {
        FlowerXMLValidator flowerXMLValidator = FlowerXMLValidator.getInstance();
        boolean actual;
        actual = flowerXMLValidator.validateXML(SECOND_XML_FILE, XSD_FILE);
        Assert.assertFalse(actual);

    }
}

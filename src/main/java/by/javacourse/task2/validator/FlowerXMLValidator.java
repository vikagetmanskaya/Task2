package by.javacourse.task2.validator;

import by.javacourse.task2.handler.FlowerErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class FlowerXMLValidator {
    private static final Logger logger = LogManager.getLogger();
    private static FlowerXMLValidator instance;

    private FlowerXMLValidator() {
    }

    public static FlowerXMLValidator getInstance() {
        if (instance == null) {
            instance = new FlowerXMLValidator();
        }
        return instance;
    }

    public boolean validateXML(String fileXmlName, String fileXsdName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(fileXsdName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileXmlName);
            validator.setErrorHandler(new FlowerErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            logger.error(fileXmlName + " is not correct or valid " + e);
            return false;
        }
        return true;

    }
}

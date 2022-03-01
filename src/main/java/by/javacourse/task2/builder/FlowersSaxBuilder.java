package by.javacourse.task2.builder;

import by.javacourse.task2.handler.FlowerErrorHandler;
import by.javacourse.task2.handler.FlowerHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class FlowersSaxBuilder extends AbstractFlowersBuilder {
    private static Logger logger = LogManager.getLogger();
    private FlowerHandler handler = new FlowerHandler();
    private XMLReader reader;

    public FlowersSaxBuilder() {
        super();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            logger.error("Error in SAX " + e);
        }
        reader.setErrorHandler(new FlowerErrorHandler());
        reader.setContentHandler(handler);
    }

    @Override
    public void buildSetPlants(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            logger.error("Parsing error, check fileName " + fileName + " " + e);
        }
        plants = handler.getPlants();
    }
}

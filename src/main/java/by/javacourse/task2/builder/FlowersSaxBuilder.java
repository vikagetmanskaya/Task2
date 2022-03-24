package by.javacourse.task2.builder;

import by.javacourse.task2.exception.FlowerException;
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
    private static final Logger logger = LogManager.getLogger();
    private FlowerHandler handler = new FlowerHandler();
    private XMLReader reader;

    public FlowersSaxBuilder() throws FlowerException {
        super();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            logger.error("Error in SAX " + e);
            throw new FlowerException("Error in SAX", e);
        }
        reader.setContentHandler(handler);
        reader.setErrorHandler(new FlowerErrorHandler());
    }

    @Override
    public void buildSetPlants(String fileName) throws FlowerException {
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            logger.error("Parsing error, check fileName " + fileName + " " + e);
            throw new FlowerException("Sax exception and I/O exception", e);
        }
        plants = handler.getPlants();
    }
}

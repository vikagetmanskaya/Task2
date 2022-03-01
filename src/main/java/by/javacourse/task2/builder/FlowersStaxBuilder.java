package by.javacourse.task2.builder;

import by.javacourse.task2.entity.*;
import by.javacourse.task2.handler.FlowerXmlTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class FlowersStaxBuilder extends AbstractFlowersBuilder {
    private static Logger logger = LogManager.getLogger();
    private XMLInputFactory inputFactory;

    public FlowersStaxBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetPlants(String fileName) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(FlowerXmlTag.FLOWER.getValue())) {
                        Flower flower = buildFlower(reader);
                        plants.add(flower);
                    } else if (name.equals(FlowerXmlTag.TREE.getValue())) {
                        Tree tree = buildTree(reader);
                        plants.add(tree);
                    } else if (name.equals(FlowerXmlTag.BUSH.getValue())) {
                        Bush bush = buildBush(reader);
                        plants.add(bush);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            logger.error("Error in Stax, check your fileName: " + fileName + " " + e);
        } catch (IOException e) {
            logger.error("I/O error " + e);
        }

    }
    private Flower buildFlower(XMLStreamReader reader) throws XMLStreamException{
        Flower flower = new Flower();
        //null check
        flower.setType(FlowerType.valueOf(reader.getAttributeValue(null, FlowerXmlTag.TYPE_OF_FLOWER.getValue())));
        buildPlant(reader, flower);
        return flower;
    }
    private Tree buildTree(XMLStreamReader reader) throws XMLStreamException{
        Tree tree = new Tree();
        //null check
        tree.setMaxAge(Integer.parseInt(reader.getAttributeValue(null, FlowerXmlTag.MAX_AGE.getValue())));
        buildPlant(reader, tree);
        return tree;
    }
    private Bush buildBush(XMLStreamReader reader) throws XMLStreamException{
        Bush bush = new Bush();
        //null check
        bush.setAmountOfTrunks(Integer.parseInt(reader.getAttributeValue(null, FlowerXmlTag.AMOUNT_OF_TRUNKS.getValue())));
        buildPlant(reader, bush);
        return bush;
    }
    private void buildPlant(XMLStreamReader reader, AbstractPlant plant) throws XMLStreamException {
        plant.setId(reader.getAttributeValue(null, FlowerXmlTag.ID.getValue()));
        plant.setName(reader.getAttributeValue(null, FlowerXmlTag.NAME.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerXmlTag.valueOf(name.toUpperCase().replace("-", "_"))){
                        case SOIL -> plant.setSoil(Soil.valueOf(getXMLText(reader)));
                        case ORIGIN -> plant.setOrigin(getXMLText(reader));
                        case VISUAL_PARAMETERS -> plant.setVisualParameters(getXMLVisualParameters(reader));
                        case MULTIPLYING -> plant.setMultiplying(Multiplying.valueOf(getXMLText(reader)));
                        case DATE_OF_PLANTING -> plant.setDateOfPlanting(LocalDate.parse(getXMLText(reader)));
                        case GROWING_TIPS -> plant.setGrowingTips(getXMLGrowingTips(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(FlowerXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == FlowerXmlTag.FLOWER ||
                            FlowerXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == FlowerXmlTag.TREE ||
                            FlowerXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == FlowerXmlTag.BUSH){
                        return;
                    }
            }
        }
    }

    private VisualParameters getXMLVisualParameters(XMLStreamReader reader) throws XMLStreamException {
        VisualParameters visualParameters = new VisualParameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerXmlTag.valueOf(name.toUpperCase())) {
                        case STEAM_COLOR -> visualParameters.setSteamColor(getXMLText(reader));
                        case LEAF_COLOR -> visualParameters.setLeafColor(getXMLText(reader));
                        case SIZE -> visualParameters.setSize(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == FlowerXmlTag.VISUAL_PARAMETERS) {
                        return visualParameters;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <visual-parameters>");
    }
    private GrowingTips getXMLGrowingTips(XMLStreamReader reader) throws XMLStreamException {
        GrowingTips growingTips = new GrowingTips();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerXmlTag.valueOf(name.toUpperCase())) {
                        case TEMPERATURE -> growingTips.setTemperature(getXMLText(reader));
                        case LIGHTNING -> growingTips.setLighting(Lighting.valueOf(getXMLText(reader)));
                        case WATERING -> growingTips.setWatering(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerXmlTag.valueOf(name.toUpperCase().replace("-", "_")) == FlowerXmlTag.GROWING_TIPS) {
                        return growingTips;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <growing-tips>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}


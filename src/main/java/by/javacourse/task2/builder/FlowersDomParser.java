package by.javacourse.task2.builder;

import by.javacourse.task2.entity.*;
import by.javacourse.task2.exception.FlowerException;
import by.javacourse.task2.handler.FlowerXmlTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;


public class FlowersDomParser extends AbstractFlowersBuilder {
    private static final String REPLACE_THIS = "-";
    private static final String REPLACE_ON = "_";
    private static final Logger logger = LogManager.getLogger();
    private DocumentBuilder documentBuilder;

    public FlowersDomParser() throws FlowerException {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Error in Dom: " + e);
            throw new FlowerException("Error in Dom", e);
        }
    }

    @Override
    public void buildSetPlants(String fileName) throws FlowerException {
        Document doc;

        try {
            doc = documentBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList flowerList = root.getElementsByTagName(FlowerXmlTag.FLOWER.getValue());
            NodeList treeList = root.getElementsByTagName(FlowerXmlTag.TREE.getValue());
            NodeList bushList = root.getElementsByTagName(FlowerXmlTag.BUSH.getValue());
            for (int i = 0; i < flowerList.getLength(); i++) {
                Element plantElement = (Element) flowerList.item(i);
                Flower plant = buildFlower(plantElement);
                plants.add(plant);
            }
            for (int i = 0; i < treeList.getLength(); i++) {
                Element plantElement = (Element) treeList.item(i);
                Tree plant = buildTree(plantElement);
                plants.add(plant);
            }
            for (int i = 0; i < bushList.getLength(); i++) {
                Element plantElement = (Element) bushList.item(i);
                Bush plant = buildBush(plantElement);
                plants.add(plant);
            }
        } catch (SAXException | IOException e) {
            logger.error("Parsing error, check fileName " + fileName + " " + e);
            throw new FlowerException("Sax exception and I/O exception", e);
        }
    }

    private Flower buildFlower(Element flowerElement) {
        Flower flower = new Flower();
        if (flowerElement.hasAttribute(FlowerXmlTag.TYPE_OF_FLOWER.getValue())) {
            flower.setType(FlowerType.valueOf(flowerElement.getAttribute(FlowerXmlTag.TYPE_OF_FLOWER.getValue()).toUpperCase()));
        }
        buildPlant(flowerElement, flower);
        return flower;
    }

    private Tree buildTree(Element treeElement) {
        Tree tree = new Tree();
        if (treeElement.hasAttribute(FlowerXmlTag.MAX_AGE.getValue())) {
            tree.setMaxAge(Integer.parseInt((treeElement.getAttribute(FlowerXmlTag.MAX_AGE.getValue()))));
        }
        buildPlant(treeElement, tree);

        return tree;
    }

    private Bush buildBush(Element bushElement) {
        Bush bush = new Bush();
        if (bushElement.hasAttribute(FlowerXmlTag.AMOUNT_OF_TRUNKS.getValue())) {
            bush.setAmountOfTrunks(Integer.parseInt(bushElement.getAttribute(FlowerXmlTag.AMOUNT_OF_TRUNKS.getValue())));
        }
        buildPlant(bushElement, bush);
        return bush;
    }

    public void buildPlant(Element element, AbstractPlant plant) {
        plant.setId(element.getAttribute(FlowerXmlTag.ID.getValue()));
        plant.setName(element.getAttribute(FlowerXmlTag.NAME.getValue()));
        plant.setSoil(Soil.valueOf(getElementTextContent(element, FlowerXmlTag.SOIL.getValue()).toUpperCase().replace(REPLACE_THIS, REPLACE_ON)));
        plant.setOrigin(getElementTextContent(element, FlowerXmlTag.ORIGIN.getValue()));
        VisualParameters visualParameters = plant.getVisualParameters();
        Element visualParametersElement = (Element) element.getElementsByTagName(FlowerXmlTag.VISUAL_PARAMETERS.getValue()).item(0);
        visualParameters.setSteamColor(getElementTextContent(visualParametersElement, FlowerXmlTag.STEAM_COLOR.getValue()));
        visualParameters.setLeafColor(getElementTextContent(visualParametersElement, FlowerXmlTag.LEAF_COLOR.getValue()));
        visualParameters.setSize(getElementTextContent(visualParametersElement, FlowerXmlTag.SIZE.getValue()));
        plant.setMultiplying(Multiplying.valueOf(getElementTextContent(element, FlowerXmlTag.MULTIPLYING.getValue()).toUpperCase()));
        plant.setDateOfPlanting(LocalDate.parse(getElementTextContent(element, FlowerXmlTag.DATE_OF_PLANTING.getValue())));
        GrowingTips growingTips = plant.getGrowingTips();
        Element growingTipsElement = (Element) element.getElementsByTagName(FlowerXmlTag.GROWING_TIPS.getValue()).item(0);
        growingTips.setTemperature(getElementTextContent(growingTipsElement, FlowerXmlTag.TEMPERATURE.getValue()));
        growingTips.setLighting(Lightning.valueOf(getElementTextContent(growingTipsElement, FlowerXmlTag.LIGHTNING.getValue()).toUpperCase().replace(REPLACE_THIS, REPLACE_ON)));
        growingTips.setWatering(getElementTextContent(growingTipsElement, FlowerXmlTag.WATERING.getValue()));
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}

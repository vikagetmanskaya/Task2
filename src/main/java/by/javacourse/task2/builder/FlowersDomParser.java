package by.javacourse.task2.builder;

import by.javacourse.task2.entity.*;
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
    private static Logger logger = LogManager.getLogger();
    private DocumentBuilder documentBuilder;

    public FlowersDomParser() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Error in Dom: " + e);
        }
    }

    @Override
    public void buildSetPlants(String fileName) {
        Document doc;

        try {
            doc = documentBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList flowerList = root.getElementsByTagName("flower");
            NodeList treeList = root.getElementsByTagName("tree");
            NodeList bushList = root.getElementsByTagName("bush");
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
        }
    }

    private Flower buildFlower(Element flowerElement) {
        Flower flower = new Flower();
        if (flowerElement.hasAttribute("type-of-flower")) {
            flower.setType(FlowerType.valueOf(flowerElement.getAttribute("type-of-flower")));
        }
        buildPlant(flowerElement, flower);
        return flower;
    }

    private Tree buildTree(Element treeElement) {
        Tree tree = new Tree();
        if (treeElement.hasAttribute("max-age")) {
            tree.setMaxAge(Integer.parseInt((treeElement.getAttribute("max-age"))));
        }
        buildPlant(treeElement, tree);

        return tree;
    }

    private Bush buildBush(Element bushElement) {
        Bush bush = new Bush();
        if (bushElement.hasAttribute("amount-of-trunks")) {
            bush.setAmountOfTrunks(Integer.parseInt("amount-of-trunks"));
        }
        buildPlant(bushElement, bush);
        return bush;
    }

    public void buildPlant(Element element, AbstractPlant plant) {
        plant.setId(element.getAttribute("id"));
        plant.setName(element.getAttribute("name"));
        plant.setSoil(Soil.valueOf(getElementTextContent(element, "soil")));
        plant.setOrigin(getElementTextContent(element, "origin"));
        VisualParameters visualParameters = plant.getVisualParameters();
        Element visualParametersElement = (Element) element.getElementsByTagName("visual-parameters").item(0);
        visualParameters.setSteamColor(getElementTextContent(visualParametersElement, "steam-color"));
        visualParameters.setLeafColor(getElementTextContent(visualParametersElement, "leaf-color"));
        visualParameters.setSize(getElementTextContent(visualParametersElement, "size"));
        plant.setMultiplying(Multiplying.valueOf(getElementTextContent(element, "multiplying")));
        plant.setDateOfPlanting(LocalDate.parse(getElementTextContent(element, "date-of-planting")));
        GrowingTips growingTips = plant.getGrowingTips();
        Element growingTipsElement = (Element) element.getElementsByTagName("growing-tips").item(0);
        growingTips.setTemperature(getElementTextContent(growingTipsElement, "temperature"));
        growingTips.setTemperature(getElementTextContent(growingTipsElement, "lighting"));
        growingTips.setTemperature(getElementTextContent(growingTipsElement, "watering"));
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

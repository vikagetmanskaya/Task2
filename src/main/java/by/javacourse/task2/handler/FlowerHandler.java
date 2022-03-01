package by.javacourse.task2.handler;

import by.javacourse.task2.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class FlowerHandler extends DefaultHandler {
    private Set<AbstractPlant> plants;
    private AbstractPlant current;
    private FlowerXmlTag currentXmlTag;
    private EnumSet<FlowerXmlTag> withText;

    public FlowerHandler() {
        plants = new HashSet<AbstractPlant>();
        withText = EnumSet.range(FlowerXmlTag.SOIL, FlowerXmlTag.WATERING);
    }

    public Set<AbstractPlant> getPlants() {
        return plants;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (FlowerXmlTag.FLOWER.getValue().equals(qName)) {
            current = new Flower();
            current.setName(attributes.getValue(0));
            current.setId(attributes.getValue(1));
            if (attributes.getLength() == 3) {
                ((Flower) current).setType(FlowerType.valueOf(attributes.getValue(2)));
            }
        } else if (FlowerXmlTag.TREE.getValue().equals(qName)) {
            current = new Tree();
            current.setName(attributes.getValue(0));
            current.setId(attributes.getValue(1));
            if (attributes.getLength() == 3) {
                ((Tree) current).setMaxAge(Integer.parseInt(attributes.getValue(2)));
            }
        } else if (FlowerXmlTag.BUSH.getValue().equals(qName)) {
            current = new Bush();
            current.setName(attributes.getValue(0));
            current.setId(attributes.getValue(1));
            if (attributes.getLength() == 3) {
                ((Bush) current).setAmountOfTrunks(Integer.parseInt(attributes.getValue(2)));
            }
        } else {
            FlowerXmlTag temp = FlowerXmlTag.valueOf(qName.toUpperCase().replace("-", "_"));
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (FlowerXmlTag.FLOWER.getValue().equals(qName) || FlowerXmlTag.TREE.getValue().equals(qName) || FlowerXmlTag.BUSH.getValue().equals(qName)) {
            plants.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case SOIL -> current.setSoil(Soil.valueOf(data));
                case ORIGIN -> current.setOrigin(data);
                case STEAM_COLOR -> current.getVisualParameters().setSteamColor(data);
                case LEAF_COLOR -> current.getVisualParameters().setLeafColor(data);
                case SIZE -> current.getVisualParameters().setSize(data);
                case MULTIPLYING -> current.setMultiplying(Multiplying.valueOf(data));
                case DATE_OF_PLANTING -> current.setDateOfPlanting(LocalDate.parse(data));
                case TEMPERATURE -> current.getGrowingTips().setTemperature(data);
                case LIGHTNING -> current.getGrowingTips().setLighting(Lighting.valueOf(data));
                case WATERING -> current.getGrowingTips().setWatering(data);
                default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}


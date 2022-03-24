package by.javacourse.task2.handler;

import by.javacourse.task2.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FlowerHandler extends DefaultHandler {
    private static final String REPLACE_THIS = "-";
    private static final String REPLACE_ON = "_";
    private Set<AbstractPlant> plants;
    private AbstractPlant current;
    private FlowerXmlTag currentXmlTag;
    private EnumSet<FlowerXmlTag> withText;

    public FlowerHandler() {
        plants = new LinkedHashSet<>();
        withText = EnumSet.range(FlowerXmlTag.SOIL, FlowerXmlTag.WATERING);
    }

    public Set<AbstractPlant> getPlants() {
        return plants;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (FlowerXmlTag.valueOf(qName.toUpperCase().replace(REPLACE_THIS, REPLACE_ON))) {
            case FLOWER -> {
                current = new Flower();
                current.setId(attributes.getValue(FlowerXmlTag.ID.getValue()));
                current.setName(attributes.getValue(FlowerXmlTag.NAME.getValue()));
                if (attributes.getLength() == 3) {
                    ((Flower) current).setType(FlowerType.valueOf(attributes.getValue(FlowerXmlTag.TYPE_OF_FLOWER.getValue()).toUpperCase()));
                }
            }
            case TREE -> {
                current = new Tree();
                current.setId(attributes.getValue(FlowerXmlTag.ID.getValue()));
                current.setName(attributes.getValue(FlowerXmlTag.NAME.getValue()));
                if (attributes.getLength() == 3) {
                    ((Tree) current).setMaxAge(Integer.parseInt(attributes.getValue(FlowerXmlTag.MAX_AGE.getValue())));
                }
            }
            case BUSH -> {
                current = new Bush();
                current.setId(attributes.getValue(FlowerXmlTag.ID.getValue()));
                current.setName(attributes.getValue(FlowerXmlTag.NAME.getValue()));
                if (attributes.getLength() == 3) {
                    ((Bush) current).setAmountOfTrunks(Integer.parseInt(attributes.getValue(FlowerXmlTag.AMOUNT_OF_TRUNKS.getValue())));
                }
            }
            default -> {
                FlowerXmlTag temp = FlowerXmlTag.valueOf(qName.toUpperCase().replace(REPLACE_THIS, REPLACE_ON));
                if (withText.contains(temp)) {
                    currentXmlTag = temp;
                }
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
                case SOIL -> current.setSoil(Soil.valueOf(data.toUpperCase().replace(REPLACE_THIS, REPLACE_ON)));
                case ORIGIN -> current.setOrigin(data);
                case STEAM_COLOR -> current.getVisualParameters().setSteamColor(data);
                case LEAF_COLOR -> current.getVisualParameters().setLeafColor(data);
                case SIZE -> current.getVisualParameters().setSize(data);
                case MULTIPLYING -> current.setMultiplying(Multiplying.valueOf(data.toUpperCase()));
                case DATE_OF_PLANTING -> current.setDateOfPlanting(LocalDate.parse(data));
                case TEMPERATURE -> current.getGrowingTips().setTemperature(data);
                case LIGHTNING -> current.getGrowingTips().setLighting(Lightning.valueOf(data.toUpperCase().replace(REPLACE_THIS, REPLACE_ON)));
                case WATERING -> current.getGrowingTips().setWatering(data);
                default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}


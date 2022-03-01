package by.javacourse.task2.builder;

public class FlowerBuilderFactory {
    private enum TypeParser {
        SAX, DOM, STAX
    }

    private FlowerBuilderFactory() {
    }

    public static AbstractFlowersBuilder createFlowerBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new FlowersDomParser();
            case SAX:
                return new FlowersSaxBuilder();
            case STAX:
                return new FlowersStaxBuilder();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
    }
}

package by.javacourse.task2.builder;

import by.javacourse.task2.exception.FlowerException;

public class FlowerBuilderFactory {


    private FlowerBuilderFactory() {
    }

    public static AbstractFlowersBuilder createFlowerBuilder(TypeParser typeParser) throws FlowerException {
        return switch (typeParser) {
            case DOM -> new FlowersDomParser();
            case SAX -> new FlowersSaxBuilder();
            case STAX -> new FlowersStaxBuilder();
            default -> throw new EnumConstantNotPresentException(
                    typeParser.getDeclaringClass(), typeParser.name());
        };
    }
}

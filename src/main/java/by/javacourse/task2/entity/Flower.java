package by.javacourse.task2.entity;


public class Flower extends AbstractPlant {
    private static final String REPLACE_THIS = "_";
    private static final String REPLACE_ON = " ";
    private FlowerType typeOfFLower;

    public FlowerType getType() {
        return typeOfFLower;
    }

    public void setType(FlowerType typeOfFLower) {
        this.typeOfFLower = typeOfFLower;
    }

    @Override
    public int hashCode() {
        int result = 31 * super.hashCode() + (typeOfFLower == null ? 0 : typeOfFLower.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Flower flower = (Flower) obj;

        return typeOfFLower.equals(flower.typeOfFLower);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id = ").append(getId()).append(" ");
        stringBuilder.append("name = ").append(getName()).append(" ");
        if (typeOfFLower != null) {
            stringBuilder.append("type = ").append(typeOfFLower.toString().toLowerCase()).append(" ");
        }
        stringBuilder.append("soil = ").append(getSoil().toString().toLowerCase().replace(REPLACE_THIS, REPLACE_ON)).append(" ");
        stringBuilder.append("origin = ").append(getOrigin()).append(" ");
        stringBuilder.append("visual parameters = ").append(getVisualParameters()).append(" ");
        stringBuilder.append("multiplying = ").append(getMultiplying().toString().toLowerCase()).append(" ");
        stringBuilder.append("date of planting = ").append(getDateOfPlanting()).append(" ");
        stringBuilder.append("growing tips = ").append(getGrowingTips());
        return stringBuilder.toString();

    }

}

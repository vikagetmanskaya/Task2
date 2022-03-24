package by.javacourse.task2.entity;

public class Bush extends AbstractPlant {
    private static final String REPLACE_THIS = "_";
    private static final String REPLACE_ON = " ";
    private int amountOfTrunks;


    public int getAmountOfTrunks() {
        return amountOfTrunks;
    }

    public void setAmountOfTrunks(int amountOfTrunks) {
        this.amountOfTrunks = amountOfTrunks;
    }

    @Override
    public int hashCode() {
        int result = 31 * super.hashCode() + amountOfTrunks;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Bush bush = (Bush) obj;

        return amountOfTrunks == bush.amountOfTrunks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id = ").append(getId()).append(" ");
        stringBuilder.append("name = ").append(getName()).append(" ");
        if (amountOfTrunks != 0) {
            stringBuilder.append("amount of trunks = ").append(amountOfTrunks).append(" ");
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

package by.javacourse.task2.entity;

import java.time.LocalDate;

public class Tree extends AbstractPlant {
    private static final String REPLACE_THIS = "_";
    private static final String REPLACE_ON = " ";
    private int maxAge;


    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public int hashCode() {
        int result = 31 * super.hashCode() + maxAge;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Tree tree = (Tree) obj;

        return maxAge == tree.maxAge;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id = ").append(getId()).append(" ");
        stringBuilder.append("name = ").append(getName()).append(" ");
        if (maxAge != 0) {
            stringBuilder.append("max age = ").append(maxAge).append(" ");
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

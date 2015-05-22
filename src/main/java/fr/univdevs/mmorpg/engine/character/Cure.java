package fr.univdevs.mmorpg.engine.character;

/**
 * Abstract class Cure
 * Represents all the cures
 * A Cure can cure a Character from 10 to MAX
 */
public abstract class Cure extends Item{
    private int restoredPoints;

    /**
     * Cure constructor
     *
     * @param cureName       the name of the cure, can't be changed
     * @param cureCategory   the category of the cure, can't be changed
     * @param cureCost       the cost of the cure
     * @param cureWeight     the weight of the cure, can't be changed
     * @param restoredPoints amounts of points restored by the cure
     */
    public Cure(String cureName, String cureCategory, int cureCost, int cureWeight, int restoredPoints) {
        super(cureName, cureCategory, cureCost, cureWeight);
        this.restoredPoints = restoredPoints;
    }

    /**
     * Cure constructor
     *
     * @param cureName       the name of the cure, can't be changed
     * @param cureCategory   the category of the cure, can't be changed
     * @param cureCost       the cost of the cure
     * @param restoredPoints amounts of points restored by the cure
     */
    public Cure(String cureName, String cureCategory, int cureCost, int restoredPoints) {
        super(cureName, cureCategory, cureCost);
        this.restoredPoints = restoredPoints;
    }

    /**
     * Public method to return the amount of points resotred by the cure
     * @return int
     */
    public int getRestoredPoints() {
        return restoredPoints;
    }
}

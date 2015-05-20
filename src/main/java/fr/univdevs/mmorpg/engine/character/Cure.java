package fr.univdevs.mmorpg.engine.character;

/**
 * Created by drattak on 20/05/15.
 */
public abstract class Cure extends Item{
    private int restoredPoints;

    public Cure(String itemName, String itemCategory, int itemCost, int itemWeight, int restoredPoints) {
        super(itemName, itemCategory, itemCost, itemWeight);
        this.restoredPoints = restoredPoints;
    }

    public Cure(String itemName, String itemCategory, int itemCost, int restoredPoints) {
        super(itemName, itemCategory, itemCost);
        this.restoredPoints = restoredPoints;
    }

    public int getRestoredPoints() {
        return restoredPoints;
    }
}

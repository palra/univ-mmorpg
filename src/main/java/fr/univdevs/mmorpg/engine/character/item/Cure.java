package fr.univdevs.mmorpg.engine.character.item;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;

/**
 * Abstract class cure
 * Represents all the cures
 * A cure can cure a Character from 10 to MAX
 */
public abstract class Cure extends Item {
    private int restoredPoints;



    /**
     * cure constructor
     *
     * @param cureCategory   the category of the cure, can't be changed
     * @param cureCost       the cost of the cure
     * @param cureWeight     the weight of the cure, can't be changed
     * @param restoredPoints amounts of points restored by the cure
     */
    public Cure(String cureCategory, int cureCost, int cureWeight, int restoredPoints) {
        super(cureCategory, cureCost, cureWeight);
        this.restoredPoints = restoredPoints;
    }


    /**
     * cure constructor
     *
     * @param cureCategory   the category of the cure, can't be changed
     * @param cureCost       the cost of the cure
     * @param restoredPoints amounts of points restored by the cure
     */
    public Cure(String cureCategory, int cureCost, int restoredPoints) {
        super(cureCategory, cureCost);
        this.restoredPoints = restoredPoints;
    }

    public Cure(Cure other) {
        super(other);
        this.restoredPoints = other.restoredPoints;
    }

    /**
     * Public method to return the amount of points resotred by the cure
     *
     * @return int
     */
    public int getRestoredPoints() {
        return restoredPoints;
    }



    /**
     * Redefinition of toString
     *
     * @return the generated String
     */
    public String toString() {
        return "categorie = " + this.getCategory() + '\n' + "coût = " + this.getCost() + '\n' + "Points restaurés = " + this.restoredPoints + '\n';
    }

    /**
     * Cures the given character
     *
     * @param c The character to cure
     */
    public void apply(Character c) {
        c.setHealth(c.getHealth() + restoredPoints);
    }

    public boolean isCollidable() {
        return false;
    }
}

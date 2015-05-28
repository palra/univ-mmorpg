package fr.univdevs.mmorpg.engine.character;

/**
 * Potion class
 * A Potion is a kind of cure, therefore it extends to it
 * A Potion restore 10 points
 */
public class Potion extends Cure{
    public Potion(String potionName, String potionCategory, int potionCost, int potionWeight) {
        super(potionName, potionCategory, potionCost, potionWeight, 10);
    }

    /**
     * function to specify the action of the potion
     *
     * @param Character on which character the potion will be applied
     */
    public void onRegister(String Character) {
    }

    /**
     * function to specify the action of the potion
     * @param Character on which character the potion will be applied
     */
    public void onUnregister(String Character){}

    public int getX() {
        return 0;
    }

    public void setX(int x) {

    }

    public int getY() {
        return 0;
    }

    public void setY(int y) {

    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}



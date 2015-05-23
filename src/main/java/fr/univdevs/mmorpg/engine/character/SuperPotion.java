package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.character.Cure;
import fr.univdevs.mmorpg.engine.character.utils.Pair;
import fr.univdevs.mmorpg.engine.world.Entity;

/**
 * SuperPotion Class
 * A super potion is a kind of cure,
 * A super potion restore 20 points
 */
public class SuperPotion extends Cure {
    public SuperPotion(String superPotionName, int superPotionCost, int superPotionWeight) {
        super(superPotionName, "SuperPotion", superPotionCost, superPotionWeight, 20);
    }

    public void onRegister(String Character) {
    }

    public void onUnregister(String Character) {
    }

    public int getX() {
        return 0;
    }

    public void setX(int x) {

    }

    public int getY() {
        return 0;
    }

    public void setY(int y) {
        ;

    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }

    public Pair getPair() {
        return new Pair(0, 0);
    }
}

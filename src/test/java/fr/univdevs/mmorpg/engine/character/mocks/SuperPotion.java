package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Cure;

/**
 * Created by drattak on 21/05/15.
 */
public class SuperPotion extends Cure {
    public SuperPotion(String superPotionName, String superPotionCategory, int superPotionCost, int superPotionWeight, int superPotionPoints) {
        super(superPotionName, superPotionCategory, superPotionCost, superPotionWeight, superPotionPoints);
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

    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

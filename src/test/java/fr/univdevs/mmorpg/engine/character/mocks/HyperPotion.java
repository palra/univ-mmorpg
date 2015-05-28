package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Cure;
import fr.univdevs.mmorpg.engine.utils.Vector2D;

/**
 * HyperPotion class
 * An hyperpotion is a kind of cure
 * An hyperpotion restore 50 points
 */
public class HyperPotion extends Cure {

    public HyperPotion(String chosenName) {
        super(chosenName, "HyperPotion", 50, 50);
    }

    @Override
    public void onRegister(String character) {

    }

    @Override
    public void onUnregister(String character) {

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

    public Vector2D getPosition() {
        return null;
    }


}

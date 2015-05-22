package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Weapon;
import fr.univdevs.mmorpg.engine.character.utils.Pair;

/**
 * Testclass Bow
 * A Bow
 */
public class Bow extends Weapon {
    public Bow(String bowName, String bowCategory, int bowCost, int bowWeight, int bowPower) {
        super(bowName, bowCategory, bowCost, bowWeight, bowPower);
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

    public Pair getPair() {
        return new Pair(0, 0);
    }
}

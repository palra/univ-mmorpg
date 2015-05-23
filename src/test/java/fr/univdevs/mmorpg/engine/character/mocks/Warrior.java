package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.utils.Pair;

/**
 * Created by drattak on 23/05/15.
 */
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, "Warrior");
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
        return true;
    }

    public Pair getPair() {
        return null;
    }
}

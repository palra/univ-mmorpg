package fr.univdevs.mmorpg.game;

import fr.univdevs.util.Vector2D;

/**
 * Created by drattak on 23/05/15.
 * TODO : document
 */
public class Warrior extends fr.univdevs.mmorpg.engine.character.Character {
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

    public Vector2D getPosition() {
        return null;
    }
}

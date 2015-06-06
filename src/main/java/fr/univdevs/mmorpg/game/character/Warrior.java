package fr.univdevs.mmorpg.game.character;

import fr.univdevs.mmorpg.engine.character.Character;
/**
 * Created by drattak on 23/05/15.
 * TODO : document
 */
public class Warrior extends Character {
    /**
     * Default constructor
     *
     * @param name The name of the warrior
     */
    public Warrior(String name) {
        super(name, "Warrior");
    }

    public String getDisplay() {
        return (this.getName().trim().charAt(0) + "").toUpperCase();
    }

    public boolean isCollidable() {
        return true;
    }
}

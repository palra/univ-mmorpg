package fr.univdevs.mmorpg.game.character;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.util.ansi.ANSIChar;

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

    public ANSIChar getDisplay() {
        return new ANSIChar(this.getName().trim().toUpperCase().charAt(0));
    }

    public boolean isCollidable() {
        return true;
    }
}

package fr.univdevs.mmorpg.game.item.protection;

import fr.univdevs.mmorpg.engine.character.item.Protection;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Helmet class
 * A helmet protect by 0.1
 */
public class Helmet extends Protection {
    /**
     * Helmet constructor
     * A helmet add 0.1 to protection coefficient
     */
    public Helmet() {
        super("Helmet", 45, 20, 0.1);
    }

    public ANSIChar getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

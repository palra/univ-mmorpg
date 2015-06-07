package fr.univdevs.mmorpg.game.item.protection;

import fr.univdevs.mmorpg.engine.character.item.Protection;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Armor class
 * An armor is the most complete protection for a character
 * Resistance is increase by 35%.
 */
public class Armor extends Protection {
    /**
     * Protection constructor
     * A protection is something the character carries to improve his defence
     */
    public Armor() {
        super("Armor", 80, 150, 0.35);
    }

    public ANSIChar getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

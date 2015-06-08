package fr.univdevs.mmorpg.game.item.protection;

import fr.univdevs.mmorpg.engine.character.item.Protection;
import fr.univdevs.util.ansi.ANSIAttribute;
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
        super("Armor", 500, 150, 0.45);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('?', ANSIAttribute.FG_MAGENTA);
    }
}

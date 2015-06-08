package fr.univdevs.mmorpg.game.item.protection;

import fr.univdevs.mmorpg.engine.character.item.Protection;
import fr.univdevs.util.ansi.ANSIAttribute;
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
        super("Helmet", 200, 20, 0.1);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('\u26d1', ANSIAttribute.FG_CYAN);
    } // \u26d1 => ⛑
}

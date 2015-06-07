package fr.univdevs.mmorpg.game.item.protection;

import fr.univdevs.mmorpg.engine.character.item.Protection;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Shield class
 * A shield is the first protection
 */
public class Shield extends Protection {
    /**
     * Protection constructor
     * A protection is something the character carries to improve his defence
     */
    public Shield() {
        super("Shield", 90, 50, 0.2);
    }

    public ANSIChar getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

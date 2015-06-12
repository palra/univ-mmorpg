package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Public class Sword
 * A sword is a weapon
 * Has a power of 11 points
 */
public class Sword extends Weapon {

    public Sword() {
        super("Sword", 200, 100, 100);
    }

    public Sword(Sword other) {
        super(other);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('\u21fe', ANSIAttribute.FG_MAGENTA);
    }
}

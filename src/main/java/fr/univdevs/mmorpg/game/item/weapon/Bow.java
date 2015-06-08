package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Class Bow
 * A Bow has a power of 10 points
 */
public class Bow extends Weapon {


    public Bow() {
        super("Bow", 120, 150, 10);
    }
    public ANSIChar getDisplay() {
        return new ANSIChar('\u2931', ANSIAttribute.FG_MAGENTA); // => ⤱
    }
}

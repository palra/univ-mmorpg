package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Public class Knife
 * a knife has a power of 4 points
 */
public class Knife extends Weapon {

    public Knife() {
        super("Knife", 30, 30, 4);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('\u21e8', ANSIAttribute.FG_MAGENTA); // => ⇨
    }

}

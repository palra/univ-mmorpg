package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Potion class
 * A potion restore 10 hp
 */
public class Potion extends Cure {

    public Potion() {
        super("Potion", 100, 10);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('\u25ce', ANSIAttribute.FG_YELLOW); // => ◎
    }
}

package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * HyperPotion class
 * An hyperpotion restore 50 hp
 */
public class HyperPotion extends Cure {

    public HyperPotion() {
        super("HyperPotion", 300, 30);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('\u25c9', ANSIAttribute.FG_YELLOW); // => ◉
    }
}

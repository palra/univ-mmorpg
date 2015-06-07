package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * SuperPotion class
 * A superpotion restore 20 hp
 */
public class SuperPotion extends Cure {

    public SuperPotion() {
        super("SuperPotion", 20, 20);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('\u25cd', ANSIAttribute.FG_YELLOW); // => ◍
    }
}

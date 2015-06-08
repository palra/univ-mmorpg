package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Public class HealerCure
 * This is the best cure
 * Only the healer can use it
 * It restores 90 pts
 * Category, Cost, RestoredPoints
 */
public class HealerCure extends Cure {

    public HealerCure() {
        super("HealerCure", 1000, 90);
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('\u25cf', ANSIAttribute.FG_YELLOW); // => ●
    }
}

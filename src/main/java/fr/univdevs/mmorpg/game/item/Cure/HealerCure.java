package fr.univdevs.mmorpg.game.item.Cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;

/**
 * Public class HealerCure
 * This is the best cure
 * Only the healer can use it
 * It restores 90 pts
 */
public class HealerCure extends Cure {

    public HealerCure() {
        super("HealerCure", 200, 0, 90);
    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

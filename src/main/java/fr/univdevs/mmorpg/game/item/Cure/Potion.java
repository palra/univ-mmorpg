package fr.univdevs.mmorpg.game.item.Cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;

/**
 * Potion class
 * A potion restore 10 hp
 */
public class Potion extends Cure {

    public Potion() {
        super("Potion", 10, 10);
    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

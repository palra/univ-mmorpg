package fr.univdevs.mmorpg.game.item.Cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;

/**
 * HyperPotion class
 * An hyperpotion restore 50 hp
 */
public class HyperPotion extends Cure {

    public HyperPotion() {
        super("Potion", 10, 10);
    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

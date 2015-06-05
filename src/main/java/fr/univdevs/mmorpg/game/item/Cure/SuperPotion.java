package fr.univdevs.mmorpg.game.item.Cure;

import fr.univdevs.mmorpg.engine.character.item.Cure;

/**
 * SuperPotion class
 * A superpotion restore 20 hp
 */
public class SuperPotion extends Cure {

    public SuperPotion() {
        super("SuperPotion", 20, 20);
    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

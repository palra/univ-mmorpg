package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.item.Weapon;

/**
 * Public class Sword
 * A sword is a weapon
 * Has a power of 11 points
 */
public class Sword extends Weapon {

    public Sword() {
        super("Sword", 100, 100, 11);
    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

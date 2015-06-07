package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Public class Sword
 * A sword is a weapon
 * Has a power of 11 points
 */
public class Sword extends Weapon {

    public Sword() {
        super("Sword", 100, 100, 11);
    }

    public ANSIChar getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }

    @Override
    public void onRegister(fr.univdevs.mmorpg.engine.character.Character character) {

    }

    @Override
    public void onUnregister(Character character) {

    }
}

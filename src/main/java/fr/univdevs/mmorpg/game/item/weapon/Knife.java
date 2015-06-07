package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.item.Weapon;

/**
 * Public class Knife
 * a knife has a power of 4 points
 */
public class Knife extends Weapon {

    public Knife() {
        super("Knife", 30, 30, 4);
    }

    public String getDisplay() {
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

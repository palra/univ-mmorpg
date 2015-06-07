package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
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


    @Override
    public void onRegister(Character character) {

    }

    @Override
    public void onUnregister(Character character) {

    }
}

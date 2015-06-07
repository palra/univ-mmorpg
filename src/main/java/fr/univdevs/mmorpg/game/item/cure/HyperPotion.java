package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
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

    @Override
    public void onRegister(fr.univdevs.mmorpg.engine.character.Character character) {

    }

    @Override
    public void onUnregister(Character character) {

    }
}

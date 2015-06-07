package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
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

    @Override
    public void onRegister(fr.univdevs.mmorpg.engine.character.Character character) {

    }

    @Override
    public void onUnregister(Character character) {

    }
}

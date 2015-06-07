package fr.univdevs.mmorpg.game.item.cure;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
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

    @Override
    public void onRegister(fr.univdevs.mmorpg.engine.character.Character character) {

    }

    @Override
    public void onUnregister(Character character) {

    }
}

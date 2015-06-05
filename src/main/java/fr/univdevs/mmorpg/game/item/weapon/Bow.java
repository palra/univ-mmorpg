package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.item.Weapon;

/**
 * Class Bow
 * A Bow
 */
public class Bow extends Weapon {
    public Bow(String bowCategory, int bowCost, int bowWeight) {
        super(bowCategory, bowCost, bowWeight, 20);
    }

    @Override
    public void onRegister(Character character) {
    }

    @Override
    public void onUnregister(Character character) {
    }

    public String getDisplay() {
        return "↗";
    }

    public boolean isCollidable() {
        return false;
    }
}

package fr.univdevs.mmorpg.game.item.weapon;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Class Bow
 * A Bow has a power of 20 points
 */
public class Bow extends Weapon {


    public Bow() {
        super("Bow", 150, 150, 20);
    }

    @Override
    public void onRegister(Character character) {
    }

    @Override
    public void onUnregister(Character character) {
    }

    public ANSIChar getDisplay() {
        return new ANSIChar('↗');
    }

    public boolean isCollidable() {
        return false;
    }
}

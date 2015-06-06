package fr.univdevs.mmorpg.game.character;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.util.Vector2D;

/**
 * Created by drattak on 23/05/15.
 * TODO : document
 */
public class Warrior extends Character {
    private String[] canUse = {"Knife", "Bow", "Sword", "HyperPotion", "Potion", "SuperPotion"};

    public Warrior(String name) {
        super(name, "Warrior");
    }

    @Override
    public String[] getCanUse() {
        return canUse;
    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return true;
    }

    public Vector2D getPosition() {
        return null;
    }
}

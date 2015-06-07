package fr.univdevs.mmorpg.game.character;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.game.item.weapon.Knife;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * Public class Healer
 * A healer has the ability to heal someone more easily than a warrior
 * But he can only use knife to fight
 */
public class Healer extends Character {
    private String[] canUse = {"Knife", "HealerCure", "HyperPotion", "Potion", "SuperPotion"};

    /**
     * Character constructor
     *
     * @param chosenName Name chosen for the character, can't change
     */
    public Healer(String chosenName, Player chosenPlayer) {
        super(chosenName, "Healer", chosenPlayer);
    }

    public Healer(String chosenName) {
        super(chosenName, "Healer");
    }

    public ANSIChar getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return true;
    }

    public String[] getCanUse() {
        return canUse;
    }
}

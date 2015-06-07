package fr.univdevs.mmorpg.game.character;

import fr.univdevs.mmorpg.engine.character.Character;

/**
 * Public class Healer
 * A healer has the ability to heal someone more easily than a warrior
 * But he can only use knife to fight
 */
public class Healer extends Character {
    /**
     * Character constructor
     *
     * @param chosenName Name chosen for the character, can't change
     */
    public Healer(String chosenName) {
        super(chosenName, "Healer");
    }
}

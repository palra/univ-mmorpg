package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;

/**
 * Public class player
 * Represets the human player
 */
public class Player {
    private String name;
    private Character character = null;


    public Player(String chosenName) {
        this.name = chosenName;
    }

    protected String getName() {
        return this.name;
    }

    public Character getCharacter() {
        return this.character;
    }

    public Character setCharacter(Character chosenCharacter) throws Exception {
        if (this.character != null) throw new Exception("Vous possédez déjà un personnage");
        this.character = chosenCharacter;
        return chosenCharacter;
    }


}

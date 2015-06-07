package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.character.Character;

import java.util.Comparator;

/**
 * Public class player
 * Represets the human player
 */
public class Player {
    private String name;
    private Character character = null;
    /**
     * Compares two players according to their character's speed. The greatest speed is the greatest player.
     */
    public static Comparator<Player> SORT_BY_SPEED_DESC = new Comparator<Player>() {
        public int compare(Player p1, Player p2) {
            return -Double.compare(p1.getCharacter().getSpeed(), p2.getCharacter().getSpeed());
        }
    };
    private Action action = null;

    /**
     * Player Constructor
     * A player represents the human
     *
     * @param chosenName the name we want to give to the player
     */
    public Player(String chosenName) {
        this.name = chosenName;
    }

    /**
     * Player Constructor
     * A player represents the human
     *
     * @param chosenName the name we want to give to the player
     * @param character The character associated to the player
     */
    public Player(String chosenName, Character character) {
        this(chosenName);
        this.character = character;
    }


    /**
     * Protected method to get the name of the player
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of the Character
     * @return the character
     */
    public Character getCharacter() {
        return this.character;
    }

    /**
     * Setter of the Character
     * @param chosenCharacter   the character we want to set
     * @return the chosen character
     * @throws Exception    if the player already has a character
     */
    public Character setCharacter(Character chosenCharacter) throws Exception {
        if (this.character != null) throw new Exception("Vous possédez déjà un personnage");
        this.character = chosenCharacter;
        return chosenCharacter;
    }

    /**
     * Setter of action
     * @param chosenAction  the action we want to set
     * @return the same action
     */
    public Action setNextAction(Action chosenAction) {
        this.action = chosenAction;
        return chosenAction;
    }

    /**
     * Getter of Action
     * @return the next action
     */
    public Action getNextAction() {
        return this.action;
    }

}

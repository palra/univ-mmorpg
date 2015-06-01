package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.action.Action;
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
     * Compares two players according to their speed. The greatest speed makes the greatest player.
     */
    public static Comparator<Player> SORT_BY_SPEED_DESC = new Comparator<Player>() {
        /**
         * Compares two players according to their speed.
         * @param p1 The first player
         * @param p2 The second player
         * @return -1 if the first player has a lower speed than the second, 1 if he has a greater speed that the other, 0 if equals.
         */
        public int compare(Player p1, Player p2) {
            return -Integer.compare(p1.getCharacter().getSpeed(), p2.getCharacter().getSpeed());
        }
    };
    private Action action; // TODO : rename to nextAction

    /**
     * Creates a new player.
     *
     * @param name The name of the player
     * @param c    The character played by the player.
     */
    public Player(String name, Character c) {
        this.name = name;
        this.character = c;
    }

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
        if (this.character != null)
            throw new Exception("Vous possédez déjà un personnage"); // TODO : why throwing an exception ?
        // TODO : check that chosenCharacter is not null, otherwise, do nothing.
        this.character = chosenCharacter;
        return chosenCharacter; // TODO : a setter returns void
    }

    public Action setNextAction(Action chosenAction) {
        this.action = chosenAction;
        return chosenAction; // TODO : a setter returns void
    }

    public Action getNextAction() {
        return this.action;
    }

}

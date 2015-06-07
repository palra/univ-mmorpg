package fr.univdevs.mmorpg.bridge;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;

/**
 * Base command that creates an action.
 * It is statically bound to a single player, it means that the command must not be used twice for a same action, or for
 * different players (it is impossible anyway).
 *
 * @author Loïc Payol
 */
public abstract class ActionCommand<T extends Action> extends GameManagerAwareCommand {
    private T action = null;
    private Player currentPlayer;

    /**
     * Default constructor
     *
     * @param currentPlayer The current player, subject of the action.
     */
    public ActionCommand(Player currentPlayer) {
        if (currentPlayer == null)
            throw new NullPointerException("The current player can't be null");

        this.currentPlayer = currentPlayer;
    }

    /**
     * Returns the newly built action, if already built
     *
     * @return The action, if built, null instead
     */
    public T getAction() {
        return action;
    }

    /**
     * Sets the new action
     *
     * @param action The action
     */
    public void setAction(T action) {
        this.action = action;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}

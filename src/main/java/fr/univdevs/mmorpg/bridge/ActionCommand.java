package fr.univdevs.mmorpg.bridge;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.action.Action;

/**
 * Base command that creates an action.
 * It is statically bound to a single player, it means that the command must not be used twice for a same action, or for
 * different players (it is impossible anyway).
 *
 * @author Loïc Payol
 */
public abstract class ActionCommand extends GameManagerAwareCommand {
    private Player currentPlayer;

    /**
     * Default constructor
     */
    public ActionCommand() {

    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player p) {
        if (p == null)
            throw new NullPointerException("The current player can't be null");

        this.currentPlayer = p;
    }

    public boolean hasCurrentPlayer() {
        return this.getCurrentPlayer() != null;
    }

    /**
     * Returns the newly built action, if already built
     *
     * @return The action, if built, null instead
     */
    public Action getNextAction() {
        return this.hasCurrentPlayer() ? this.getCurrentPlayer().getNextAction() : null;
    }

    /**
     * Sets the new action to the currentPlayer
     *
     * @param action The action
     */
    public void setNextAction(Action action) {
        if (!this.hasCurrentPlayer())
            throw new NullPointerException("The current player is null");

        this.currentPlayer.setNextAction(action);
    }

    /**
     * Returns true if an action was built, false otherwise.
     *
     * @return action != null
     */
    public boolean hasAction() {
        return this.getNextAction() != null;
    }
}

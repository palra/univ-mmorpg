package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.action.NoOpAction;

/**
 * Command that makes a player pass its turn
 *
 * @author Loïc Payol
 */
public class NoOpCommand extends ActionCommand {
    private static final String NAME = "noop";

    public NoOpCommand() {
        this.setName(NAME);
    }

    @Override
    public String execute(String[] args) throws CommandException {
        NoOpAction action = new NoOpAction(this.getCurrentPlayer());
        action.setGameManager(this.getGameManager());
        this.setNextAction(action);
        return null;
    }

    @Override
    public String getSynopsis() {
        return null;
    }
}

package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.ArgumentValidationCommandException;
import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.action.MoveAction;
import fr.univdevs.mmorpg.engine.world.World;

/**
 * Command that moves a player's character on the world.
 * As for ActionCommand, you must instanciate this command each play turn.
 *
 * @author Loïc Payol
 */
public class MoveCommand extends ActionCommand {
    public MoveCommand() {
        this.setName("move");
    }

    @Override
    public String execute(String[] args) throws CommandException {
        if (args.length != 2)
            throw new ArgumentValidationCommandException("Invalid number of arguments");

        World.Direction dir = World.Direction.valueOf(args[0].toUpperCase());
        int nbCases = Integer.parseInt(args[1]);

        MoveAction action = new MoveAction(this.getCurrentPlayer(), null, dir, nbCases);
        action.setGameManager(this.getGameManager());
        this.setNextAction(action);

        return null;
    }

    @Override
    public String getSynopsis() {
        return "{left|right|up|down} <nb_cases>";
    }
}

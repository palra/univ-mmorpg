package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.bridge.ActionCommand;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.World;

/**
 * Command that moves a player's character on the world.
 * As for ActionCommand, you must instanciate this command each play turn.
 *
 * @author Loïc Payol
 */
public class MoveCommand extends ActionCommand<MoveAction> {
    public MoveCommand(Player currentPlayer) {
        super(currentPlayer);
        this.setName("move");
    }

    @Override
    public String execute(String[] args) throws Exception {
        if (args.length != 2)
            throw new IllegalArgumentException("Invalid number of arguments");

        World.Direction dir = World.Direction.valueOf(args[0].toUpperCase());
        int nbCases = Integer.parseInt(args[1]);

        MoveAction action = new MoveAction(this.getCurrentPlayer(), null, dir, nbCases);
        action.setGameManager(this.getGameManager());
        action.execute();
        this.setAction(action);

        if (getCommandParser().has("map"))
            return getCommandParser().parse("map").getOutput();

        return null;
    }

    @Override
    public String getSynopsis() {
        return "{left|right|up|down} <nb_cases>";
    }
}

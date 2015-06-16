package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.ArgumentValidationCommandException;
import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.action.DropAction;
import fr.univdevs.mmorpg.engine.character.Item;

/**
 * Command that moves a player's character on the world.
 *
 * @author Loïc Payol
 */
public class DropCommand extends ActionCommand {
    public DropCommand() {
        this.setName("drop");
    }

    @Override
    public String execute(String[] args) throws CommandException {
        if (args.length != 1)
            throw new ArgumentValidationCommandException("Invalid number of arguments");

        DropAction action;
        Item itemToRemove = this.getCurrentPlayer().getCharacter().getInventory().getById(args[0]);
        try {
            action = new DropAction(this.getCurrentPlayer(), itemToRemove);
            action.setGameManager(this.getGameManager());
            this.setNextAction(action);
        } catch (DropAction.NotInInventoryException e) {
            System.out.println("The item is not in the inventory");
        }

        return null;
    }

    @Override
    public String getSynopsis() {
        return "<id_item>";
    }
}

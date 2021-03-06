package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.ArgumentValidationCommandException;
import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.action.FightAction;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.util.Strings;

/**
 * Command that moves a player's character on the world.
 *
 * @author Loïc Payol
 */
public class FightCommand extends ActionCommand {
    public FightCommand() {
        this.setName("fight");
    }

    @Override
    public String execute(String[] args) throws CommandException {
        if (args.length != 2)
            throw new ArgumentValidationCommandException("Invalid number of arguments");


        Player target = this.getGameManager().getPlayerByName(Strings.toCamelCase(args[0]));
        String id = args[1];

        if (this.getCurrentPlayer().getCharacter().getInventory().getById(id) instanceof Weapon) {
            FightAction action = new FightAction(this.getCurrentPlayer(), target, (Weapon) this.getCurrentPlayer().getCharacter().getInventory().getById(id));
            action.setGameManager(this.getGameManager());
            this.setNextAction(action);
        } else throw new ArgumentValidationCommandException("Not a valid weapon");

        return null;
    }

    @Override
    public String getSynopsis() {
        return "<target> <id>";
    }
}
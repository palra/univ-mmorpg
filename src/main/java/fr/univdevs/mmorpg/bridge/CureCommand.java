package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.ArgumentValidationCommandException;
import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.action.CureAction;
import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.mmorpg.game.item.cure.Potion;
import fr.univdevs.util.Strings;

/**
 * Command that moves a player's character on the world.
 *
 * @author Loïc Payol
 */
public class CureCommand extends ActionCommand {
    public CureCommand() {
        this.setName("cure");
    }

    @Override
    public String execute(String[] args) throws CommandException {
        if (args.length != 2)
            throw new ArgumentValidationCommandException("Invalid number of arguments");


        Player target = this.getGameManager().getPlayerByName(Strings.toCamelCase(args[0]));
        String id = args[1];
        Cure c = new Potion();

        if (this.getCurrentPlayer().getCharacter().getInventory().getById(id) instanceof Cure) {

            CureAction action = null;
            try {
                action = new CureAction(this.getCurrentPlayer(), target, (Cure) this.getCurrentPlayer().getCharacter().getInventory().getById(id));
            } catch (CureAction.NotInInventoryException e) {
                throw new ArgumentValidationCommandException("Objet non présent dans l'inventaire");
            }
            action.setGameManager(this.getGameManager());
            this.setNextAction(action);
        } else throw new ArgumentValidationCommandException("Vous avez entré une cure invalide");
        return null;
    }

    @Override
    public String getSynopsis() {
        return "<target><id>";
    }
}
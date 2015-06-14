package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.ArgumentValidationCommandException;
import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

/**
 * Command that manipulates a player's inventory.
 * <p/>
 * Synopsis:
 * items [{list|drop <id>}]
 * <p/>
 * Default task is `list`
 *
 * @author Loïc Payol
 */
public class InventoryCommand extends Command {
    private static final String LIST_OP = "list";
    private static final String USE_OP = "use";
    private static final String DROP_OP = "drop";

    private Player currentPlayer = null;

    public InventoryCommand() {
        this.setName("items");
    }

    public static String describe(Item i) {
        return i.getDisplay() + " : " + new ANSIString(i.getType(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_BOLD) +
            " (" + new ANSIString(i.getID(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_UNDERSCORE) + ") : " +
            i.getCost() + "£, " + i.getWeight() + "g";
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        if (currentPlayer == null)
            throw new NullPointerException("The given current player is null");

        if (currentPlayer.getCharacter() == null)
            throw new NullPointerException("The player `" + currentPlayer.getName() + "` is not binded to a character");

        this.currentPlayer = currentPlayer;
    }

    @Override
    public String execute(String[] args) throws CommandException {
        if (args.length > 2)
            throw new ArgumentValidationCommandException("Invalid number of arguments");

        this.setCurrentPlayer(this.currentPlayer); // Do checks

        Character c = this.currentPlayer.getCharacter();
        if (c == null)
            throw new NullPointerException("The player `" + this.currentPlayer.getName() + "` is not binded to a character");

        String operand = args.length == 0 ? LIST_OP : args[0];
        if (operand.equals(LIST_OP)) {
            String out = "Inventory of " + new ANSIString(c.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + "\n" +
                "-----------------------------\n";

            Item[] items = c.getInventory().getItems();
            if (items.length == 0)
                out += "No items in your inventory\n";

            for (Item i : items) {
                out += " " + describe(i) + "\n";
            }

            return out;
        }

        throw new ArgumentValidationCommandException("Invalid operand");
    }

    @Override
    public String getSynopsis() {
        return "[{list|drop <id>}]";
    }
}

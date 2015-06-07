package fr.univdevs.mmorpg.bridge;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

/**
 * Command displaying stats of a given
 * <p/>
 * Synopsis :
 *    stats [<player_name>]
 *
 * @author Loïc Payol
 */
public class StatsCommand extends GameManagerAwareCommand {
    private Player currentPlayer = null;

    public StatsCommand() {
        this.setName("stats");
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String execute(String[] args) throws Exception {
        String playerName = null;
        if (args.length == 1)
            playerName = args[0];
        else if (args.length > 1)
            throw new IllegalStateException("This command only accepts zero or one argument.");

        Player p;

        if (playerName != null) {
            p = this.getGameManager().getPlayerByName(playerName);
            if (p == null) {
                throw new PlayerNotFoundException("The player " + playerName + " does not exists.");
            }
        } else {
            p = currentPlayer;
        }

        if (p == null) {
            throw new NullPointerException("The given current player is null");
        }

        Character c = p.getCharacter();
        if (c == null) {
            throw new NullPointerException("The player `" + playerName + "` is not binded to a character");
        }

        return "Stats for player `" + new ANSIString(p.getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) +
            "` : \n-----------------------------\n" +
            " - Type : " + c.getType() + "\n" +
            " - Vie : " + c.getHealth() + " HP\n" +
            " - Experience : " + c.getExperience() + " XP \n" +
            " - Points d'action : " + c.getActionPoints() + " AP \n" +
            " - Vitesse : " + c.getSpeed() + "\n" +
            " - Résistance : " + c.getResistance() * 100 + "\n" +
            " - Argent : " + c.getMoney() + "£ \n";
    }

    @Override
    public String getSynopsis() {
        return "<player_name>";
    }

    /**
     * Exception thrown when a given player name is not found.
     *
     * @author Loïc Payol
     */
    public static class PlayerNotFoundException extends IllegalArgumentException {
        public PlayerNotFoundException(String message) {
            super(message);
        }
    }
}

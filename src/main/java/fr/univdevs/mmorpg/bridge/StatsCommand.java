package fr.univdevs.mmorpg.bridge;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;

/**
 * Command displaying stats of a given
 * <p/>
 * Synopsis :
 */
public class StatsCommand extends GameManagerAwareCommand {
    private String currentPlayerName = null;

    public StatsCommand() {
        this.setName("stats");
    }

    public String getCurrentPlayerName() {
        return currentPlayerName;
    }

    public void setCurrentPlayerName(String currentPlayerName) {
        this.currentPlayerName = currentPlayerName;
    }

    @Override
    public String execute(String[] args) throws Exception {
        String playerName = currentPlayerName;
        if (args.length == 1)
            playerName = args[0];
        else if (args.length > 1)
            throw new IllegalStateException("This command only accepts zero or one argument.");

        Player p = this.getGameManager().getPlayerByName(playerName);
        if (p == null) {
            if (playerName.equals(currentPlayerName)) {
                throw new IllegalArgumentException("The name of the current player is invalid.");
            } else {
                throw new PlayerNotFoundException("The player " + playerName + " does not exists.");
            }
        }

        Character c = p.getCharacter();
        if (c == null) {
            return "The player `" + playerName + "` is not binded to a character\n";
        }

        return "Stats for player `" + playerName + "` : \n" +
            "-----------------------------\n" +
            " - Type : " + c.getType() + "\n" +
            " - Vie : " + c.getHealth() + " HP\n" +
            " - Experience : " + c.getExperience() + " XP \n" +
            " - action Points : " + c.getActionPoints() + " AP \n" +
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
    public static class PlayerNotFoundException extends Exception {
        public PlayerNotFoundException(String message) {
            super(message);
        }
    }
}

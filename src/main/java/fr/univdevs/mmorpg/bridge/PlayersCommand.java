package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.List;

/**
 * Command that dumps all the players in the game manager
 *
 * @author Loïc Payol
 */
public class PlayersCommand extends GameManagerAwareCommand {
    public PlayersCommand() {
        this.setName("players");
    }

    @Override
    public String execute(String[] args) throws CommandException {
        List<Player> players = this.getGameManager().getPlayers();
        if (players.isEmpty())
            return new ANSIString("No players are registered in the game", ANSIAttribute.FG_RED) + "";

        String out = "";
        for (Player p : players) {
            out += p.getName() + "\n";
        }

        return out;
    }

    @Override
    public String getSynopsis() {
        return "";
    }
}

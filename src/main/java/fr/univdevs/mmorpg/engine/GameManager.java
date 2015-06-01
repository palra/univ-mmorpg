package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.world.World;

import java.util.*;

/**
 * Manages a game instance.
 */
public class GameManager {
    private World world = new World();
    private Map<String, Player> players = new HashMap<String, Player>();
    private Comparator<Player> playerComparator = Player.SORT_BY_SPEED_DESC;

    /**
     * Empty constructor
     */
    public GameManager() {

    }

    /**
     * Returns an array of all the registered players.
     *
     * @return The registrered players
     */
    public Player[] getPlayers() {
        return players.values().toArray(new Player[players.size()]);
    }

    /**
     * Returns an instance of the requested player, if exists.
     *
     * @param name The name of the player
     * @return The player if exists, null otherwise
     */
    public Player getPlayerByName(String name) {
        return this.players.get(name);
    }

    /**
     * Registers a new player
     *
     * @param player The new player
     * @return The old player with the same name, if exists, null otherwise
     */
    public Player addPlayer(Player player) {
        return this.players.put(player.getName(), player);
    }


    /**
     * Sets the player comparator, in order to change priority of a player on another.
     *
     * @param comparator The comparator object
     */
    public void setPlayerComparator(Comparator<Player> comparator) {
        this.playerComparator = comparator;
    }

    /**
     * Plays a turn of the game. Each player has a nextAction field, so the GameManager will look if an action is
     * registered for each player, will order the actions with a given strategy, and then will execute each action in the
     * computed order. To see what's new, checkout the GameLog.
     */
    public void playTurn() throws Exception {
        List<Player> pls = new ArrayList<Player>(this.players.values());
        Collections.sort(pls, this.playerComparator);
        // TODO : finish that
    }


    public World getWorld() {
        return world;
    }
}

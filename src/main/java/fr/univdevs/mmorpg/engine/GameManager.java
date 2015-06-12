package fr.univdevs.mmorpg.engine;

import fr.univdevs.logger.Logger;
import fr.univdevs.logger.LoggerInterface;
import fr.univdevs.mmorpg.engine.action.Action;
import fr.univdevs.mmorpg.engine.event.game.RoundEndEvent;
import fr.univdevs.mmorpg.engine.event.game.RoundStartEvent;
import fr.univdevs.mmorpg.engine.event.game.TurnStartEvent;
import fr.univdevs.mmorpg.engine.world.World;

import java.util.*;

/**
 * Manages a game instance.
 */
public class GameManager {
    private World world;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Comparator<Player> playerComparator = Player.SORT_BY_SPEED_DESC;
    private LoggerInterface logger = new Logger();
    private int roundNb = 1;

    /**
     * Empty constructor
     */
    public GameManager(World world) {
        this.world = world;
    }

    public GameManager(GameManager other) {
        this.world = new World(other.world);
        this.players = new ArrayList<Player>(other.players);
        this.playerComparator = other.playerComparator;
        this.logger = other.logger;
        this.roundNb = other.roundNb;
    }


    /**
     * Returns an array of all the registered players.
     *
     * @return The registrered players
     */
    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * Returns an instance of the requested player, if exists.
     *
     * @param name The name of the player
     * @return The player if exists, null otherwise
     */
    public Player getPlayerByName(String name) {
        ListIterator<Player> it = this.players.listIterator();
        Player player = null;
        while (it.hasNext()) {
            Player next = it.next();
            if (next.getName().equals(name))
                player = next;
        }

        return player;
    }

    /**
     * Registers a new player
     *
     * @param player The new player
     * @return true
     * @throws IllegalArgumentException if another player has the same name
     */
    public boolean addPlayer(Player player) {
        if (this.hasPlayerWithSameName(player))
            throw new IllegalArgumentException("A player with the same name exists");

        return this.players.add(player);
    }

    /**
     * Returns if there is a player with the same name in the collection.
     *
     * @param player The player to check
     * @return true if a player with the same name was found, false otherwise
     */
    public boolean hasPlayerWithSameName(Player player) {
        return this.hasPlayerWithSameName(player.getName());
    }


    /**
     * Returns if there is a player with the same name in the collection.
     *
     * @param name The name to check
     * @return true if a player with the same name was found, false otherwise
     */
    public boolean hasPlayerWithSameName(String name) {
        ListIterator<Player> it = this.players.listIterator();
        boolean hasSameName = false;
        while (it.hasNext() && !hasSameName) {
            Player p = it.next();
            if (p.getName().equals(name))
                hasSameName = true;
        }

        return hasSameName;
    }

    /**
     * Returns the current player comparator
     *
     * @return The current player comparator
     */
    public Comparator<Player> getPlayerComparator() {
        return this.playerComparator;
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
     * Returns the event logger.
     *
     * @return The event logger.
     */
    public LoggerInterface getLogger() {
        return this.logger;
    }

    /**
     * Plays a turn of the game. Each player has a nextAction field, so the GameManager will look if an action is
     * registered for each player, will order the actions with a given strategy, and then will execute each action in the
     * computed order.
     * To see which actions were done, see the GameLog.
     */
    public void playTurn() {
        getLogger().log(new RoundStartEvent(this.roundNb));
        Collections.sort(this.players, this.playerComparator);

        // Loading all the actions
        List<Action> actions = new ArrayList<Action>();
        for (Player p : this.players) {
            Action a = p.getNextAction();
            if (a == null)
                throw new IllegalStateException("action of player " + p.getName() + " was not registered.");

            actions.add(a);
            p.setNextAction(null);
        }

        // And executing them
        for (Action a : actions) {
            this.getLogger().log(new TurnStartEvent(this, a.getSubject()));
            a.setGameManager(this); // Injecting the logger
            a.execute(); // Executing the action
        }

        getLogger().log(new RoundEndEvent(this.roundNb));
        this.roundNb++;
    }

    public World getWorld() {
        return this.world;
    }

}

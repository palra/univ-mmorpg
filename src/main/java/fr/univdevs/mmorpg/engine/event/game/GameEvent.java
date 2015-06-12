package fr.univdevs.mmorpg.engine.event.game;

import fr.univdevs.logger.Event;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.GameManagerAware;

import java.util.Date;

/**
 * Events that reports an information about a given game
 *
 * @author Loïc Payol
 */
public abstract class GameEvent extends Event implements GameManagerAware {
    protected static final String TOPIC = "action";
    private GameManager gameManager;

    /**
     * Constructs an ActionEvent
     *
     * @param name        The name of the event
     * @param gameManager The game manager
     */
    public GameEvent(String name, GameManager gameManager) {
        super(TOPIC, name);
        this.setGameManager(gameManager);
    }

    /**
     * Constructs an ActionEvent
     *
     * @param name        The name of the event
     * @param date        The date of the event
     * @param gameManager The gameManager of the action, non nullable
     */
    public GameEvent(String name, Date date, GameManager gameManager) {
        super(TOPIC, name, date);
        this.setGameManager(gameManager);
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        if (gameManager == null)
            throw new NullPointerException("The game manager cannot be null");
        this.gameManager = gameManager;
    }
}

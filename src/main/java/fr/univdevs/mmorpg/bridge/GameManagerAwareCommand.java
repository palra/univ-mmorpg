package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.GameManagerAware;

/**
 * Super class for GameManager aware commands.
 *
 * @author Loic Payol
 */
public abstract class GameManagerAwareCommand extends Command implements GameManagerAware {
    private GameManager gameManager;

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
}

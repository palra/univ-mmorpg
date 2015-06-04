package fr.univdevs.mmorpg.engine;

/**
 * Interface representing the awareness of the implementing classes of a GameManager
 *
 * @auhtor Loïc Payol
 */
public interface GameManagerAware {
    void setGameManager(GameManager gameManager);
}

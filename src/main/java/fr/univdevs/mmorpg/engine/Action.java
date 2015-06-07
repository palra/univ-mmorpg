package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.logger.Logger;

/**
 * Public class action
 * An action is any thing that can do the character
 * The action is done by a subject to a target
 */
public abstract class Action implements GameManagerAware {
    private Player subject;
    private Player target;
    private GameManager gameManager;

    /**
     * action constructor
     *  @param chosenSubject the Character who execute the action
     * @param chosenTarget  the Character targeted
     */
    public Action(Player chosenSubject, Player chosenTarget) {
        if (chosenSubject == null)
            throw new NullPointerException("The subject can't be null");

        this.subject = chosenSubject;
        this.target = chosenTarget;
    }

    /**
     * Public method to return the target of the action
     *
     * @return the target
     */
    public Player getTarget() {
        return this.target;
    }

    /**
     * Public method to return the subject of the action
     *
     * @return the subject
     */
    public Player getSubject() {
        return this.subject;
    }


    /**
     * Returns the logger, shortcut for {@link GameManager#getLogger()}
     * @return The logger
     */
    public Logger getLogger() {
        return gameManager.getLogger();
    }

    /**
     * Returns the game manager
     * @return The game manager
     */
    public GameManager getGameManager() {
        return gameManager;
    }

    /**
     * {@inheritDoc}
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Abstract method to execute the action
     * Will describe the impact of the action on the targert
     */
    public abstract void execute() throws Exception;
}

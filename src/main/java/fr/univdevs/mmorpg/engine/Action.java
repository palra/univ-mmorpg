package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.LoggerAwareInterface;

/**
 * Public class Action
 * An action is any thing that can do the character
 * The action is done by a subject to a target
 */
public abstract class Action implements LoggerAwareInterface {
    private Player subject;
    private Player target;
    private Logger logger;

    /**
     * Action constructor
     *  @param chosenSubject the Character who execute the action
     * @param chosenTarget  the Character targeted
     */
    public Action(Player chosenSubject, Player chosenTarget) {
        this.subject = chosenSubject;
        this.target = chosenTarget;
    }

    /**
     * Public method to return the target of the Action
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
     * Returns the logger.
     * @return The logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * {@inheritDoc}
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Abstract method to execute the action
     * Will describe the impact of the action on the targert
     */
    public abstract void execute() throws Exception;
}

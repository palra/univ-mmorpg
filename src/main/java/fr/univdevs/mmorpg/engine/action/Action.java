package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.Player;

/**
 * Public class Action
 * An action is any thing that can do the character
 * The action is done by a subject to a target
 */
public abstract class Action {
    private Player subject;
    private Player target;

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
     * Abstract method to execute the action
     * Will describe the impact of the action on the targert
     *
     * @return the Action executed
     */
    public abstract ActionResult execute() throws Exception;

    public String toString() {
        return "Cible = " + this.target.getName() + '\n' + "Acteur = " + this.subject.getName() + '\n';
    }
}

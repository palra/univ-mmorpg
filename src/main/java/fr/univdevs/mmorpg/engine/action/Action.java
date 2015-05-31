package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.action.ActionResult;

/**
 * Public class Action
 * An action is any thing that can do the character
 * The action is done by a subject to a target
 */
public abstract class Action {
    private Character subject;
    private Character target;

    /**
     * Action constructor
     *
     * @param chosenSubject the Character who execute the action
     * @param chosenTarget  the Character targeted
     */
    public Action(Character chosenSubject, Character chosenTarget) {
        this.subject = chosenSubject;
        this.target = chosenTarget;
    }

    /**
     * Public method to return the target of the Action
     *
     * @return the target
     */
    public Character getTarget() {
        return this.target;
    }

    /**
     * Public method to return the subject of the action
     *
     * @return the subject
     */
    public Character getSubject() {
        return this.subject;
    }

    /**
     * Abstract method to execute the action
     * Will describe the impact of the action on the targert
     *
     * @return the Action executed
     */
    public abstract ActionResult execute() throws Exception;

    /**
     * Redefinition of toString
     *
     * @return the generated String
     */
    public String toString() {
        return "Cible = " + this.target.getName() + '\n' + "Acteur = " + this.subject.getName() + '\n';
    }
}

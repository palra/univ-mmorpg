package fr.univdevs.mmorpg.engine.event.action;


import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.mmorpg.engine.Player;

import java.util.Date;

/**
 * Events that reports an information about an action
 *
 * @author Vincent Emile
 */

public abstract class ActionEvent extends Event {
    private static String TOPIC = "action";
    private Player subject;
    private Player target;

    /**
     * Constructs an ActionEvent
     *
     * @param name    The name of the event
     * @param subject The subject of the action, non nullable, but the constructor will not throw an exception for that
     * @param target  The target of the action, nullable
     */
    public ActionEvent(String name, Player subject, Player target) {
        super(TOPIC, name);
        this.subject = subject;
        this.target = target;
    }

    /**
     * Constructs an ActionEvent
     *
     * @param name    The name of the event
     * @param date    The date of the event
     * @param subject The subject of the action, non nullable
     * @param target  The target of the action, nullable
     */
    public ActionEvent(String name, Date date, Player subject, Player target) {
        super(TOPIC, name, date);
        this.subject = subject;
        this.target = target;
    }

    public ActionEvent(ActionEvent other) {
        super(other);
        this.subject = other.subject;
        this.target = other.target;
    }


    /**
     * public getter for Subject
     *
     * @return the subject of the event
     */
    public Player getSubject() {
        return this.subject;
    }

    /**
     * public getter for Target
     *
     * @return the target of the event
     */
    public Player getTarget() {
        return this.target;
    }
}

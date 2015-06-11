package fr.univdevs.logger;

import fr.univdevs.mmorpg.engine.Player;

import java.util.Date;

/**
 * Events that reports an information about a given subject
 *
 * @author Vincent Emile
 */

public abstract class ActionEvent extends Event {
    private Player subject;
    private Player target;

    /**
     * ActionEvent Constructor
     * ActionEvent records an Action in the Log
     *
     * @param topic   the topic of the action
     * @param name    the name, cure if it's a CureAction, etc
     * @param subject the one who perform the action
     * @param target  the one who undergoes the action
     */
    public ActionEvent(String topic, String name, Player subject, Player target) {
        super(topic, name);
        this.subject = subject;
        this.target = target;
    }

    /**
     * ActionEvent Constructor
     * An ActionEvent records an Action in the Log
     * @param topic the topic of the action
     * @param name  the name, cure if it's a CureAction, etc
     * @param date  the date of the action
     * @param subject   the one who perform the action
     * @param target    the one who undergoes the action
     */
    public ActionEvent(String topic, String name, Date date, Player subject, Player target) {
        super(topic, name, date);
        this.subject = subject;
        this.target = target;
    }

    /**
     * ActionEvent copy constructor
     * An ActionEvent records an Action in the Log
     * @param other the ActionEvent to copy
     */
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

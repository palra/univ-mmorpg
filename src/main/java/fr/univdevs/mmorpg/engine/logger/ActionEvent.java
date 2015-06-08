package fr.univdevs.mmorpg.engine.logger;

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

    public ActionEvent(String topic, String name, Player subject, Player target) {
        super(topic, name);
        this.subject = subject;
        this.target = target;
    }

    public ActionEvent(String topic, String name, Date date, Player subject, Player target) {
        super(topic, name, date);
        this.subject = subject;
        this.target = target;
    }

    /**
     * public getter for Subject
     *
     * @return the subject of the event
     */
    public Player getSubject() {
        return subject;
    }

    /**
     * public getter for Target
     *
     * @return the target of the event
     */
    public Player getTarget() {
        return target;
    }
}

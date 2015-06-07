package fr.univdevs.mmorpg.engine.logger;

import java.util.Date;

/**
 * Events that reports an information about a given subject
 *
 * @author Vincent Emile
 */

public abstract class ActionEvent<T> extends Event {
    private T subject;
    private T target;

    public ActionEvent(String topic, String name, T subject, T target) {
        super(topic, name);
        this.subject = subject;
        this.target = target;
    }

    public ActionEvent(String topic, String name, Date date, T subject, T target) {
        super(topic, name, date);
        this.subject = subject;
        this.target = target;
    }

    /**
     * public getter for Subject
     *
     * @return the subject of the event
     */
    public T getSubject() {
        return subject;
    }

    /**
     * public getter for Target
     *
     * @return the target of the event
     */
    public T getTarget() {
        return target;
    }
}

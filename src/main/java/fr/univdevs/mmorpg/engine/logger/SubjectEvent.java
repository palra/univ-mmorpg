package fr.univdevs.mmorpg.engine.logger;

import java.util.Date;

/**
 * Events that reports an information about a given subject
 *
 * @author Loïc Payol
 */
public abstract class SubjectEvent<T> extends Event {
    private T subject;

    public SubjectEvent(String topic, String name, T subject) {
        super(topic, name);
        this.subject = subject;
    }

    public SubjectEvent(String topic, String name, Date date, T subject) {
        super(topic, name, date);
        this.subject = subject;
    }

    public SubjectEvent(SubjectEvent<T> other) {
        super(other);
        this.subject = other.subject;
    }


    /**
     * Returns the subject of the event
     *
     * @return The subject of the event
     */
    public T getSubject() {
        return subject;
    }
}

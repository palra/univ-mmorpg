package fr.univdevs.mmorpg.engine.logger;

import java.util.Comparator;
import java.util.Date;

/**
 * Represents an event in the game
 */
public abstract class Event {
    /**
     * Compares two events according to their creation date. The newer is the first.
     */
    public static Comparator<Event> SORT_BY_DATE_DESC = new Comparator<Event>() {
        public int compare(Event event, Event t1) {
            return -SORT_BY_DATE_ASC.compare(event, t1);
        }
    };
    private String subject;
    private String key;
    private Date createdAt;
    /**
     * Compares two events according to their creation date. The older is the first.
     */
    public static Comparator<Event> SORT_BY_DATE_ASC = new Comparator<Event>() {
        public int compare(Event event, Event t1) {
            return event.getCreatedAt().compareTo(t1.getCreatedAt());
        }
    };


    /**
     * Constructs an event, with a given subject and the date initialized to now.
     *
     * @param subject The subject of the event
     * @param key     The event name.
     */
    public Event(String subject, String key) {
        this(subject, key, new Date());
    }

    public Event(String subject, String key, Date date) {
        this.subject = subject;
        this.key = key;
        this.createdAt = date;
    }

    public String getSubject() {
        return subject;
    }

    public String getKey() {
        return key;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public abstract String toString();
}

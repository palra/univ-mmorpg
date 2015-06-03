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
    private String topic;
    private String name;
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
     * @param topic The topic of the event
     * @param name The event name.
     */
    public Event(String topic, String name) {
        this(topic, name, new Date());
    }

    /**
     * Constructs an event, with a given topic, name and date
     *
     * @param topic The topic of the event
     * @param name  The event name.
     * @param date  The date of the event
     */
    public Event(String topic, String name, Date date) {
        this.topic = topic;
        this.name = name;
        this.createdAt = date;
    }

    public String getTopic() {
        return topic;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public abstract String toString();
}

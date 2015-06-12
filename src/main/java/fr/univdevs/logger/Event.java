package fr.univdevs.logger;

import fr.univdevs.util.Strings;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 * Represents an event in the game
 */
public abstract class Event implements Serializable {
    private String id;
    private String topic;
    private String name;
    private Date createdAt;
    /**
     * Compares two events according to their creation date. The older is the first.
     */
    public static Comparator<Event> SORT_BY_DATE_ASC = new Comparator<Event>() {
        public int compare(Event e1, Event e2) {
            return e1.getCreatedAt().compareTo(e2.getCreatedAt());
        }
    };
    /**
     * Compares two events according to their creation date. The newer is the first.
     */
    public static Comparator<Event> SORT_BY_DATE_DESC = new Comparator<Event>() {
        public int compare(Event e1, Event e2) {
            return -SORT_BY_DATE_ASC.compare(e1, e2);
        }
    };


    /**
     * Constructs an event, with a given subject and the date initialized to now.
     *
     * @param topic The topic of the event
     * @param name  The event name.
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
        this.id = Strings.random64();
        this.topic = topic;
        this.name = name;
        this.createdAt = date;
    }

    /**
     * Event copy constructor
     *
     * @param other the event we want to copy
     */
    public Event(Event other) {
        this.topic = other.topic;
        this.name = other.name;
        this.createdAt = other.createdAt;
        this.id = other.id;
    }


    /**
     * Returns the topic of the event
     *
     * @return The topic of the event
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * Returns the name of the event
     *
     * @return The name of the event
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the creation date of the event
     *
     * @return The creation date of the event
     */
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Returns the ID of the event
     *
     * @return The ID of the event
     */
    public String getID() {
        return this.id;
    }


    /**
     * Returns an human understandable description of the event.
     *
     * @return The description of the event.
     */
    public abstract String getDescription();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (this.topic != null ? !this.topic.equals(event.topic) : event.topic != null) return false;
        if (this.name != null ? !this.name.equals(event.name) : event.name != null) return false;
        if (this.createdAt != null ? !this.createdAt.equals(event.createdAt) : event.createdAt != null) return false;
        return !(this.id != null ? !this.id.equals(event.id) : event.id != null);

    }
}

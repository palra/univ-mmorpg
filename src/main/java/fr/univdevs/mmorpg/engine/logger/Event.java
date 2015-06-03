package fr.univdevs.mmorpg.engine.logger;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Represents an event in the game
 */
public abstract class Event {
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
    private UUID uuid;


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
        this.uuid = UUID.randomUUID();
        this.topic = topic;
        this.name = name;
        this.createdAt = date;
    }

    /**
     * Returns the topic of the event
     *
     * @return The topic of the event
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Returns the name of the event
     *
     * @return The name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the creation date of the event
     * @return The creation date of the event
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the UUID of the event
     *
     * @return The UUID of the event
     */
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (topic != null ? !topic.equals(event.topic) : event.topic != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (createdAt != null ? !createdAt.equals(event.createdAt) : event.createdAt != null) return false;
        return !(uuid != null ? !uuid.equals(event.uuid) : event.uuid != null);

    }

    /**
     * Returns an human understandable description of the event.
     * @return The description of the event.
     */
    public abstract String getDescription();
}

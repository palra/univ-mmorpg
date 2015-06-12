package fr.univdevs.mmorpg.engine.event.inventory;


import fr.univdevs.logger.Event;
import fr.univdevs.mmorpg.engine.character.Character;

import java.util.Date;

/**
 * Events that reports an information about a given subject
 *
 * @author Vincent Emile
 */

public abstract class InventoryEvent extends Event {
    private static String TOPIC = "inventory";
    private Character subject;

    /**
     * Constructs an InventoryEvent
     *
     * @param name    The name of the event
     * @param subject The subject of the action, non nullable, but the constructor will not throw an exception for that
     */
    public InventoryEvent(String name, Character subject) {
        super(TOPIC, name);
        this.subject = subject;
    }

    /**
     * Constructs InventoryEvent
     *
     * @param name    The name of the event
     * @param date    The date of the event
     * @param subject The subject of the action, non nullable
     */
    public InventoryEvent(String name, Date date, Character subject) {
        super(TOPIC, name, date);
        this.subject = subject;
    }

    public InventoryEvent(InventoryEvent other) {
        super(other);
        this.subject = other.subject;
    }


    /**
     * public getter for Subject
     *
     * @return the subject of the event
     */
    public Character getSubject() {
        return subject;
    }

    /**
     * public getter for Target
     *
     * @return the target of the event
     */

}

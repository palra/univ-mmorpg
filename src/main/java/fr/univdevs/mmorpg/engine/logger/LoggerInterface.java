package fr.univdevs.mmorpg.engine.logger;

import java.io.Serializable;
import java.util.List;

/**
 * Interface representing the service given by a Logger
 *
 * @author Loïc Payol
 */
public interface LoggerInterface extends Serializable {

    /**
     * Returns all the events
     *
     * @return All the events
     */
    List<Event> getEvents();


    /**
     * Returns all the events occured after a given index.
     *
     * @param index The limit date
     * @return All the events occured after the given index.
     */
    List<Event> getEventsAfterIndex(int index);

    /**
     * Returns the last `number` events, ordered by date of insertion, not by the given date of the event.
     *
     * @param number The number of events to return
     * @return The `number` last events, if exists
     */
    List<Event> getLastEvents(int number);

    /**
     * Logs an event.
     *
     * @param e The event to log
     * @return the return value of List.add
     */
    boolean log(Event e);

}

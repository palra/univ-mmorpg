package fr.univdevs.logger;

import java.util.List;

/**
 * Interface representing the service given by a Logger
 *
 * @author Loïc Payol
 */
public interface LoggerInterface {

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
     * Logs an event.
     *
     * @param e The event to log
     * @return the return value of List.add
     */
    boolean log(Event e);

}

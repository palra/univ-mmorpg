package fr.univdevs.logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Event database, keeping a trace of each event.
 */
public class Logger implements LoggerInterface {
    private ArrayList<Event> events = new ArrayList<Event>();

    public Logger() {
    }

    public Logger(Logger l) {
        this.events = new ArrayList<Event>(l.events);
    }

    /**
     * {@inheritDoc}
     */
    public List<Event> getEvents() {
        return events;
    }


    /**
     * {@inheritDoc}
     */
    public List<Event> getEventsAfterIndex(int index) {
        return this.events.subList(index, this.events.size());
    }

    /**
     * {@inheritDoc}
     */
    public List<Event> getLastEvents(int number) {
        int size = this.events.size();
        return this.events.subList(Math.max(size - number, 0), size);
    }

    /**
     * {@inheritDoc}
     */
    public boolean log(Event e) {
        return this.events.add(e);
    }
}

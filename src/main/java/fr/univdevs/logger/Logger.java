package fr.univdevs.logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Event dispatcher, keeping a trace of each event.
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
    public List<Event> getEventsAfterIndex(final int index) {
        return this.events.subList(index, this.events.size());
    }

    /**
     * {@inheritDoc}
     */
    public boolean log(Event e) {
        return this.events.add(e);
    }

    /**
     * Creates a subset of the events array, for each event that matches the criteria given
     *
     * @param filter The criteria to add an event to the subset
     * @return The filtered subset of events
     */
    private List<Event> _reduce(FilterRunnable filter) {
        List<Event> evts = new ArrayList<Event>();
        for (Event e : events) {
            if (filter.canAdd(e))
                evts.add(e);
        }

        return evts;
    }

    private abstract static class FilterRunnable {
        protected abstract boolean canAdd(Event e);
    }
}

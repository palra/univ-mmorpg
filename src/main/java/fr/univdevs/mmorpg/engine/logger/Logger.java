package fr.univdevs.mmorpg.engine.logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Event dispatcher, keeping a trace of each event.
 */
public class Logger {
    private List<Event> events = new ArrayList<Event>();

    /**
     * Returns all the events
     *
     * @return All the events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Returns all the events occured before a given date.
     *
     * @param date The limit date
     * @return All the events occured before the given date.
     */
    public List<Event> getEventsBeforeDate(final Date date) {
        return _reduce(new FilterRunnable() {
            @Override
            protected boolean canAdd(Event e) {
                return e.getCreatedAt().before(date);
            }
        });
    }

    /**
     * Returns all the events occured after a given date.
     *
     * @param date The limit date
     * @return All the events occured after the given date.
     */
    public List<Event> getEventsAfterDate(final Date date) {
        return _reduce(new FilterRunnable() {
            @Override
            protected boolean canAdd(Event e) {
                return e.getCreatedAt().after(date);
            }
        });
    }

    /**
     * Logs an event.
     *
     * @param e The event to log
     * @return the return value of List.add
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

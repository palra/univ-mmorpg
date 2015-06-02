package fr.univdevs.mmorpg.engine.logger;

import java.util.*;

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
    public Event[] getEvents() {
        return events.toArray(new Event[events.size()]);
    }

    /**
     * Returns all the event, sorted according to a given Comparator
     *
     * @param cmp The comparator used to sort
     * @return The sorted array of all events.
     */
    public Event[] getEvents(Comparator<Event> cmp) {
        Event[] evts = this.getEvents();
        Arrays.sort(evts, cmp);
        return evts;
    }

    /**
     * Returns all the events occured before a given date.
     *
     * @param date The limit date
     * @return All the events occured before the given date.
     */
    public Event[] getEventsBeforeDate(final Date date) {
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
    public Event[] getEventsAfterDate(final Date date) {
        return _reduce(new FilterRunnable() {
            @Override
            protected boolean canAdd(Event e) {
                return e.getCreatedAt().after(date);
            }
        });
    }

    /**
     * Adds an event to log.
     *
     * @param e The event to add
     * @return the return value of List.add
     */
    public boolean add(Event e) {
        return this.events.add(e);
    }

    /**
     * Creates a subset of the events array, for each event that matches the criteria given
     *
     * @param filter The criteria to add an event to the subset
     * @return The filtered subset of events
     */
    private Event[] _reduce(FilterRunnable filter) {
        List<Event> evts = new ArrayList<Event>();
        for (Event e : events) {
            if (filter.canAdd(e))
                evts.add(e);
        }

        return evts.toArray(new Event[evts.size()]);
    }

    private abstract static class FilterRunnable {
        protected abstract boolean canAdd(Event e);
    }
}

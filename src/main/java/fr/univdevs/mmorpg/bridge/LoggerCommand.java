package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.logger.Event;
import fr.univdevs.logger.LoggerAwareInterface;
import fr.univdevs.logger.LoggerInterface;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Command facade for a Logger
 * <p/>
 * Synopsis :
 * log [{all|since-last|tail[ <nb_logs>]}]
 * <p/>
 * - `all` : Dumps all the events
 * -`since-last` : Dumps all the events since the last consultation, the default behavior.
 * - `tail[ <nb_logs>]` : Dumps the last `nb_logs` events. If not provided, nb_logs will be initialized at 10.
 */
public class LoggerCommand extends Command implements LoggerAwareInterface {
    protected static final String ALL_OPT = "all";
    protected static final String SINCE_LAST_OPT = "since-last";
    protected static final String TAIL_OPT = "tail";
    protected static final int DEFAULT_NB_LOGS = 10;
    protected static final String NOT_FOUND_MSG = new ANSIString("No entries found for your request\n", ANSIAttribute.FG_RED) + "";

    private LoggerInterface logger;
    private String dateFormat = "dd/MM/yy HH:mm:ss";
    private String logFormat = "" +
        new ANSIString("[%s] ", ANSIAttribute.FG_CYAN) +
        new ANSIString("<%s.%s>", ANSIAttribute.FG_YELLOW, ANSIAttribute.ATTR_UNDERSCORE) +
        ": %s";
    private int lastIdx = 0;

    public LoggerCommand() {
        this.setName("log");
    }

    public LoggerInterface getLogger() {
        return logger;
    }

    /**
     * {@inheritDoc}
     */
    public void setLogger(LoggerInterface logger) {
        this.logger = logger;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getLogFormat() {
        return logFormat;
    }

    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    public int getLastIndex() {
        return lastIdx;
    }

    public void setLastIndex(int lastIdx) {
        this.lastIdx = lastIdx;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 1)
            args = new String[]{SINCE_LAST_OPT};

        if (args[0].equals(SINCE_LAST_OPT)) { // Dump since last consultation
            List<Event> list = this.logger.getEventsAfterIndex(this.lastIdx);
            String out = dumpList(list);
            this.lastIdx += list.size();
            return out;
        }

        if (args[0].equals(ALL_OPT)) {
            return dumpList(this.logger.getEvents());
        }

        if (args[0].equals(TAIL_OPT)) {
            int nbEvents;
            if (args.length != 2)
                nbEvents = DEFAULT_NB_LOGS;
            else
                nbEvents = Integer.parseInt(args[1]);

            return dumpList(this.logger.getLastEvents(nbEvents));
        }

        throw new IllegalArgumentException("Invalid operand");
    }

    protected String dumpList(List<Event> events) {
        String out = "";
        DateFormat df = new SimpleDateFormat(dateFormat);

        if (events.isEmpty()) {
            return NOT_FOUND_MSG;
        }

        for (Event e : events) {
            out += String.format(
                logFormat,
                df.format(e.getCreatedAt()),
                e.getTopic(),
                e.getName(),
                e.getDescription()
            ) + "\n";
        }

        return out;
    }

    @Override
    public String getSynopsis() {
        return "[{all|since-last|tail[ <nb_logs>]}]";
    }
}

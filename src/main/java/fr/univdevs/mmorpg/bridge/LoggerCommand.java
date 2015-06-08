package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.LoggerAwareInterface;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Command facade for a Logger
 * <p/>
 * Synopsis :
 * log [--all|--since-last]
 * <p/>
 * * `--all` : Dumps all the events
 * * `--since-last` : Dumps all the events since the last consultation, the default behavior.
 */
public class LoggerCommand extends Command implements LoggerAwareInterface {
    protected static final String ALL_FLAG = "--all";
    protected static final String SINCE_LAST_FLAG = "--since-last";
    protected static final String NOT_FOUND_MSG = new ANSIString("No entries found for your request\n", ANSIAttribute.FG_RED) + "";

    private Logger logger;
    private String dateFormat = "dd/MM/yy HH:mm:ss";
    private String logFormat = "" +
        new ANSIString("[%s] ", ANSIAttribute.FG_CYAN) +
        new ANSIString("<%s.%s>", ANSIAttribute.FG_YELLOW, ANSIAttribute.ATTR_UNDERSCORE) +
        ": %s";
    private int lastIdx = 0;

    public LoggerCommand() {
        this.setName("log");
    }

    public Logger getLogger() {
        return logger;
    }

    /**
     * {@inheritDoc}
     */
    public void setLogger(Logger logger) {
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

    @Override
    public String execute(String[] args) {
        boolean dumpAll = args.length >= 1 && args[0].equals(ALL_FLAG);
        boolean sinceLast = !dumpAll || (args.length >= 1 && args[0].equals(SINCE_LAST_FLAG));

        if (lastIdx == 0) {
            dumpAll = true;
            sinceLast = false;
        }

        List<Event> lst;

        if (dumpAll) {
            lst = this.logger.getEvents();
        } else {
            lst = this.logger.getEventsAfterIndex(lastIdx);
        }

        String out = "";
        DateFormat df = new SimpleDateFormat(dateFormat);

        if (lst.isEmpty()) {
            return NOT_FOUND_MSG;
        }

        for (Event e : lst) {
            out += String.format(
                logFormat,
                df.format(e.getCreatedAt()),
                e.getTopic(),
                e.getName(),
                e.getDescription()
            ) + "\n";
            this.lastIdx++;
        }

        return out;
    }

    public int getLastIndex() {
        return lastIdx;
    }

    public void setLastIndex(int lastIdx) {
        this.lastIdx = lastIdx;
    }

    @Override
    public String getSynopsis() {
        return "[--all|--since-last]";
    }
}

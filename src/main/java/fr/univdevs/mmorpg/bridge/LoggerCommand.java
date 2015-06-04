package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.LoggerAwareInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private static final String ALL_FLAG = "--all";
    private static final String SINCE_LAST_FLAG = "--since-last";

    private Logger logger;
    private String dateFormat = "dd/MM/yy HH:mm:ss";
    private String logFormat = "[%s] <%s.%s>: %s";
    private Date lastDate = null;

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
    public String execute(String[] args) throws Exception {
        boolean dumpAll = args.length >= 1 && args[0].equals(ALL_FLAG);
        boolean sinceLast = !dumpAll || (args.length >= 1 && args[0].equals(SINCE_LAST_FLAG));

        if (lastDate == null) {
            dumpAll = true;
            sinceLast = false;
        }

        List<Event> lst;

        if (dumpAll) {
            lst = this.logger.getEvents();
        } else {
            lst = this.logger.getEventsAfterDate(lastDate);
        }

        String out = "";
        DateFormat df = new SimpleDateFormat(dateFormat);

        for (Event e : lst) {
            out += String.format(
                logFormat,
                df.format(e.getCreatedAt()),
                e.getTopic(),
                e.getName(),
                e.getDescription()
            ) + "\n";
        }

        this.lastDate = new Date();
        return out;
    }

    @Override
    public String getSynopsis() {
        return "[--all|--since-last]";
    }
}

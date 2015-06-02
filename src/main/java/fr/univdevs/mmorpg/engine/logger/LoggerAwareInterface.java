package fr.univdevs.mmorpg.engine.logger;

/**
 * Interface representing a class that uses an instance of Logger.
 *
 * @author Loïc Payol
 */
public interface LoggerAwareInterface {
    /**
     * Sets the logger.
     *
     * @param logger Reference to the logger
     */
    void setLogger(Logger logger);
}

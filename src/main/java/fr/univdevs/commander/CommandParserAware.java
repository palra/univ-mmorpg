package fr.univdevs.commander;

/**
 * Interfaces a class that can be associated to a CommandParser
 */
public interface CommandParserAware {

    /**
     * Sets the CommandParser
     *
     * @param parser The CommandParser
     */
    void setCommandParser(CommandParser parser);
}

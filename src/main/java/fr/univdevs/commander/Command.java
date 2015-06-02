package fr.univdevs.commander;

import fr.univdevs.util.Strings;

/**
 * Interface representing the behavior of a Command.
 *
 * @author Loïc Payol
 */
public abstract class Command implements CommandParserAware {
    private String name;
    private CommandParser parser;

    /**
     * Executes the command with the given arguments.
     *
     * @param args The arguments given to the method (`argv` like)
     * @return The output of the command, intended to be sent to an HMI
     */
    public abstract String execute(String[] args) throws Exception;

    /**
     * Returns a description of the correct way to wall the command.
     *
     * @return The synopsis of the command
     */
    public String getSynopsis() {
        return null;
    }

    /**
     * Returns the name of the command.
     * Used by the command parser in order to identify each command.
     *
     * @return The name of the command
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the command
     *
     * @param name The name of the command
     */
    public void setName(String name) {
        name = name.trim();
        if (Strings.isNullOrEmpty(name))
            throw new IllegalArgumentException("Name must not be null or empty");

        this.name = name;
    }

    /**
     * Returns the command parser.
     *
     * @return The command parser
     */
    public CommandParser getCommandParser() {
        return parser;
    }

    /**
     * {@inheritDoc}
     */
    public void setCommandParser(CommandParser parser) {
        this.parser = parser;
    }
}

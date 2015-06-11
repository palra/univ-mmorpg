package fr.univdevs.commander;

import fr.univdevs.util.Strings;

/**
 * Interface representing the behavior of a Command.
 *
 * @author Loïc Payol
 */
public abstract class Command implements CommandParserAware {
    private String name;
    private CommandParserInterface parser;

    /**
     * Executes the command with the given arguments.
     *
     * @param args The arguments given to the method (`argv` like)
     * @return The output of the command, intended to be sent to an HMI
     */
    public abstract String execute(String[] args) throws CommandException;

    /**
     * Returns a description of the correct way to call the command.
     * The synopsis should be a short description of the syntax of the arguments.
     * Please refer to <a href="http://pubs.opengroup.org/onlinepubs/009695399/basedefs/xbd_chap12.html">this syntax</a>
     * for your argument description.
     *
     * @return The synopsis of the command
     */
    public abstract String getSynopsis();

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
    public CommandParserInterface getCommandParser() {
        return this.parser;
    }

    /**
     * {@inheritDoc}
     */
    public void setCommandParser(CommandParserInterface parser) {
        this.parser = parser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;

        Command command = (Command) o;

        if (!this.name.equals(command.name)) return false;
        return !(this.parser != null ? !this.parser.equals(command.parser) : command.parser != null);

    }
}

package fr.univdevs.commander.userworld;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandException;

/**
 * Command that can be used to quit a program
 *
 * @author Loïc Payol
 */
public class ExitCommand extends Command {
    private static final String DEFAULT_NAME = "exit";
    private final String cmdName;
    private boolean closed = false;

    /**
     * Default constructor, setting the command name to the default one.
     */
    public ExitCommand() {
        this.cmdName = DEFAULT_NAME;
    }

    /**
     * Initializes the name of the command to the given one.
     *
     * @param cmdName The name of the command
     */
    public ExitCommand(String cmdName) {
        this.cmdName = cmdName;
    }

    @Override
    public String getSynopsis() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    public String execute(String[] args) throws CommandException {
        this.setClosed(true);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.cmdName;
    }

    /**
     * Is the command indicates that the program should be closed ?
     *
     * @return a boolean indicating if the program should be closed
     */
    public boolean isClosed() {
        return this.closed;
    }

    /**
     * Sets the closed state of the command
     *
     * @param closed the closed state
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
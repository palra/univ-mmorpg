package fr.univdevs.commander.userworld;

import fr.univdevs.commander.Command;

/**
 * Command that can be used to quit a program
 *
 * @author Loïc Payol
 */
public class ExitCommand implements Command {
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

    /**
     * {@inheritDoc}
     */
    public String execute(String[] args) throws Exception {
        this.setClosed(true);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public String getSynopsis() {
        return this.getName();
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
package fr.univdevs.commander;

/**
 * Exception thrown when no command name was given.
 *
 * @author Loïc Payol
 */
public class EmptyCommandException extends CommandException {
    private static final long serialVersionUID = -6027865113095477502L;

    public EmptyCommandException() {
        super("Empty command given");
    }
}

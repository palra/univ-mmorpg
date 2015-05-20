package fr.univdevs.commander;

/**
 * Exception thrown when no command name was given.
 *
 * @author Lo�c Payol
 */
public class EmptyCommandException extends Exception {
    private static final long serialVersionUID = -6027865113095477502L;

    public EmptyCommandException() {
        super("Empty command given");
    }
}

package fr.univdevs.commander;

/**
 * Exception thrown when a requested command does not exists.
 *
 * @author Loïc Payol
 */
public class NonExistingCommandException extends CommandException {
    private static final long serialVersionUID = 66592695014285770L;
    private static final String errorMsg = "The given command does not exists";

    /**
     * Constructor setting the default error message.
     */
    public NonExistingCommandException() {
        super(errorMsg);
    }
}

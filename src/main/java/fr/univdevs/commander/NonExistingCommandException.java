package fr.univdevs.commander;

/**
 * Exception thrown when a requested command does not exists.
 * @author Loïc Payol
 */
public class NonExistingCommandException extends Exception {
    private static final long serialVersionUID = 66592695014285770L;
    private static final String errorMsg = "The given command does not exists";

    /**
     * Constructor setting the error message, prefixed with the default error
     * message.
     *
     * @param cmdName The name of the command for which the exception is thrown
     * @param setName Flag indicating if we want to prefix the cmdName with the
     *                default error message.
     */
    public NonExistingCommandException(String cmdName, boolean setName) {
        super((setName) ? (errorMsg + " : " + cmdName) : cmdName);
    }
}

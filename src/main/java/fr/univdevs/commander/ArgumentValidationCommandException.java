package fr.univdevs.commander;

/**
 * Exception thrown when a command fails at parsing the args array.
 *
 * @author Loïc Payol
 */
public class ArgumentValidationCommandException extends CommandException {
    public ArgumentValidationCommandException() {
    }

    public ArgumentValidationCommandException(String message) {
        super(message);
    }

    public ArgumentValidationCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentValidationCommandException(Throwable cause) {
        super(cause);
    }

    public ArgumentValidationCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

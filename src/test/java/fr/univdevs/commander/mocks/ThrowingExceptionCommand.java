package fr.univdevs.commander.mocks;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandException;

/**
 * @author Loïc Payol
 */
public class ThrowingExceptionCommand extends Command {
    public String execute(String[] args) throws CommandException {
        throw new CommandException("NEINEINEINEIN");
    }

    public String getSynopsis() {
        return null;
    }

    public String getName() {
        return "nein";
    }
}

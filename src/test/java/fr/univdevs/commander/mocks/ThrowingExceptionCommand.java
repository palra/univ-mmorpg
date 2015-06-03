package fr.univdevs.commander.mocks;

import fr.univdevs.commander.Command;

/**
 * @author Loïc Payol
 */
public class ThrowingExceptionCommand extends Command {
    public String execute(String[] args) throws Exception {
        throw new Exception("NEINEINEINEIN");
    }

    public String getSynopsis() {
        return null;
    }

    public String getName() {
        return "nein";
    }
}

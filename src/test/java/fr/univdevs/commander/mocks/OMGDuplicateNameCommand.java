package fr.univdevs.commander.mocks;

import fr.univdevs.commander.Command;

/**
 * @author Loïc Payol
 */
public class OMGDuplicateNameCommand implements Command {
    public String execute(String[] args) {
        return null;
    }

    public String getSynopsis() {
        return null;
    }

    public String getName() {
        return (new GreeterCommand()).getName();
    }
}

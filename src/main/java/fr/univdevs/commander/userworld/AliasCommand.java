package fr.univdevs.commander.userworld;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandException;

/**
 * Command that creates an alias for a given command
 *
 * @author Loïc Payol
 */
public class AliasCommand extends Command {
    private String alias;
    private String fullCommand;

    /**
     * Constructs an alias
     *
     * @param alias       The alias
     * @param fullCommand The full command that the alias will replace
     */
    public AliasCommand(String alias, String fullCommand) {
        this.alias = alias;
        this.fullCommand = fullCommand;
        this.setName(this.alias);
    }

    /**
     * @return The alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @return The full command
     */
    public String getFullCommand() {
        return fullCommand;
    }

    @Override
    public String execute(String[] args) throws CommandException {
        String finalCommand = this.fullCommand;
        for (String arg : args) {
            finalCommand += " " + arg;
        }

        return this.getCommandParser().parse(finalCommand).getOutput();
    }

    @Override
    public String getSynopsis() {
        return " => " + this.fullCommand;
    }
}

package fr.univdevs.commander.userworld;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import fr.univdevs.commander.CommandParserAware;
import fr.univdevs.util.Strings;

/**
 * Command that lists all the commands in a given CommandParser
 *
 * @author Loïc Payol
 */
public class HelpCommand implements Command, CommandParserAware {
    private static final String DEFAULT_NAME = "help";
    private static final String WITH_DESC_OPT = "--with-desc";
    private final String cmdName;
    private CommandParser parser;

    /**
     * Default constructor, setting the command name to the default one.
     */
    public HelpCommand() {
        this.cmdName = DEFAULT_NAME;
    }

    /**
     * Initializes the name of the command to the given one.
     *
     * @param cmdName The name of the command
     */
    public HelpCommand(String cmdName) {
        this.cmdName = cmdName;
    }


    /**
     * {@inheritDoc}
     */
    public String execute(String[] args) throws Exception {
        boolean withDesc = args.length > 1 && args[0].equals(WITH_DESC_OPT);
        String out = "";
        for (Command c : parser.getCommands()) {
            out += c.getName();
            String desc = c.getSynopsis();
            if (withDesc && !Strings.isNullOrEmpty(desc))
                out += " : " + Strings.nullToEmpty(desc);

            out += "\n";
        }

        return out;
    }

    /**
     * {@inheritDoc}
     */
    public String getSynopsis() {
        return "[" + WITH_DESC_OPT + "]";
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.cmdName;
    }

    /**
     * {@inheritDoc}
     */
    public void setCommandParser(CommandParser parser) {
        this.parser = parser;
    }
}

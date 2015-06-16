package fr.univdevs.commander.userworld;

import fr.univdevs.commander.ArgumentValidationCommandException;
import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Commands that manages the aliases of the current command parser
 *
 * @author Loïc Payol
 */
public class AliasManagerCommand extends Command {
    protected static final String WITHOUT_DESC_OPT = "--without-desc";
    protected static final String NAME = "aliases";
    protected static final String LIST_OPT = "list";
    protected static final String CREATE_OPT = "create";

    /**
     * Default constructor
     */
    public AliasManagerCommand() {
        this.setName(NAME);
    }

    /**
     * Constructor that sets the name to the given name
     *
     * @param name The name of the command
     */
    public AliasManagerCommand(String name) {
        this.setName(name);
    }

    @Override
    public String execute(String[] args) throws CommandException {
        if (args.length == 0)
            args = new String[]{LIST_OPT};

        String operand = args[0];

        if (operand.equals(LIST_OPT)) {
            List<AliasCommand> cmds = new ArrayList<AliasCommand>();
            for (Command command : this.getCommandParser().getCommands())
                if (command instanceof AliasCommand) {
                    cmds.add((AliasCommand) command);
                }

            boolean withoutDesc = args.length >= 2 && args[1].equals(WITHOUT_DESC_OPT);
            return HelpCommand.commandListToString(cmds, withoutDesc);
        }

        if (operand.equals(CREATE_OPT)) {
            if (args.length >= 3) {
                String alias = args[1];
                String fullCommand = "";
                for (String s : Arrays.copyOfRange(args, 2, args.length)) {
                    fullCommand += s + " ";
                }

                this.getCommandParser().add(new AliasCommand(alias, fullCommand));
                return null;
            }

            throw new ArgumentValidationCommandException("The alias or the full command is missing");
        }

        throw new ArgumentValidationCommandException("Invalid operand");
    }

    @Override
    public String getSynopsis() {
        return "[{" + LIST_OPT + " [" + WITHOUT_DESC_OPT + "]|" + CREATE_OPT + " <alias> <full_command>}]";
    }
}

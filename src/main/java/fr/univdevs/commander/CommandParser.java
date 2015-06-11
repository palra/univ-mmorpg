package fr.univdevs.commander;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Registers Command instances and parses an user input, in order to call a registered command.
 * @author Loïc Payol
 */
public class CommandParser implements CommandParserInterface {
    private ArrayList<Command> commands = new ArrayList<Command>();

    /**
     * Empty constructor
     */
    public CommandParser() {
    }

    /**
     * Takes each command passed in parameter and registers them into the
     * parser, ignoring default commands.
     *
     * @param commands An array of Commands
     */
    public CommandParser(Command... commands) {
        for (Command command : commands) {
            this.add(command);
        }
    }

    /**
     * Splits the given input in arguments
     *
     * @param input The user input to split
     * @return Parsed input
     */
    public static String[] parseInputString(String input) {
        String regex = "\\s+";
        return input.split(regex);
    }

    /**
     * {@inheritDoc}
     */
    public void add(Command command) {
        if (this.contains(command.getName())) {
            throw new IllegalStateException(
                "Duplicate commands were registered for `" +
                    command.getName() +
                    "`"
            );
        }

        command.setCommandParser(this); // Injecting ourself
        this.commands.add(command);
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(String command) {
        return this.indexOf(command) >= 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(Object o) {
        return commands.contains(o);
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(String name) {
        int i = 0;
        int idx = -1;

        while (i < this.commands.size() && idx == -1) {
            Command command = this.commands.get(i);
            if (command.getName().equals(name))
                idx = i;

            i++;
        }

        return idx;
    }

    /**
     * {@inheritDoc}
     */
    public ParserResult parse(String input) throws CommandException {
        input = input.trim();
        String[] parsed = CommandParser.parseInputString(input);
        // Check if any command is passed
        if (parsed.length < 1 || input.isEmpty()) {
            throw new EmptyCommandException();
        }

        // Check if the command exists
        String cmdName = parsed[0];
        if (!this.contains(cmdName)) {
            throw new NonExistingCommandException();
        }

        // Extract the arguments from the input
        String[] args = Arrays.copyOfRange(parsed, 1, parsed.length);

        // And execute the command
        String out = this.get(cmdName).execute(args);
        return new ParserResult(parsed, out);
    }

    /**
     * {@inheritDoc}
     */
    public Command get(String name) {
        return this.commands.get(this.indexOf(name));
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(Object o) {
        return this.commands.remove(o);
    }

    /**
     * {@inheritDoc}
     */
    public Command remove(String name) {
        return this.commands.remove(this.indexOf(name));
    }

    /**
     * {@inheritDoc}
     */
    public ArrayList<Command> getCommands() {
        return this.commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandParser)) return false;

        CommandParser that = (CommandParser) o;

        return commands.equals(that.commands);
    }
}

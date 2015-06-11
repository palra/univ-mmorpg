package fr.univdevs.commander;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Registers Command instances and parses an user input, in order to call a registered command.
 * TODO : create an interface for CommandParser
 * @author Loïc Payol
 */
public class CommandParser {
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
     * Registers a new command in the parser.
     *
     * @param command The instance of Command you want to add
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
     * Checks if the parser already have a given command name.
     *
     * @param command The name of the command you are looking for
     * @return true if the parser already have registered the command, false
     * otherwise
     */
    public boolean contains(String command) {
        return this.indexOf(command) >= 0;
    }

    /**
     * Indicates if a given object is contained in the collection of commands
     *
     * @param o The object to check
     * @return true if exists, false otherwise
     * @see List#contains(Object)
     */
    public boolean contains(Object o) {
        return commands.contains(o);
    }

    /**
     * Returns the index of the command with the given name
     * @param name The name of the command we are looking for.
     * @return The index of the command if found, -1 otherwise.
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
     * Parses an input, and returns the parsed command.
     *
     * @param input The user input
     * @return the parsed command
     * @throws CommandException
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
     * Returns the command with the given name
     *
     * @param name The name of the command you are looking for
     * @return The desired command, if exists
     * @throws IndexOutOfBoundsException if the requested name does not exists
     * @see CommandParser#contains(String) to check yourself if the requested command exists
     */
    public Command get(String name) {
        return this.commands.get(this.indexOf(name));
    }

    /**
     * Removes a given object from the collection.
     *
     * @param o The object to remove
     * @return true if the object exists in the collection, false otherwise
     */
    public boolean remove(Object o) {
        return this.commands.remove(o);
    }

    /**
     * Removes a command, identified by its name.
     *
     * @param name The name of the command to remove
     * @return The removed command, if any
     * @throws IndexOutOfBoundsException if the requested command does not exists
     * @see CommandParser#contains(String) to check yourself if the requested command exists
     */
    public Command remove(String name) {
        return this.commands.remove(this.indexOf(name));
    }

    /**
     * Returns all commands
     *
     * @return List of all registered commands
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

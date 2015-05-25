package fr.univdevs.commander;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* TODO : import fr.univdevs.mmorpg.engine.common.commander.userworld.ListCommand;
import fr.univdevs.mmorpg.engine.common.commander.userworld.ManCommand; */

/**
 * Registers Command instances and parses an user input, in order to call a registered command.
 *
 * @author Loïc Payol
 */
public class CommandParser {
    private Map<String, Command> commands = new HashMap<String, Command>();

    /**
     * Default constructor, registering default commands.
     */
    public CommandParser() {
        /* TODO : this.add(new ManCommand());
        todo this.add(new ListCommand());*/
    }

    /**
     * Takes each command passed in parameter and registers them into the
     * parser, ignoring default commands.
     *
     * @param commands An array of Commands
     */
    public CommandParser(Command[] commands) {
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
        if (this.has(command)) {
            throw new IllegalStateException(
                "Duplicate commands were registered for `" +
                    command.getName() +
                    "`"
            );
        }

        this.commands.put(command.getName(), command);
    }

    /**
     * Checks if the parser already have a given command name.
     *
     * @param command The name of the command you are looking for
     * @return true if the parser already have registered the command, false
     * otherwise
     */
    public boolean has(String command) {
        return this.commands.containsKey(command);
    }

    /**
     * Checks if the parser already have a given command.
     *
     * @param command The command you are looking for in this parser
     * @return true if the parser already have registered the command, false
     * otherwise
     */
    public boolean has(Command command) {
        return this.has(command.getName());
    }

    /**
     * Parses an input, and returns the parsed command.
     *
     * @param input The user input
     * @return the parsed command
     * @throws Exception
     */
    public ParserResult parse(String input) throws Exception {
        input = input.trim();
        String[] parsed = CommandParser.parseInputString(input);
        // Check if any command is passed
        if (parsed.length < 1 || input.isEmpty()) {
            throw new EmptyCommandException();
        }

        // Check if the command exists
        String cmdName = parsed[0];
        if (!this.has(cmdName)) {
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
     */
    public Command get(String name) {
        return this.commands.get(name);
    }

    /**
     * Returns all commands
     *
     * @return Array of registered commands
     */
    public Command[] getCommands() {
        return this.commands.values().toArray(new Command[this.commands.size()]);
    }

}

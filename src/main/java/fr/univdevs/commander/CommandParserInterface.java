package fr.univdevs.commander;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface that represents the behavior of a command parser, without thinking about the parsing strategy.
 *
 * @author Loïc Payol
 */
public interface CommandParserInterface {
    /**
     * Registers a new command in the parser.
     *
     * @param command The instance of Command you want to add
     */
    void add(Command command);

    /**
     * Checks if the parser already have a given command name.
     *
     * @param command The name of the command you are looking for
     * @return true if the parser already have registered the command, false
     * otherwise
     */
    boolean contains(String command);

    /**
     * Indicates if a given object is contained in the collection of commands
     *
     * @param o The object to check
     * @return true if exists, false otherwise
     * @see List#contains(Object)
     */
    boolean contains(Object o);

    /**
     * Returns the index of the command with the given name
     *
     * @param name The name of the command we are looking for.
     * @return The index of the command if found, -1 otherwise.
     */
    int indexOf(String name);

    /**
     * Parses an input, and returns the parsed command.
     *
     * @param input The user input
     * @return the parsed command
     * @throws CommandException
     */
    ParserResult parse(String input) throws CommandException;

    /**
     * Returns the command with the given name
     *
     * @param name The name of the command you are looking for
     * @return The desired command, if exists
     * @throws IndexOutOfBoundsException if the requested name does not exists
     * @see CommandParser#contains(String) to check yourself if the requested command exists
     */
    Command get(String name);

    /**
     * Removes a given object from the collection.
     *
     * @param o The object to remove
     * @return true if the object exists in the collection, false otherwise
     */
    boolean remove(Object o);

    /**
     * Removes a command, identified by its name.
     *
     * @param name The name of the command to remove
     * @return The removed command, if any
     * @throws IndexOutOfBoundsException if the requested command does not exists
     * @see CommandParser#contains(String) to check yourself if the requested command exists
     */
    Command remove(String name);

    /**
     * Returns all commands
     *
     * @return List of all registered commands
     */
    ArrayList<Command> getCommands();
}

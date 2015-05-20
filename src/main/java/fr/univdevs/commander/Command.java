package fr.univdevs.commander;

/**
 * Interface representing the behavior of a Command.
 *
 * @author Loïc Payol
 */
public interface Command {
    /**
     * Executes the command with the given arguments.
     *
     * @param args The arguments given to the method (`argv` like)
     * @return The output of the command, intended to be sent to an HMI
     */
    String execute(String[] args) throws Exception;

    /**
     * Returns a description of the expected argument.
     * Each element of the array describe an argument, or a group of arguments
     * if the command accepts a varying number of arguments.
     *
     * @return The String array describing the expected arguments
     */
    String getArgumentsDescription();

    /**
     * Returns the name of the command.
     * Used by the command parser in order to identify each command.
     *
     * @return The name of the command
     */
    String getName();

}

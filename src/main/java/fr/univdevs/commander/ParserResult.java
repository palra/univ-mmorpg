package fr.univdevs.commander;

/**
 * Class used in order to represent the result of a parser interpretation.
 */
public class ParserResult {
    private final String[] parsedInput;
    private final String output;

    /**
     * Default constructor.
     *
     * @param parsedInput The parsed input
     * @param output      The command output
     */
    public ParserResult(String[] parsedInput, String output) {
        this.parsedInput = parsedInput;
        this.output = output;
    }

    /**
     * @return the parsed input
     */
    public String[] getParsedInput() {
        return this.parsedInput;
    }

    /**
     * @return the command output, if any
     */
    public String getOutput() {
        return this.output;
    }

    /**
     * @return true if any output was given by the command, false otherwise.
     */
    public boolean hasOutput() {
        return this.getOutput() == null;
    }
}
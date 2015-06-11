package fr.univdevs.commander;

import fr.univdevs.util.Strings;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Simple interactive shell, powered by the CommandParser.
 *
 * @author Loïc Payol
 */
public class InteractiveShell {
    private CommandParser commandParser;
    private String inviteString = new ANSIString(
        new ANSIString("msh", ANSIAttribute.FG_GREEN) + "> "
    ) + "";

    private InputStream in = System.in;
    private PrintStream out = System.out;

    /**
     * Default constructor
     */
    public InteractiveShell() {
        this.commandParser = new CommandParser();
    }

    /**
     * Constructs an InteractiveShell, with a given CommandParser
     *
     * @param commandParser The command parser
     */
    public InteractiveShell(CommandParser commandParser) {
        this.commandParser = commandParser;
    }

    /**
     * Constructs an InteractiveShell, with custom input and output streams
     * @param in The input stream
     * @param out The printable output stream
     */
    public InteractiveShell(InputStream in, PrintStream out) {
        this.commandParser = new CommandParser();
        this.in = in;
        this.out = out;
    }

    /**
     * Constructs an InteractiveShell, with a given CommandParser and custom input and output streams
     *
     * @param commandParser The command parser
     * @param in            The input stream
     * @param out           The printable output stream
     */
    public InteractiveShell(CommandParser commandParser, InputStream in, PrintStream out) {
        this(commandParser);
        this.in = in;
        this.out = out;
    }

    /**
     * Constructs an InteractiveShell, and outputs the MOTD immediately on the output.
     *
     * @param motd The Message of the Day
     */
    public InteractiveShell(String motd) {
        this();
        this.out.println(motd);
    }

    /**
     * Returns the command parser
     *
     * @return the command parser
     */
    public CommandParser getCommandParser() {
        return this.commandParser;
    }

    public String getInviteString() {
        return this.inviteString;
    }

    public void setInviteString(String inviteString) {
        this.inviteString = inviteString;
    }

    /**
     * Reads a line from the input stream, parses it with the command parser, and outputs the result of the command on
     * the print stream. If a command throws an exception, the exception is displayed, and the input process repeats
     * until no exception is  raised.
     *
     * @return The result of the parser
     */
    public ParserResult nextResult() {
        Scanner sc = new Scanner(this.in);

        ParserResult res = null;

        while (res == null) {
            this.out.print(this.inviteString);
            String in = sc.nextLine();

            try {
                res = this.getCommandParser().parse(in);
                this.out.print(Strings.nullToEmpty(res.getOutput()));
            } catch (Exception e) {
                System.err.println(new ANSIString(
                    e.getClass().getName() + " : " +
                        new ANSIString(e.getMessage(), ANSIAttribute.FG_RED, ANSIAttribute.ATTR_BOLD),
                    ANSIAttribute.FG_RED
                ));
            }
        }

        return res;
    }

    /**
     * @see CommandParser#add(Command)
     */
    public void add(Command command) {
        this.commandParser.add(command);
    }

    /**
     * @see CommandParser#get(String)
     */
    public Command get(String name) {
        return this.commandParser.get(name);
    }

    /**
     * @see CommandParser#contains(String)
     */
    public boolean contains(String name) {
        return this.commandParser.contains(name);
    }

    /**
     * @see CommandParser#contains(Object)
     */
    public boolean contains(Object o) {
        return this.commandParser.contains(o);
    }

    /**
     * @see CommandParser#remove(String)
     */
    public Command remove(String name) {
        return this.commandParser.remove(name);
    }

    /**
     * @see CommandParser#remove(Object)
     */
    public boolean remove(Object o) {
        return this.commandParser.remove(o);
    }
}

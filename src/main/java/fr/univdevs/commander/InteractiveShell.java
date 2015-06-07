package fr.univdevs.commander;

import fr.univdevs.util.Strings;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * Simple interactive shell, powered by the CommandParser.
 *
 * @author Loïc Payol
 */
public class InteractiveShell {
    private CommandParser commandParser;
    private ANSIString inviteString = new ANSIString(
        new ANSIString("msh", ANSIAttribute.FG_GREEN) + "> "
    );

    private InputStream in = System.in;
    private PrintStream out = System.out;

    /**
     * Default constructor
     */
    public InteractiveShell() {
        this(new CommandParser());
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
     * Constructs an InteractiveShell, and outputs the MOTD immediately on the output.
     *
     * @param motd The Message of the Day
     */
    public InteractiveShell(ANSIString motd) {
        this(motd.toString());
    }

    /**
     * Constructs an InteractiveShell, and outputs the MOTD immediately on the output.
     *
     * @param motd The Message of the Day
     */
    public InteractiveShell(String motd) {
        this();
        out.println(motd);
    }

    /**
     * Returns the command parser
     *
     * @return the command parser
     */
    public CommandParser getCommandParser() {
        return commandParser;
    }

    public ANSIString getInviteString() {
        return inviteString;
    }

    public void setInviteString(ANSIString inviteString) {
        this.inviteString = inviteString;
    }

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
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                System.err.println(new ANSIString(errors.toString(), ANSIAttribute.FG_RED, ANSIAttribute.ATTR_BOLD));
            }
        }

        return res;
    }

    /**
     * @see CommandParser#add(Command)
     */
    public void add(Command command) {
        commandParser.add(command);
    }

    /**
     * @see CommandParser#has(String)
     */
    public boolean has(String command) {
        return commandParser.has(command);
    }

    /**
     * @see CommandParser#has(Command)
     */
    public boolean has(Command command) {
        return commandParser.has(command);
    }

    /**
     * @see CommandParser#get(String)
     */
    public Command get(String name) {
        return commandParser.get(name);
    }

    /**
     * @see CommandParser#remove(String)
     */
    public Command remove(String name) {
        return commandParser.remove(name);
    }

    /**
     * @see CommandParser#remove(Command)
     */
    public Command remove(Command o) {
        return commandParser.remove(o);
    }

    /**
     * @see CommandParser#getCommands()
     */
    public Command[] getCommands() {
        return commandParser.getCommands();
    }
}

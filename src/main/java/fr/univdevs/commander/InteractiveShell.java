package fr.univdevs.commander;

import fr.univdevs.util.Strings;

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
    private String inviteString = "msh> ";

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

    public String getInviteString() {
        return inviteString;
    }

    public void setInviteString(String inviteString) {
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
                e.printStackTrace();
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
     * @see CommandParser#getCommands()
     */
    public Command[] getCommands() {
        return commandParser.getCommands();
    }
}

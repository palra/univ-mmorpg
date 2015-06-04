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
public class InteractiveShell implements CommandParserAware {
    private CommandParser commandParser;
    private String inviteString = "msh> ";

    private InputStream in = System.in;
    private PrintStream out = System.out;

    /**
     * Returns the command parser
     *
     * @return the command parser
     */
    public CommandParser getCommandParser() {
        return commandParser;
    }

    /**
     * {@inheritDoc}
     */
    public void setCommandParser(CommandParser parser) {
        this.commandParser = parser;
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
}

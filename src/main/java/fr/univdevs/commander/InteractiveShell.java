package fr.univdevs.commander;

import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;

import java.util.Scanner;

/**
 * Simple interactive shell, powered by the CommandParser.
 *
 * @author Loïc Payol
 */
public class InteractiveShell {

    public static void main(String[] args) {
        CommandParser parser = new CommandParser();

        ExitCommand exit = new ExitCommand();
        HelpCommand help = new HelpCommand();
        help.setCommandParser(parser);

        parser.add(exit);
        parser.add(help);

        Scanner sc = new Scanner(System.in);

        while (!exit.isClosed()) {
            System.out.print("msh> ");
            String in = sc.nextLine();
            ParserResult res;

            try {
                res = parser.parse(in);
                System.out.print((res.getOutput() == null) ? "" : res.getOutput());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

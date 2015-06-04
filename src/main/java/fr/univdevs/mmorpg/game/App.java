package fr.univdevs.mmorpg.game;

import fr.univdevs.commander.CommandParser;
import fr.univdevs.commander.InteractiveShell;
import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;

/**
 * The main application
 *
 * @author Loïc Payol
 */
public class App {
    public static void main(String[] args) {
        // CommandParser
        CommandParser parser = new CommandParser();

        /*=======================
                Commands
         =======================*/

        // exit
        ExitCommand exit = new ExitCommand();

        // help
        HelpCommand help = new HelpCommand();
        help.setCommandParser(parser);


        // -- registering them all
        parser.add(exit);
        parser.add(help);





        /*=======================
                 Shell
         =======================*/
        InteractiveShell shell = new InteractiveShell();
        shell.setCommandParser(parser);

        // The main loop
        while (!exit.isClosed()) {
            shell.nextResult();
        }

        // Goodbye, App.java :)
    }
}

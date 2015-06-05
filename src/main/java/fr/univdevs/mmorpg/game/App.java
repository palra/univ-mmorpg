package fr.univdevs.mmorpg.game;

import fr.univdevs.commander.CommandParser;
import fr.univdevs.commander.InteractiveShell;
import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;
import fr.univdevs.mmorpg.engine.GameManager;

/**
 * The main application
 *
 * @author Loïc Payol
 */
public class App {
    private static GameManager gameManager;

    private static void configureGame() {
        gameManager = new GameManager();
    }

    public static void main(String[] args) {
        App.configureGame();

        // CommandParser
        CommandParser parser = new CommandParser();

        /*=======================
                Commands
         =======================*/

        // exit
        ExitCommand exit = new ExitCommand();

        // help
        HelpCommand help = new HelpCommand();


        /*=======================
                 Shell
         =======================*/
        InteractiveShell shell = new InteractiveShell("Welcome to MMORPG Shell [version 0.0.0172]\n" +
                "Running JVM " + System.getProperty("java.version") + " on " + System.getProperty("os.name") +
                " (" + System.getProperty("os.arch") + ")\n"
        );

        shell.add(exit);
        shell.add(help);

        // The main loop
        while (!exit.isClosed()) {
            shell.nextResult();
        }

        // Goodbye, App.java :)
    }
}

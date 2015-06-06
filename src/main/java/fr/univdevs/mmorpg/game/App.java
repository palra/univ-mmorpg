package fr.univdevs.mmorpg.game;

import fr.univdevs.commander.CommandParser;
import fr.univdevs.commander.InteractiveShell;
import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;
import fr.univdevs.mmorpg.bridge.MapCommand;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.util.Vector2D;
import fr.univdevs.util.ansi.ANSIAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * The main application
 *
 * @author Loïc Payol
 */
public class App {
    private static int WORLD_SIZE = 25;

    private static GameManager gameManager;
    private static World world;
    private static Tilemap tilemap;
    private static List<Player> players = new ArrayList<Player>();

    private static void configureGame() throws Exception {
        tilemap = Tilemap.newFromFilename("/game/maps/lvl-01.txt");
        world = new World(tilemap);
        gameManager = new GameManager(world);

        // Registering players
        players.add(new Player("palra", new Warrior("nom-super-agressif")));

        for (Player p : players) {
            Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
            p.getCharacter().setX(pos.x);
            p.getCharacter().setY(pos.y);
            p.getCharacter().getDisplay()
                .addAttribute(ANSIAttribute.ATTR_BLINK)
                .addAttribute(ANSIAttribute.FG_RED)
                .removeAttribute(ANSIAttribute.ATTR_BLINK);

            gameManager.addPlayer(p);
        }
    }

    public static void main(String[] args) {
        try {
            App.configureGame();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // CommandParser
        CommandParser parser = new CommandParser();

        /*=======================
                Commands
         =======================*/

        // exit
        ExitCommand exit = new ExitCommand();

        // help
        HelpCommand help = new HelpCommand();

        // map
        MapCommand map = new MapCommand();
        map.setGameManager(gameManager);


        /*=======================
                 Shell
         =======================*/
        InteractiveShell shell = new InteractiveShell("Welcome to MMORPG Shell [version 0.0.0172]\n" +
            "Running JVM " + System.getProperty("java.version") + " on " + System.getProperty("os.name") +
            " (" + System.getProperty("os.arch") + ")\n" +
            "Type `help` for help on the shell\n"
        );

        shell.add(exit);
        shell.add(help);
        shell.add(map);

        // The main loop
        while (!exit.isClosed()) {
            shell.nextResult();
        }

        // Goodbye, App.java :)
    }
}
package fr.univdevs.mmorpg.game;

import fr.univdevs.commander.InteractiveShell;
import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;
import fr.univdevs.mmorpg.bridge.ActionCommand;
import fr.univdevs.mmorpg.bridge.LoggerCommand;
import fr.univdevs.mmorpg.bridge.MapCommand;
import fr.univdevs.mmorpg.bridge.StatsCommand;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.action.MoveCommand;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.cure.HealerCure;
import fr.univdevs.util.Vector2D;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The main application
 *
 * @author Loïc Payol
 */
public class App {
    private static GameManager gameManager;
    private static List<Player> players = new ArrayList<Player>();
    private static List<ActionCommand> actionCommands = new ArrayList<ActionCommand>();
    private static StatsCommand stats;
    private static InteractiveShell shell = new InteractiveShell(
        new ANSIString("Welcome to MMORPG Shell [version " + App.class.getPackage().getImplementationVersion() + "]\n", ANSIAttribute.ATTR_BOLD) +
            "Running JVM " + System.getProperty("java.version") + " on " + System.getProperty("os.name") +
            " (" + System.getProperty("os.arch") + ")\n" +
            "Type `help` for help on the shell\n"
    );

    private static void configureGame() throws Exception {
        Tilemap tilemap = Tilemap.newFromFilename("/game/maps/lvl-01.txt");
        World world = new World(tilemap);
        gameManager = new GameManager(world);

        // Registering players
        players.add(new Player("palra", new Warrior("nom-super-agressif")));

        for (Player p : players) {
            Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
            p.getCharacter().setX(pos.x);
            p.getCharacter().setY(pos.y);
            p.getCharacter().getDisplay()
                .addAttribute(ANSIAttribute.ATTR_BLINK)
                .addAttribute(ANSIAttribute.FG_RED);

            gameManager.addPlayer(p);
        }

        // And put some items
        Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
        HealerCure healerCure = new HealerCure();
        healerCure.setX(1);
        healerCure.setY(1);
        world.addEntity(healerCure);
    }

    private static void registerPlayerCommands(Player currentPlayer) {
        for (ActionCommand command : actionCommands)
            shell.remove(command);
        actionCommands.clear();

        // move
        MoveCommand move = new MoveCommand(currentPlayer);
        move.setGameManager(gameManager);
        actionCommands.add(move);

        for (ActionCommand command : actionCommands)
            shell.add(command);

        stats.setCurrentPlayer(currentPlayer);
    }

    private static boolean actionRegistered() {

        for (ActionCommand actionCommand : actionCommands)
            if (actionCommand.hasAction())
                return true;

        return false;
    }

    public static void main(String[] args) {
        try {
            App.configureGame();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

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

        // log
        LoggerCommand log = new LoggerCommand();
        log.setLogger(gameManager.getLogger());

        // stats
        stats = new StatsCommand();
        stats.setGameManager(gameManager);


        /*=======================
                 Shell
         =======================*/

        shell.add(exit);
        shell.add(help);
        shell.add(map);
        shell.add(log);
        shell.add(stats);

        boolean playTurn = false;
        Iterator<Player> iPlayers = null;
        Player currentPlayer = null;

        // The main loop
        while (!exit.isClosed()) {
            if (playTurn) {
                try {
                    gameManager.playTurn();
                    System.out.print(log.execute(new String[0]));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                playTurn = false; // Reset playTurn when executed.
            } else { // Ask each player what he wants to do.
                if (iPlayers == null)
                    iPlayers = players.iterator();

                if (currentPlayer == null) {
                    currentPlayer = iPlayers.next();
                    System.out.println(new ANSIString(currentPlayer.getName() + "'s turn : ", ANSIAttribute.ATTR_BOLD, ANSIAttribute.FG_MAGENTA));
                }

                registerPlayerCommands(currentPlayer);
                currentPlayer.getCharacter().getDisplay().addAttribute(ANSIAttribute.ATTR_BLINK).addAttribute(ANSIAttribute.ATTR_BOLD);
                shell.nextResult();

                if (actionRegistered()) {
                    currentPlayer.getCharacter().getDisplay().removeAttribute(ANSIAttribute.ATTR_BLINK).removeAttribute(ANSIAttribute.ATTR_BOLD);
                    currentPlayer = null;
                    playTurn = !iPlayers.hasNext(); // Execute turns when every player played.
                    if (playTurn)
                        iPlayers = null; // Reset the iterator, if no more players are in the array
                }
            }
        }

        // Goodbye, main(String... args) :)
    }
}
package fr.univdevs.mmorpg.game;

import fr.univdevs.commander.InteractiveShell;
import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;
import fr.univdevs.mmorpg.bridge.*;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.item.cure.HealerCure;
import fr.univdevs.mmorpg.game.item.weapon.Sword;
import fr.univdevs.util.Vector2D;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The main application
 *
 * @author Loïc Payol
 */
public class App {
    private static GameManager gameManager;
    private static List<ActionCommand> actionCommands = new ArrayList<ActionCommand>();
    private static StatsCommand stats;
    private static InventoryCommand items;
    private static ExitCommand exit;
    private static LoggerCommand log;
    private static CureCommand cure;
    private static FightCommand fight;
    private static InteractiveShell shell = new InteractiveShell(
        new ANSIString("Welcome to MMORPG Shell [version " + App.class.getPackage().getImplementationVersion() + "]\n", ANSIAttribute.ATTR_BOLD) +
            "Running JVM " + System.getProperty("java.version") + " on " + System.getProperty("os.name") +
            " (" + System.getProperty("os.arch") + ")\n" +
            "Type `help` for help on the shell\n"
    );

    /**
     * Initializes the game
     *
     * @throws IOException If the map was not found
     */
    private static void configureGame() throws IOException {
        Tilemap tilemap = Tilemap.newFromFilename("/game/maps/lvl-01.txt");
        World world = new World(tilemap);
        gameManager = new GameManager(world);

        for(Player p : Debut.init()) {
            gameManager.addPlayer(p);
        }

        for (Player p : gameManager.getPlayers()) {
            Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
            p.getCharacter().setX(pos.x);
            p.getCharacter().setY(pos.y);
            p.getCharacter().getDisplay()
                .addAttribute(ANSIAttribute.ATTR_BLINK)
                .addAttribute(ANSIAttribute.FG_RED);
        }

        // And put some items
        Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
        HealerCure healerCure = new HealerCure();
        Sword sword = new Sword();
        healerCure.setX(1);
        healerCure.setY(1);
        sword.setX(9);
        sword.setY(9);
        world.addEntity(healerCure);
        world.addEntity(sword);

    }

    /**
     * Initializes commands
     */
    private static void configureCommands() {
        // exit
        exit = new ExitCommand();

        // help
        HelpCommand help = new HelpCommand();

        // map
        MapCommand map = new MapCommand();
        map.setGameManager(gameManager);

        // log
        log = new LoggerCommand();
        log.setLogger(gameManager.getLogger());

        // stats
        stats = new StatsCommand();
        stats.setGameManager(gameManager);

        //fight
        fight = new FightCommand();
        actionCommands.add(fight);

        //cure
        cure = new CureCommand();
        actionCommands.add(cure);

        // items
        items = new InventoryCommand();

        // move
        MoveCommand move = new MoveCommand();
        actionCommands.add(move);

        // noop
        NoOpCommand noop = new NoOpCommand();
        actionCommands.add(noop);

        shell.add(exit);
        shell.add(help);
        shell.add(map);
        shell.add(log);
        shell.add(stats);
        shell.add(items);

        for (ActionCommand command : actionCommands) {
            command.setGameManager(gameManager);
            shell.add(command);
        }
    }

    /**
     * Registers the current player on the action commands and current player relative commands
     *
     * @param currentPlayer The current player to bind
     */
    private static void registerPlayerCommands(Player currentPlayer) {
        for (ActionCommand command : actionCommands)
            command.setCurrentPlayer(currentPlayer);

        stats.setCurrentPlayer(currentPlayer);
        items.setCurrentPlayer(currentPlayer);
        cure.setCurrentPlayer(currentPlayer);

    }

    /**
     * Main loop of the application
     */
    private static void play() {
        // The main loop
        Player oldPlayer = null;
        while (!exit.isClosed()) {
            Player currentPlayer = gameManager.getFirstPlayerWithoutAction();
            if (currentPlayer == null) { // If no more players have to play
                gameManager.playTurn();
                oldPlayer = null;
            } else {
                // Sets the current player on the commands
                registerPlayerCommands(currentPlayer);

                // Highlight the player on the map
                currentPlayer.getCharacter().getDisplay().addAttribute(ANSIAttribute.ATTR_BLINK).addAttribute(ANSIAttribute.ATTR_BOLD);

                if (oldPlayer != currentPlayer) {
                    System.out.println(new ANSIString(currentPlayer.getName() + "'s turn : ", ANSIAttribute.ATTR_BOLD, ANSIAttribute.FG_MAGENTA));
                }

                // Ask each player what he wants to do.
                shell.nextResult();

                // If an action was registered
                if (gameManager.getFirstPlayerWithoutAction() != currentPlayer) {
                    // Remove the highlight on the player
                    currentPlayer.getCharacter().getDisplay().removeAttribute(ANSIAttribute.ATTR_BLINK).removeAttribute(ANSIAttribute.ATTR_BOLD);
                }

                oldPlayer = currentPlayer;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        App.configureGame();
        App.configureCommands();
        App.play();
    }
}
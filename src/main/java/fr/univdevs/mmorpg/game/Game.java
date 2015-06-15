package fr.univdevs.mmorpg.game;

import fr.univdevs.commander.InteractiveShell;
import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;
import fr.univdevs.mmorpg.bridge.*;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.cure.HealerCure;
import fr.univdevs.util.Vector2D;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an instance of a console game
 */
public class Game implements Serializable {
    private GameManager gameManager;
    private List<ActionCommand> actionCommands;
    private transient InteractiveShell shell;
    private StatsCommand stats;
    private InventoryCommand items;
    private ExitCommand exit;
    private HelpCommand help;
    private MapCommand map;
    private LoggerCommand log;

    public Game() throws IOException {
        this.actionCommands = new ArrayList<ActionCommand>();
        this.configureGame();
        this.configureCommands();
        this.initShell();
        this.configureShell();
    }

    public static Game readFrom(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois;
        ois = new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream(
                    file)));

        Game game = (Game) ois.readObject();
        ois.close();

        game.initShell();
        game.configureShell();
        return game;
    }

    public static Game readFrom(String filename) throws IOException, ClassNotFoundException {
        return readFrom(new File(filename));
    }

    private void initShell() {
        this.shell = new InteractiveShell(
            new ANSIString("Welcome to MMORPG Shell [version " + App.class.getPackage().getImplementationVersion() + "]\n", ANSIAttribute.ATTR_BOLD) +
                "Running JVM " + System.getProperty("java.version") + " on " + System.getProperty("os.name") +
                " (" + System.getProperty("os.arch") + ")\n" +
                "Type `help` for help on the shell\n"
        );
    }

    /**
     * Initializes the game
     *
     * @throws IOException If the map was not found
     */
    private void configureGame() throws IOException {
        Tilemap tilemap = Tilemap.newFromFilename("/game/maps/lvl-01.txt");
        World world = new World(tilemap);
        this.gameManager = new GameManager(world);

        // Registering players
        this.gameManager.addPlayer(new Player("palra", new Warrior("nom-super-agressif")));


        for (Player p : this.gameManager.getPlayers()) {
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
        healerCure.setX(pos.x);
        healerCure.setY(pos.y);
        world.addEntity(healerCure);
    }

    /**
     * Initializes commands
     */
    private void configureCommands() {
        // exit
        this.exit = new ExitCommand();

        // help
        this.help = new HelpCommand();

        // map
        this.map = new MapCommand();
        this.map.setGameManager(gameManager);

        // log
        this.log = new LoggerCommand();
        this.log.setLogger(gameManager.getLogger());

        // stats
        this.stats = new StatsCommand();
        this.stats.setGameManager(gameManager);

        // items
        this.items = new InventoryCommand();

        // move
        MoveCommand move = new MoveCommand();
        this.actionCommands.add(move);

        // noop
        NoOpCommand noop = new NoOpCommand();
        this.actionCommands.add(noop);
    }

    private void configureShell() {

        this.shell.add(this.exit);
        this.shell.add(this.help);
        this.shell.add(this.map);
        this.shell.add(this.log);
        this.shell.add(this.stats);
        this.shell.add(this.items);

        for (ActionCommand command : this.actionCommands) {
            command.setGameManager(this.gameManager);
            this.shell.add(command);
        }
    }

    /**
     * Registers the current player on the action commands and current player relative commands
     *
     * @param currentPlayer The current player to bind
     */
    private void registerPlayerCommands(Player currentPlayer) {
        for (ActionCommand command : this.actionCommands)
            command.setCurrentPlayer(currentPlayer);

        stats.setCurrentPlayer(currentPlayer);
        items.setCurrentPlayer(currentPlayer);
    }

    /**
     * Main loop of the application
     */
    public void play() {
        // The main loop
        Player oldPlayer = null;
        while (!this.exit.isClosed()) {
            if (oldPlayer == null) // If its the begining of a round
                System.out.println("Starting the " + new ANSIString("round n°" + this.gameManager.getRoundNb() + "", ANSIAttribute.ATTR_BOLD, ANSIAttribute.FG_CYAN) + " :");
            Player currentPlayer = this.gameManager.getFirstPlayerWithoutAction();
            if (currentPlayer == null) { // If no more players have to play
                this.gameManager.playTurn();
                oldPlayer = null;
            } else {
                // Sets the current player on the commands
                registerPlayerCommands(currentPlayer);

                // Highlight the player on the map
                currentPlayer.getCharacter().getDisplay().addAttribute(ANSIAttribute.ATTR_BLINK).addAttribute(ANSIAttribute.ATTR_BOLD);

                if (oldPlayer != currentPlayer) {
                    System.out.println(new ANSIString(currentPlayer.getName(), ANSIAttribute.ATTR_BOLD, ANSIAttribute.FG_MAGENTA) + "'s turn : ");
                }

                // Ask each player what he wants to do.
                this.shell.nextResult();

                // If an action was registered
                if (this.gameManager.getFirstPlayerWithoutAction() != currentPlayer) {
                    // Remove the highlight on the player
                    currentPlayer.getCharacter().getDisplay().removeAttribute(ANSIAttribute.ATTR_BLINK).removeAttribute(ANSIAttribute.ATTR_BOLD);
                }

                oldPlayer = currentPlayer;
            }
        }

        this.exit.setClosed(false); // Reset the commands, so once saved, the command does not quit the program
    }


    public void saveTo(String filename) throws IOException {
        saveTo(new File(filename));
    }

    public void saveTo(File file) throws IOException {
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream(
                    file)));

        oos.writeObject(this);
        oos.close();
    }
}

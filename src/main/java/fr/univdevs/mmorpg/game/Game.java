package fr.univdevs.mmorpg.game;

import fr.univdevs.commander.CommandParser;
import fr.univdevs.commander.InteractiveShell;
import fr.univdevs.commander.userworld.AliasManagerCommand;
import fr.univdevs.commander.userworld.ExitCommand;
import fr.univdevs.commander.userworld.HelpCommand;
import fr.univdevs.mmorpg.bridge.*;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.item.cure.HealerCure;
import fr.univdevs.mmorpg.game.item.cure.HyperPotion;
import fr.univdevs.mmorpg.game.item.cure.Potion;
import fr.univdevs.mmorpg.game.item.cure.SuperPotion;
import fr.univdevs.mmorpg.game.item.protection.Armor;
import fr.univdevs.mmorpg.game.item.protection.Helmet;
import fr.univdevs.mmorpg.game.item.protection.Shield;
import fr.univdevs.mmorpg.game.item.weapon.Bow;
import fr.univdevs.mmorpg.game.item.weapon.Knife;
import fr.univdevs.mmorpg.game.item.weapon.Sword;
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
    private CommandParser parser;
    private StatsCommand stats;
    private InventoryCommand items;
    private AliasManagerCommand aliases;
    private ExitCommand exit;
    private HelpCommand help;
    private MapCommand map;
    private FightCommand fight;
    private CureCommand cure;
    private LoggerCommand log;
    private PlayersCommand players;
    private DropCommand drop;

    public Game() throws IOException {
        this.actionCommands = new ArrayList<ActionCommand>();
        this.parser = new CommandParser();
        this.configureGame();
        this.configureCommands();
    }

    public static Game readFrom(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois;
        ois = new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream(
                    file)));

        Game game = (Game) ois.readObject();
        ois.close();

        return game;
    }

    public static Game readFrom(String filename) throws IOException, ClassNotFoundException {
        return readFrom(new File(filename));
    }

    public GameManager getGameManager() {
        return gameManager;
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
    }

    /**
     * Randomizes the positions of the players
     */
    public void randomizePlayersPosition() {
        GameManager gm = this.getGameManager();
        Tilemap tilemap = gm.getWorld().getTilemap();
        for(Player p : gm.getPlayers()) {
            Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
            p.getCharacter().setX(pos.x);
            p.getCharacter().setY(pos.y);
            p.getCharacter().getDisplay().addAttribute(ANSIAttribute.FG_RED);
        }
    }

    /**
     * Add random items on the world
     */
    public void addRandomItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Sword());
        items.add(new Knife());
        items.add(new Bow());
        items.add(new Helmet());
        items.add(new Armor());
        items.add(new Shield());
        items.add(new HealerCure());
        items.add(new Potion());
        items.add(new SuperPotion());
        items.add(new HyperPotion());

        GameManager gm = this.getGameManager();
        Tilemap tilemap = gm.getWorld().getTilemap();
        for (Item i : items) {
            Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
            i.setX(pos.x);
            i.setY(pos.y);
            gm.getWorld().addEntity(i);
        }
    }

    /**
     * Initializes commands
     */
    private void configureCommands() {
        // exit
        this.exit = new ExitCommand();

        // help
        this.help = new HelpCommand();

        // aliases
        this.aliases = new AliasManagerCommand();

        // map
        this.map = new MapCommand();
        this.map.setGameManager(this.gameManager);

        //drop
        this.drop = new DropCommand();
        this.drop.setGameManager(this.gameManager);

        // log
        this.log = new LoggerCommand();
        this.log.setLogger(this.gameManager.getLogger());

        // stats
        this.stats = new StatsCommand();
        this.stats.setGameManager(this.gameManager);

        // items
        this.items = new InventoryCommand();

        // players
        this.players = new PlayersCommand();
        this.players.setGameManager(this.gameManager);

        // fight
        this.fight = new FightCommand();
        this.fight.setGameManager(this.gameManager);

        // cure
        this.cure = new CureCommand();
        this.cure.setGameManager(this.gameManager);

        // move
        MoveCommand move = new MoveCommand();
        this.actionCommands.add(move);

        // noop
        NoOpCommand noop = new NoOpCommand();
        this.actionCommands.add(noop);


        this.parser.add(this.exit);
        this.parser.add(this.help);
        this.parser.add(this.aliases);
        this.parser.add(this.map);
        this.parser.add(this.log);
        this.parser.add(this.stats);
        this.parser.add(this.items);
        this.parser.add(this.fight);
        this.parser.add(this.cure);
        this.parser.add(this.players);
        this.parser.add(this.drop);

        for (ActionCommand command : this.actionCommands) {
            command.setGameManager(this.gameManager);
            this.parser.add(command);
        }
    }

    /**
     * Starts the shell
     */
    private void launchShell() {
        this.shell = new InteractiveShell(parser,
            new ANSIString("Welcome to MMORPG Shell [version " + App.class.getPackage().getImplementationVersion() + "]\n", ANSIAttribute.ATTR_BOLD) +
                "Running JVM " + System.getProperty("java.version") + " on " + System.getProperty("os.name") +
                " (" + System.getProperty("os.arch") + ")\n" +
                "Type `help` for help on the shell\n"
        );
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
        drop.setCurrentPlayer(currentPlayer);
        fight.setCurrentPlayer(currentPlayer);
        cure.setCurrentPlayer(currentPlayer);
    }

    /**
     * Main loop of the application
     */
    public void play() {
        // Launch the shell
        this.launchShell();

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


    /**
     * Saves the game in the given file. Will overwrite any existing file.
     *
     * @param filename The name of the file
     * @throws IOException
     */
    public void saveTo(String filename) throws IOException {
        saveTo(new File(filename));
    }

    /**
     * Saves the game in the given file. Will overwrite any existing file.
     *
     * @param file The file
     * @throws IOException
     */
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

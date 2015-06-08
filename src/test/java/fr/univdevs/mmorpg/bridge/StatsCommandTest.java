package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by palra on 04/06/15.
 */
public class StatsCommandTest {
    private CommandParser parser;
    private GameManager gm;
    private StatsCommand sc;
    private Player player;

    @Before
    public void setUp() throws Exception {
        gm = new GameManager(new World(new Tilemap(1)));
        player = new Player("palra", new Warrior("medor"));
        gm.addPlayer(player);

        sc = new StatsCommand();
        sc.setCurrentPlayer(gm.getPlayerByName("palra"));

        sc.setGameManager(gm);

        parser = new CommandParser(new Command[]{sc});
    }

    @Test
    public void testStats() throws Exception {
        assertEquals("Stats for player `" + new ANSIString("palra", ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) + "` : \n" +
            "-----------------------------\n" +
            " - Type : Warrior\n" +
            " - Vie : 100 HP\n" +
            " - Experience : 0 XP \n" +
            " - Points d'action : 0 AP \n" +
            " - Vitesse : 0\n" +
            " - Résistance : 0.0\n" +
            " - Argent : " + player.getCharacter().getMoney() + "£ \n", parser.parse("stats").getOutput());
    }

    @Test(expected = StatsCommand.PlayerNotFoundException.class)
    public void testNotFound() throws Exception {
        parser.parse("stats unknown-player");
    }
}
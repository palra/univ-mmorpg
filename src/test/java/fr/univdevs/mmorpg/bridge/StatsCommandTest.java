package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
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

    @Before
    public void setUp() throws Exception {
        gm = new GameManager(new World(new Tilemap(1)));
        gm.addPlayer(new Player("palra", new Warrior("medor")));

        sc = new StatsCommand();
        sc.setCurrentPlayerName("palra");

        sc.setGameManager(gm);

        parser = new CommandParser(new Command[]{sc});
    }

    @Test
    public void testStats() throws Exception {
        assertEquals("Stats for player `palra` : \n" +
            "-----------------------------\n" +
            " - Type : Warrior\n" +
            " - Vie : 100 HP\n" +
            " - Experience : 0 XP \n" +
            " - action Points : 0 AP \n" +
            " - Vitesse : 0\n" +
            " - Résistance : 0.0\n" +
            " - Argent : 0£ \n", parser.parse("stats").getOutput());
    }

    @Test(expected = StatsCommand.PlayerNotFoundException.class)
    public void testNotFound() throws Exception {
        parser.parse("stats unknown-player");
    }
}
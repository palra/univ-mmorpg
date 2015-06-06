package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.CommandParser;
import fr.univdevs.commander.ParserResult;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by palra on 06/06/15.
 */
public class MapCommandTest {

    private GameManager gameManager;
    private World world;
    private Tilemap tilemap;
    private List<Player> players;
    private MapCommand map;
    private CommandParser parser;

    @Before
    public void setUp() throws Exception {
        tilemap = Tilemap.newFromFilename("/game/maps/test-lvl-01.txt");
        world = new World(tilemap);
        gameManager = new GameManager(world);

        Player p = new Player("palra", new Warrior("nom-super-agressif"));
        p.getCharacter().setX(1);
        p.getCharacter().setY(1);
        gameManager.addPlayer(p);

        map = new MapCommand();
        map.setGameManager(gameManager);

        parser = new CommandParser();
        parser.add(map);
    }

    @Test
    public void testExecute() throws Exception {
        ParserResult res = parser.parse("map");
        assertEquals("###\n" +
            "#N#\n" +
            "###\n", res.getOutput());
    }

    @Test
    public void testNoEntity() throws Exception {
        ParserResult res = parser.parse("map --map-only");
        assertEquals("###\n" +
            "# #\n" +
            "###\n", res.getOutput());
    }
}
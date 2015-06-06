package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.CommandParser;
import fr.univdevs.commander.ParserResult;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.util.Vector2D;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        tilemap = Tilemap.newFromFilename("/game/maps/lvl-01.txt");
        world = new World(tilemap);
        gameManager = new GameManager(world);

        players = new ArrayList<Player>();

        // Registering players
        players.add(new Player("palra", new Warrior("nom-super-agressif")));

        for (Player p : players) {
            Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
            p.getCharacter().setX(pos.x);
            p.getCharacter().setY(pos.y);
            gameManager.addPlayer(p);
        }

        map = new MapCommand();
        map.setGameManager(gameManager);

        parser = new CommandParser();
        parser.add(map);
    }

    @Test
    public void testExecute() throws Exception {
        ParserResult res = parser.parse("map");
    }
}
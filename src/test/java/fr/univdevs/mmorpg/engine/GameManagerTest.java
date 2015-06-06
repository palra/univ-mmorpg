package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine._mocks.NoOpAction;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by palra on 01/06/15.
 */
public class GameManagerTest {
    private GameManager gm;

    @Before
    public void setUp() throws Exception {
        gm = new GameManager(new World(new Tilemap(1)));
    }

    @Test
    public void testTurn() throws Exception {
        Player drattak = new Player("drattak", new Warrior("bobby"));
        Player palra = new Player("palra", new Warrior("tamaman"));
        Player p3 = new Player("player3", new Warrior("tonpapa"));

        gm.addPlayer(drattak);
        gm.addPlayer(palra);
        gm.addPlayer(p3);

        drattak.setNextAction(new NoOpAction(drattak, null));
        palra.setNextAction(new NoOpAction(drattak, null));
        p3.setNextAction(new NoOpAction(drattak, null));

        gm.playTurn();

        // TODO : incomplete
    }
}
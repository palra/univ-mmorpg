package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.character._mocks.Warrior;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by palra on 01/06/15.
 */
public class PlayerTest {
    @Test
    public void testPlayerComparator() throws Exception {
        List<Player> players = new ArrayList<Player>();

        Player drattak = new Player("drattak", new Warrior("bobby"));
        Player palra = new Player("palra", new Warrior("tamaman"));
        Player p3 = new Player("player3", new Warrior("tonpapa"));

        drattak.getCharacter().addSpeed(150);
        p3.getCharacter().addSpeed(120);
        palra.getCharacter().addSpeed(25);

        players.add(drattak);
        players.add(palra);
        players.add(p3);

        Collections.sort(players, Player.SORT_BY_SPEED_DESC);

        assertTrue(players.get(0) == drattak);
        assertTrue(players.get(1) == p3);
        assertTrue(players.get(2) == palra);
    }
}
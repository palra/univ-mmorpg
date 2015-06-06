package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.util.Vector2D;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by palra on 06/06/15.
 */
public class TilemapTest {
    private Tilemap tilemap;

    @Before
    public void setUp() throws Exception {
        tilemap = Tilemap.newFromFilename("/game/maps/test-lvl-01.txt");
    }

    @Test
    public void testEmpty() throws Exception {
        assertTrue(tilemap.isEmptyAt(1, 1));
        assertFalse(tilemap.isEmptyAt(0, 2));
    }

    @Test
    public void testRandomPosition() throws Exception {
        Vector2D<Integer> pos = tilemap.getEmptyRandomPosition();
        assertEquals(1, (int) pos.x);
        assertEquals(1, (int) pos.y);
    }
}
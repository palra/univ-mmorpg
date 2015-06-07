package fr.univdevs.mmorpg.engine.world;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by drattak on 07/06/15.
 */
public class TilemapTest {

    @Test
    public void testTilemap() throws Exception {
        char[] c = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '\n', '#', '#', '\n'};
        Tilemap t = new Tilemap(5, 10);
        //t.render();
        //System.out.println(t.getSize());
        t.setTile(1, 5, 'f');
        //t.render();
    }

}
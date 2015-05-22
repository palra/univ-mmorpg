package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.character.mocks.Bow;
import fr.univdevs.mmorpg.engine.character.mocks.Potion;
import fr.univdevs.mmorpg.engine.character.mocks.SuperPotion;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for all inventory-relative objects
 */
public class InventoryTest {
    private Inventory inventory;
    @Before
    public void setUp() throws Exception {
        this.inventory = new Inventory();
    }

    @Test
    public void testAdd() throws Exception {
        Potion p = new Potion("potion","cure",9,9,34);
        inventory.add(p);
    }

    @Test
    public void testGetByType() throws Exception {
        Potion p = new Potion("potion", "cure", 9, 9, 34);
        SuperPotion sp = new SuperPotion("supotion", "cure", 9, 9, 34);
        Bow bow = new Bow("bow", "weapon", 10, 3, 4);
        inventory.add(p);
        inventory.add(sp);
        inventory.add(bow);
        for (int i = 0; i < inventory.getByType("cure").length; i++) {
            System.out.println(inventory.getByType("cure")[i].getName());
        }

    }

    @Test
    public void testTilemap() throws Exception {
        char[] c = {'#', '#', '#', '#', '#', '#', '#', '#', '\n', '#', '#', '#', '#', '\n', '#', '#', '\n'};
        Tilemap t = new Tilemap(c);
        t.render();
    }
}

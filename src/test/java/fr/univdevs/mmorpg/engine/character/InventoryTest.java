package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.character.mocks.Potion;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by drattak on 21/05/15.
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
        ;

    }
}

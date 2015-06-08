package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.weapon.Bow;
import fr.univdevs.mmorpg.game.item.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for all inventory-relative objects
 */
public class InventoryTest {
    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
        this.inventory = new Inventory(new Warrior("drattak"));
    }

    @Test
    public void testAdd() throws Exception {
    }

    @Test
    public void testGetByType() throws Exception {
        Bow bow = new Bow();
        inventory.add(bow);
        for (int i = 0; i < inventory.getByType("cure").length; i++) {
            System.out.println(inventory.getByType("cure")[i].getID());
        }

    }

}

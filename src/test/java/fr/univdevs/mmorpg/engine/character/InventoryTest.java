package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.weapon.Bow;
import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void testGetByType() throws Exception {
        Bow bow = new Bow("weapon", 10, 3);
        inventory.add(bow);
        for (int i = 0; i < inventory.getByType("cure").length; i++) {
            System.out.println(inventory.getByType("cure")[i].getID());
        }

    }

    @Test
    public void testCharacter() throws Exception {
        Player drattak = new Player("drattak");
        Character chardrattak = new Warrior("chardrattak");
        drattak.setCharacter(chardrattak);
        Bow bower = new Bow("Bow", 20, 20);
        Bow bbbbow = new Bow("Bow", 29, 20);

        drattak.getCharacter().getInventory().add(bower);
        drattak.getCharacter().getInventory().add(bbbbow);
        System.out.println(drattak.getCharacter().getInventory().toString());
        for (int i = 0; i < Item.getIds().size(); i++) {
            System.out.println(Item.getIds().get(i));
        }
    }
}

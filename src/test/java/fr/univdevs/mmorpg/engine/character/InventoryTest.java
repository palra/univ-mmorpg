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

    @Test()
    public void testCharacter() throws Exception {
        Player drattak = new Player("drattak");
        Player palra = new Player("palra");

        Character chardrattak = new Warrior("chardrattak");
        drattak.setCharacter(chardrattak);
        Bow bower = new Bow();
        Bow bbbbow = new Bow();
        Sword sw = new Sword();
        Sword sw1 = new Sword();
        Sword sw0 = new Sword();

        drattak.getCharacter().getInventory().add(sw);
        System.out.println(drattak.getCharacter().getMoney());
        drattak.getCharacter().getInventory().add(sw1);
        System.out.println(drattak.getCharacter().getMoney());
        drattak.getCharacter().getInventory().add(sw0);
        System.out.println(drattak.getCharacter().getMoney());

        drattak.getCharacter().getInventory().add(bbbbow);
    }
}

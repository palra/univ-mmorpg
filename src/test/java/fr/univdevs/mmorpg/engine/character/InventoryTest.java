package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.action.FightAction;
import fr.univdevs.mmorpg.engine.world.Tilemap;
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
        Potion p = new Potion("potion", "cure", 9, 9);
        inventory.add(p);
    }

    @Test
    public void testGetByType() throws Exception {
        Potion p = new Potion("potion", "cure", 9, 9);
        SuperPotion sp = new SuperPotion("supotion", 9, 9);
        Bow bow = new Bow("bow", "weapon", 10, 3, 4);
        inventory.add(p);
        inventory.add(sp);
        inventory.add(bow);
        /*for (int i = 0; i < inventory.getByType("cure").length; i++) {
            System.out.println(inventory.getByType("cure")[i].getName());
        }*/

    }

    @Test
    public void testTilemap() throws Exception {
        char[] c = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '\n', '#', '#', '\n'};
        Tilemap t = new Tilemap(c);
        //t.render();
        //System.out.println(t.getSize());
        t.setTile(1, 5, 'f');
        //t.render();
    }

    @Test
    public void testCharacter() throws Exception {
        Player drattak = new Player("drattak");
        Character c = new Warrior("dratwarrior");
        Character d = new Warrior("enemy");
        Potion p = new Potion("potion", "Potion", 20, 20);
        SuperPotion sp = new SuperPotion("superpotion", 30, 30);
        drattak.setCharacter(c);
        FightAction f = new FightAction(c, d);

        drattak.getCharacter().getInventory().add(p);
        drattak.getCharacter().getInventory().add(sp);
        drattak.setNextAction(f);
        System.out.println(drattak.getNextAction().toString());
    }
}

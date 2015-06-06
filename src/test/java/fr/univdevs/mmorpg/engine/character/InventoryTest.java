package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.game.action.FightAction;
import fr.univdevs.mmorpg.game.action.MoveAction;
import fr.univdevs.mmorpg.game.character.Healer;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.cure.HealerCure;
import fr.univdevs.mmorpg.game.item.weapon.Bow;
import fr.univdevs.mmorpg.game.item.weapon.Knife;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for all inventory-relative objects
 */
public class InventoryTest {
    private Inventory inventory;
    @Before
    public void setUp() throws Exception {
        Character charactTest = new Warrior("Character");
        this.inventory = new Inventory(charactTest);
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


    @Test
    public void testCharacter() throws Exception {
        Player drattak = new Player("drattak");
        Player palra = new Player("palra");

        Character chardrattak = new Warrior("chardrattak");
        Character charplara = new Healer("charpalra");

        drattak.setCharacter(chardrattak);
        palra.setCharacter(charplara);

        Bow bower = new Bow();
        Bow bbbbow = new Bow();

        Knife knife = new Knife();
        HealerCure hc = new HealerCure();

        drattak.getCharacter().getInventory().add(bower);
        drattak.getCharacter().getInventory().add(bbbbow);
    }

}

package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.mocks.*;
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
        Bow bow = new Bow("bow", "weapon", 10, 3);
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
        Player palra = new Player("drattak");

        Character c = new Warrior("dratwarrior");
        Character d = new Warrior("palwarrior");

        Potion potion1 = new Potion("potion", "Potion", 20, 20);
        Potion potion2 = new Potion("potion2", "Potion", 20, 20);

        Bow bow1 = new Bow("bow1", "Bow", 20, 20);
        Bow bow2 = new Bow("bow2", "Bow", 20, 20);

        LittleSpell ls = new LittleSpell("Spell", "LittleSpell");

        drattak.setCharacter(c);
        palra.setCharacter(d);
/*
        drattak.getCharacter().getInventory().add(potion1);
        drattak.getCharacter().getInventory().add(bow1);
        palra.getCharacter().getInventory().add(potion2);
        palra.getCharacter().getInventory().add(bow2);

        drattak.getCharacter().getInventory().add(ls);


        FightAction fight1 = new FightAction(drattak.getCharacter(), palra.getCharacter());
        CureAction cure = new CureAction(drattak.getCharacter(), drattak.getCharacter());
        SpellAction spell = new SpellAction(drattak.getCharacter(), palra.getCharacter());

        cure.setCure(potion1);  //Indispensable pour executer l'action
        spell.setSpell(ls);


        fight1.setWeapon(bow1);

        MoveAction m = new MoveAction(drattak.getCharacter());
        //m.execute();
        System.out.println(palra.getCharacter().getHealth());
        try {
            spell.execute();
        } catch (NullPointerException e) {
            System.out.println("Pas de sort choisi!");
        }

        System.out.println(palra.getCharacter().getHealth()); //on vérifie que le perso de palra a perdu des points
        */
    }
}

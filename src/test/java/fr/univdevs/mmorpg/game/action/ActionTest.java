package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.cure.HyperPotion;
import fr.univdevs.mmorpg.game.item.cure.Potion;
import fr.univdevs.mmorpg.game.item.protection.Armor;
import fr.univdevs.mmorpg.game.item.protection.Helmet;
import fr.univdevs.mmorpg.game.item.protection.Shield;
import fr.univdevs.mmorpg.game.item.weapon.Bow;
import fr.univdevs.mmorpg.game.item.weapon.Sword;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Public TestClass for Action
 * Will test all the actions
 */


public class ActionTest {
    Player drattak = new Player("drattak");
    Player palra = new Player("palra");

    Character dCharacter = new Warrior("DrattakCharacter");
    Character pCharacter = new Warrior("PalraCharacter");

    Bow bow = new Bow();
    Bow bow2 = new Bow();

    Sword sw = new Sword();

    HyperPotion hp = new HyperPotion();
    Potion p = new Potion();

    Shield sh = new Shield();
    Helmet h = new Helmet();
    Armor a = new Armor();

    @Test
    public void testActions() throws Exception {
        drattak.setCharacter(dCharacter);
        drattak.getCharacter().getInventory().add(sw);
        palra.setCharacter(pCharacter);
        palra.getCharacter().getInventory().add(a);

        FightAction fa = new FightAction(drattak, palra, sw);

        GameManager gm = new GameManager(new World(new Tilemap(new char[0], 0, 0)));

        fa.setGameManager(gm);
        fa.execute();

        assertEquals(90, palra.getCharacter().getHealth());



    }


    public String showHP() {
        return "Points de vie de drattak : " + drattak.getCharacter().getHealth() + "\nPoints de vie de palra : " + palra.getCharacter().getHealth();
    }


}
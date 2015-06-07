package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.cure.HyperPotion;
import fr.univdevs.mmorpg.game.item.cure.Potion;
import fr.univdevs.mmorpg.game.item.protection.Helmet;
import fr.univdevs.mmorpg.game.item.protection.Shield;
import fr.univdevs.mmorpg.game.item.weapon.Bow;
import org.junit.Before;
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

    HyperPotion hp = new HyperPotion();
    Potion p = new Potion();

    Shield sh = new Shield();
    Helmet h = new Helmet();

    @Test
    public void testActions() throws Exception {
        drattak.setCharacter(dCharacter);
        palra.setCharacter(pCharacter);
        palra.getCharacter().useItem(sh);
        palra.getCharacter().useItem(h);

        FightAction fa = new FightAction(drattak, palra, bow);
        CureAction ca = new CureAction(drattak, palra, p);

        Logger l = new Logger();
        fa.setLogger(l);
        fa.execute();


        //ca.setLogger(l);
        //ca.execute();

        System.out.println(showHP());
    }


    public String showHP() {
        return "Points de vie de drattak : " + drattak.getCharacter().getHealth() + "\nPoints de vie de palra : " + palra.getCharacter().getHealth();
    }


}
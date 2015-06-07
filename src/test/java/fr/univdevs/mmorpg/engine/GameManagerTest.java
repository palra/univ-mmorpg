package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.game.action.FightAction;
import fr.univdevs.mmorpg.game.action.NoOpAction;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.mmorpg.game.item.weapon.Bow;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by palra on 01/06/15.
 */
public class GameManagerTest {
    private GameManager gm;

    @Before
    public void setUp() throws Exception {
        gm = new GameManager();
    }

    @Test
    public void testTurn() throws Exception {
        Player drattak = new Player("drattak", new Warrior("bobby"));
        Player palra = new Player("palra", new Warrior("tamaman"));
        Player p3 = new Player("player3", new Warrior("tonpapa"));

        gm.addPlayer(drattak);
        gm.addPlayer(palra);
        gm.addPlayer(p3);

        drattak.setNextAction(new NoOpAction(drattak, null));
        palra.setNextAction(new NoOpAction(drattak, null));
        p3.setNextAction(new NoOpAction(drattak, null));
        System.out.println(palra.getCharacter().getHealth());
        drattak.setNextAction(new FightAction(drattak, palra, new Bow()));

        gm.playTurn();

        System.out.println(palra.getCharacter().getHealth());


        // TODO : incomplete
    }
}
package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.Character;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by palra on 31/05/15.
 */
public class NoOpActionTest {

    @Test
    public void testExecute() throws Exception {
        Character c1 = new Character("Médor", "Chien") {
            public String getDisplay() {
                return "c";
            }

            public boolean isCollidable() {
                return true;
            }
        };

        Character c2 = new Character("Médor", "Chien") {
            public String getDisplay() {
                return "c";
            }

            public boolean isCollidable() {
                return true;
            }
        };

        NoOpAction act = new NoOpAction(c1, c2);
        act.execute();

        assertTrue(c1.equals(c2));
    }
}
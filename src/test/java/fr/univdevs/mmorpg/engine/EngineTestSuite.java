package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.action.NoOpActionTest;
import fr.univdevs.mmorpg.engine.character.InventoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    InventoryTest.class,
    NoOpActionTest.class
})

/**
 * Created by drattak on 21/05/15.
 */
public class EngineTestSuite {
}

package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine._mocks.NoOpAction;
import fr.univdevs.mmorpg.engine.logger.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by palra on 03/06/15.
 */
public class LoggerCommandTest {
    private CommandParser parser;
    private LoggerCommand lc;
    private Logger l;

    @Before
    public void setUp() throws Exception {
        l = new Logger();
        lc = new LoggerCommand();
        lc.setLogger(l);
        lc.setLogFormat("<%2$s.%3$s>: %4$s");

        parser = new CommandParser(new Command[]{lc});
    }

    @Test
    public void testAll() throws Exception {
        l.log(new NoOpAction.NoOpEvent(new Player("palra")));
        l.log(new NoOpAction.NoOpEvent(new Player("drattak")));

        assertEquals("<action.noop>: palra passe son tour\n" +
            "<action.noop>: drattak passe son tour\n", parser.parse("log --all").getOutput());

        l.log(new NoOpAction.NoOpEvent(new Player("drattak")));

        assertEquals("<action.noop>: palra passe son tour\n" +
            "<action.noop>: drattak passe son tour\n" +
            "<action.noop>: drattak passe son tour\n", parser.parse("log --all").getOutput());
    }


    @Test
    public void testSinceLast() throws Exception {
        l.log(new NoOpAction.NoOpEvent(new Player("palra")));
        l.log(new NoOpAction.NoOpEvent(new Player("drattak")));

        assertEquals("<action.noop>: palra passe son tour\n" +
            "<action.noop>: drattak passe son tour\n", parser.parse("log").getOutput());

        l.log(new NoOpAction.NoOpEvent(new Player("drattak")));
        l.log(new NoOpAction.NoOpEvent(new Player("palra")));

        assertEquals("<action.noop>: drattak passe son tour\n" +
            "<action.noop>: palra passe son tour\n", parser.parse("log").getOutput());

        assertEquals("", parser.parse("log").getOutput());
    }
}
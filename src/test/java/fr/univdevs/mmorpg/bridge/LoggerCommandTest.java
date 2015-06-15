package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.CommandParser;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.event.action.NoOpEvent;
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
        lc.setLogFormat("<%3$s.%4$s>: %5$s");

        parser = new CommandParser(lc);
    }

    @Test
    public void testAll() throws Exception {
        l.log(new NoOpEvent(new Player("palra")));
        l.log(new NoOpEvent(new Player("drattak")));

        assertEquals(2, parser.parse("log " + LoggerCommand.ALL_OPT).getOutput().split("\n").length);

        l.log(new NoOpEvent(new Player("drattak")));

        assertEquals(3, parser.parse("log " + LoggerCommand.ALL_OPT).getOutput().split("\n").length);
    }

    @Test
    public void testSinceLast() throws Exception {
        l.log(new NoOpEvent(new Player("palra")));
        l.log(new NoOpEvent(new Player("drattak")));

        assertEquals(2, parser.parse("log").getOutput().split("\n").length);

        l.log(new NoOpEvent(new Player("drattak")));
        l.log(new NoOpEvent(new Player("palra")));

        assertEquals(2, parser.parse("log").getOutput().split("\n").length);

        assertEquals(LoggerCommand.NOT_FOUND_MSG, parser.parse("log " + LoggerCommand.SINCE_LAST_OPT).getOutput());
    }

    @Test
    public void testTail() throws Exception {
        for (int i = 0; i < 20; i++) {
            l.log(new NoOpEvent(new Player("palra")));
        }

        assertEquals(LoggerCommand.DEFAULT_NB_LOGS, parser.parse("log tail").getOutput().split("\n").length);
        assertEquals(5, parser.parse("log tail 5").getOutput().split("\n").length);
    }
}
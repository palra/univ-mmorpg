package fr.univdevs.mmorpg.cmd_bridge;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine._mocks.NoOpAction;
import fr.univdevs.mmorpg.engine.logger.Logger;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by palra on 03/06/15.
 */
public class LoggerCommandTest {

    @Test
    public void testExecute() throws Exception {
        Logger l = new Logger();
        l.log(new NoOpAction.NoOpEvent(new Date(1423162972000L), new Player("palra")));
        l.log(new NoOpAction.NoOpEvent(new Date(1423162972000L), new Player("drattak")));

        LoggerCommand lc = new LoggerCommand();
        lc.setLogger(l);

        CommandParser parser = new CommandParser(new Command[]{lc});
        assertEquals("[05/02/15 20:02:52] <action.noop>: palra passe son tour\n" +
            "[05/02/15 20:02:52] <action.noop>: drattak passe son tour\n", parser.parse("log").getOutput());
    }
}
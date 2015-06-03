package fr.univdevs.commander.userworld;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by palra on 25/05/15.
 */
public class ExitCommandTest {
    @Test
    public void testExit() throws Exception {
        ExitCommand exit = new ExitCommand();
        exit.setClosed(true);

        assertTrue(exit.isClosed());
    }

    @Test
    public void testParserInt() throws Exception {
        ExitCommand exit = new ExitCommand();
        CommandParser parser = new CommandParser(new Command[]{exit});

        parser.parse("exit");
        assertTrue(exit.isClosed());
    }

    @Test
    public void testAltConstructor() throws Exception {
        String altName = "foo";
        ExitCommand exit = new ExitCommand(altName);
        CommandParser parser = new CommandParser(new Command[]{exit});

        parser.parse(altName);
        assertTrue(exit.isClosed());
    }
}

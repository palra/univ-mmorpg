package fr.univdevs.commander.userworld;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * HelpCommandTest
 */
public class HelpCommandTest {
    @Test
    public void testHelp() throws Exception {
        HelpCommand help = new HelpCommand();
        CommandParser parser = new CommandParser(new Command[]{help, new ExitCommand()});

        String out = parser.parse("help").getOutput();
        assertEquals("help\nexit\n", out);
    }

    @Test
    public void testAltConstructor() throws Exception {
        String altName = "foo";
        HelpCommand help = new HelpCommand(altName);
        CommandParser parser = new CommandParser(new Command[]{help, new ExitCommand()});

        String out = parser.parse(altName).getOutput();
        assertEquals("foo\nexit\n", out);
    }

    @Test
    public void testWithDescription() throws Exception {
        HelpCommand help = new HelpCommand();
        CommandParser parser = new CommandParser(new Command[]{help, new ExitCommand()});

        String out = parser.parse("help --with-desc").getOutput();
        assertEquals("help [--with-desc]\nexit\n", out);
    }
}
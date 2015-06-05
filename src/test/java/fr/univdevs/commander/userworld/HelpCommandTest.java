package fr.univdevs.commander.userworld;

import fr.univdevs.commander.Command;
import fr.univdevs.commander.CommandParser;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * HelpCommandTest
 */
public class HelpCommandTest {
    @Test
    public void testHelp() throws Exception {
        HelpCommand help = new HelpCommand();
        CommandParser parser = new CommandParser(new Command[]{help, new ExitCommand()});

        String out = parser.parse("help").getOutput();
        assertTrue(out.contains("help [--without-desc]"));
        assertTrue(out.contains("exit"));
        assertEquals(2, out.split("\n").length);
    }

    @Test
    public void testAltConstructor() throws Exception {
        String altName = "foo";
        HelpCommand help = new HelpCommand(altName);
        CommandParser parser = new CommandParser(new Command[]{help, new ExitCommand()});

        String out = parser.parse(altName).getOutput();
        assertTrue(out.contains("foo [--without-desc]"));
        assertTrue(out.contains("exit"));
        assertEquals(2, out.split("\n").length);
    }

    @Test
    public void testWithDescription() throws Exception {
        HelpCommand help = new HelpCommand();
        CommandParser parser = new CommandParser(new Command[]{help, new ExitCommand()});

        String out = parser.parse("help --without-desc").getOutput();
        assertTrue(out.contains("help"));
        assertFalse(out.contains("help [--without-desc]"));
        assertTrue(out.contains("exit"));
        assertEquals(2, out.split("\n").length);
    }
}
package fr.univdevs.commander;

import fr.univdevs.commander.mocks.GreeterCommand;
import fr.univdevs.commander.mocks.OMGDuplicateNameCommand;
import fr.univdevs.commander.mocks.ThrowingExceptionCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public final class CommandParserTest {

    private CommandParser parser;

    @Before
    public void setUp() throws Exception {
        this.parser = new CommandParser();
    }

    @Test(expected = IllegalStateException.class)
    public final void testAddDuplicateCommand() {
        parser.add(new GreeterCommand());
        parser.add(new OMGDuplicateNameCommand());
    }

    @Test
    public final void testParseSimple() throws Exception {
        String input = "say-hello John   Marc\tFabio";
        String output, expected = "Hello, John!\nHello, Marc!\nHello, Fabio!\n";

        parser.add(new GreeterCommand());
        output = parser.parse(input).getOutput();

        assertEquals(expected, output);
    }

    @Test
    public void testGetParsedOutput() throws Exception {
        parser.add(new GreeterCommand());
        String[] parsed = parser.parse("say-hello a b\tc dd    ").getParsedInput();

        assertArrayEquals(new String[]{
            "say-hello", "a", "b", "c", "dd"
        }, parsed);
    }

    @Test(expected = NonExistingCommandException.class)
    public final void testNonExistant() throws Exception {
        parser.parse("say-hello world");
    }

    @Test(expected = EmptyCommandException.class)
    public final void testEmptyCommand() throws Exception {
        parser.parse(" \t\r");
    }

    @Test(expected = EmptyCommandException.class)
    public final void testBlankCommand() throws Exception {
        parser.parse("");
    }

    @Test(expected = EmptyCommandException.class)
    public final void testBlankCommand2() throws Exception {
        parser.parse("     ");
    }

    @Test(expected = Exception.class)
    public void testExceptionHandling() throws Exception {
        parser.add(new ThrowingExceptionCommand());
        parser.parse("nein");
    }

    @Test
    public void testArrayCtor() throws Exception {
        parser = new CommandParser(new GreeterCommand(),
            new ThrowingExceptionCommand());

        assertEquals(2, parser.getCommands().size());
    }

    @Test
    public void testGetCommands() throws Exception {
        parser.add(new GreeterCommand());
        parser.add(new ThrowingExceptionCommand());
        assertEquals(2, parser.getCommands().size());
    }

    @Test
    public final void testHas() throws Exception {
        assertFalse(parser.contains("say-hello"));
        parser.add(new GreeterCommand());
        assertTrue(parser.contains("say-hello"));
    }
}

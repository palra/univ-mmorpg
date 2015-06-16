package fr.univdevs.commander.userworld;

import fr.univdevs.commander.CommandParser;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by palra on 16/06/15.
 */
public class AliasManagerCommandTest {
    private CommandParser parser;
    private AliasManagerCommand aliases;

    @Before
    public void setUp() throws Exception {
        parser = new CommandParser();
        aliases = new AliasManagerCommand();
        parser.add(aliases);
    }

    @Test
    public void testExecute() throws Exception {
        parser.parse(AliasManagerCommand.NAME);
    }

    @Test
    public void testCreate() throws Exception {
        parser.parse(AliasManagerCommand.NAME + " " + AliasManagerCommand.CREATE_OPT + " z move up");
    }
}
package fr.univdevs.commander;

import fr.univdevs.commander.userworld.ExitCommandTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CommandParserTest.class,
    ExitCommandTest.class
})

/**
 * Entry point of the Commander test suite.
 * @author Loïc Payol
 */
public class CommanderTestSuite {
}
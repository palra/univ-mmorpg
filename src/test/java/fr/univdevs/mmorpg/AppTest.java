package fr.univdevs.mmorpg;


import fr.univdevs.mmorpg.engine.character.Inventory;
import fr.univdevs.mmorpg.engine.character.mocks.Potion;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Potion potion = new Potion("Potion", "Potion", 10, 9);
        inventory.add(potion);

    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue(true);
    }

}

package fr.univdevs.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by palra on 25/05/15.
 */
public class StringsTest {

    @Test
    public void testNullToEmpty() throws Exception {
        assertEquals("", Strings.nullToEmpty(null));
    }

    @Test
    public void testIsNullOrEmpty() throws Exception {
        assertTrue(Strings.isNullOrEmpty(null));
        assertTrue(Strings.isNullOrEmpty(""));
        assertFalse(Strings.isNullOrEmpty("  "));
    }

    @Test
    public void testRandom() throws Exception {
        assertEquals(8, Strings.random32().length());
        assertEquals(16, Strings.random64().length());
    }
}
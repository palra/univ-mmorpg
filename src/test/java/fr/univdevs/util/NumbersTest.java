package fr.univdevs.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumbersTest {

    @Test
    public void testClampInt() throws Exception {
        assertEquals(0, Numbers.clamp(-150, 0, 50));
        assertEquals(50, Numbers.clamp(100, 0, 50));
        assertEquals(25, Numbers.clamp(25, 0, 50));
    }

    @Test
    public void testClampLong() throws Exception {
        assertEquals(0L, Numbers.clamp(-150L, 0L, 50L));
        assertEquals(50L, Numbers.clamp(100L, 0L, 50L));
        assertEquals(25L, Numbers.clamp(25L, 0L, 50L));
    }

    @Test
    public void testClampFloat() throws Exception {
        assertTrue(Float.compare(0f, Numbers.clamp(-150f, 0f, 50f)) == 0);
        assertTrue(Float.compare(50f, Numbers.clamp(100f, 0f, 50f)) == 0);
        assertTrue(Float.compare(25f, Numbers.clamp(25f, 0f, 50f)) == 0);
    }

    @Test
    public void testClampDuble() throws Exception {
        assertTrue(Double.compare(0d, Numbers.clamp(-150d, 0d, 50d)) == 0);
        assertTrue(Double.compare(50d, Numbers.clamp(100d, 0d, 50d)) == 0);
        assertTrue(Double.compare(25d, Numbers.clamp(25d, 0d, 50d)) == 0);
    }
}
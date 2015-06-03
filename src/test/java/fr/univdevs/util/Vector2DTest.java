package fr.univdevs.util;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Vector2DTest {
    @Test
    public void testEquals() throws Exception {
        Vector2D<Integer> u = new Vector2D<Integer>(3, 3);
        Vector2D<Integer> v = new Vector2D<Integer>(3, 3);

        assertTrue(u.equals(v));
    }

    @Test
    public void testGet() throws Exception {
        Vector2D<Double> w = new Vector2D<Double>(5.2, 7.7);
        assertTrue(Double.compare(5.2, w.getX()) == 0);
        assertTrue(Double.compare(7.7, w.getY()) == 0);
    }
}
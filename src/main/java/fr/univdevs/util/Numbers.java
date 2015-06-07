package fr.univdevs.util;

import java.util.Random;

/**
 * Utility class containing static helper methods about number manipulation
 *
 * @author Loïc Payol
 */
public class Numbers {

    private static Random rand = new Random();

    /**
     * Method clamping val between min and max.
     * Consider the interval [min; max]. If val is out of the interval, the method wil return the closest value
     * that is inside the interval, and return val if val is already in the interval.
     *
     * @param val The value to clamp
     * @param min The minimum value
     * @param max The maximum value
     * @return The clamped value
     */
    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * Method clamping val between min and max.
     * Consider the interval [min; max]. If val is out of the interval, the method wil return the closest value
     * that is inside the interval, and return val if val is already in the interval.
     *
     * @param val The value to clamp
     * @param min The minimum value
     * @param max The maximum value
     * @return The clamped value
     */
    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * Method clamping val between min and max.
     * Consider the interval [min; max]. If val is out of the interval, the method wil return the closest value
     * that is inside the interval, and return val if val is already in the interval.
     *
     * @param val The value to clamp
     * @param min The minimum value
     * @param max The maximum value
     * @return The clamped value
     */
    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * Method clamping val between min and max.
     * Consider the interval [min; max]. If val is out of the interval, the method wil return the closest value
     * that is inside the interval, and return val if val is already in the interval.
     *
     * @param val The value to clamp
     * @param min The minimum value
     * @param max The maximum value
     * @return The clamped value
     */
    public static long clamp(long val, long min, long max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     * @see {@link <a href="http://stackoverflow.com/a/363692/1772507">this thread</a>}
     */
    public static int randomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}

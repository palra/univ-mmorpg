package fr.univdevs.util;

/**
 * Utility class containing static helper methods about number manipulation
 *
 * @author Loïc Payol
 */
public class Numbers {

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
}

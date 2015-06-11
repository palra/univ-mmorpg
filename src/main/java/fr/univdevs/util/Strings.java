package fr.univdevs.util;

import java.util.Random;

/**
 * Utility class containing some string manipulation methods.
 *
 * @author Loïc Payol
 */
public class Strings {
    private static Random random = new Random();

    /**
     * Returns the random generator
     *
     * @return The random generator
     */
    public static Random getRandom() {
        return random;
    }

    /**
     * Takes a string and return the string if not null, and an empty string if null
     *
     * @param s The string to transform
     * @return The transformed string
     */
    public static String nullToEmpty(String s) {
        return (s == null) ? "" : s;
    }

    /**
     * Checks if a string is null or empty
     *
     * @param s The string to test
     * @return true if null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    /**
     * Returns a random 32 bit hexadecimal string.
     *
     * @return A random hexadecimal string
     */
    public static String random32() {
        return Integer.toHexString(random.nextInt());
    }

    /**
     * Returns a random 64 bit hexadecimal string.
     *
     * @return A random hexadecimal string
     */
    public static String random64() {
        return Long.toHexString(random.nextLong());
    }
}

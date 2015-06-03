package fr.univdevs.util;

/**
 * Utility class containing some string manipulation methods.
 *
 * @author Loïc Payol
 */
public abstract class Strings {

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
}

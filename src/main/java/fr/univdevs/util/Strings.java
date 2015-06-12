package fr.univdevs.util;

import java.util.Random;

/**
 * Utility class containing some string manipulation methods.
 *
 * @author Loïc Payol
 */
public class Strings {

    private static Random random = new Random();

    public Strings() {
    }

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
        return fillLeftIn(Integer.toHexString(random.nextInt()), 8, '0');
    }

    /**
     * Returns a random 64 bit hexadecimal string.
     *
     * @return A random hexadecimal string
     */
    public static String random64() {
        return fillLeftIn(Long.toHexString(random.nextLong()), 16, '0');
    }

    /**
     * When in is smaller than the given length, left fill with `fill` character.
     *
     * @param in     The input string
     * @param length The wanted length of the string
     * @param fill   The character to fill with
     * @return The filled string
     */
    public static String fillLeftIn(final String in, int length, char fill) {
        int diff = length - in.length();
        if (diff <= 0)
            return in;

        String out = "";
        for (int i = 0; i < diff; i++) {
            out += fill;
        }

        return out + in;
    }


    public static String toCamelCase(final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(word.substring(0, 1).toUpperCase());
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }

}

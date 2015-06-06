package fr.univdevs.util.ansi;

/**
 * Class representing an ANSI colored string. It automatically resets the colors after applying them.
 *
 * @author Loïc Payol
 */
public class ANSIString extends ANSIDisplayableObject<String> {
    public ANSIString(String rawObject, ANSIAttribute... attributes) {
        super(rawObject, attributes);
    }
}

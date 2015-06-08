package fr.univdevs.util.ansi;

/**
 * Class representing an ANSI colored char. It automatically resets the colors after applying them.
 *
 * @author Loïc Payol
 */
public class ANSIChar extends ANSIDisplayableObject<Character> {
    public ANSIChar(Character rawObject, ANSIAttribute... attributes) {
        super(rawObject, attributes);
    }


    public ANSIChar(ANSIChar other) {
        super(other);
    }
}

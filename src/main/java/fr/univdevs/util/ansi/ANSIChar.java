package fr.univdevs.util.ansi;

/**
 * Class representing an ANSI colored char. It automatically resets the colors after applying them.
 *
 * @author Loïc Payol
 */
public class ANSIChar {
    public static final String SEQ_START = "\u001B[";
    public static final String SEQ_END = "m";

    private char rawChar;
    private ANSIAttribute[] attributes;

    /**
     * Constructs an ANSIString from a String and ANSIAttributes
     *
     * @param rawChar    The raw string
     * @param attributes The modifiying attributes
     */
    public ANSIChar(char rawChar, ANSIAttribute... attributes) {
        this.rawChar = rawChar;
        this.attributes = attributes;
    }

    public char getRawChar() {
        return rawChar;
    }

    public ANSIAttribute[] getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        String out = SEQ_START;
        for (int i = 0; i < attributes.length; i++) {
            out += attributes[i];
            if (i != attributes.length - 1)
                out += ";";
        }
        out += SEQ_END;

        out += rawChar;

        out += SEQ_START + ANSIAttribute.ATTR_RESET + SEQ_END;

        return out;
    }
}

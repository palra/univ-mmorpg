package fr.univdevs.util.ansi;

/**
 * Class representing an ANSI colored string. It automatically resets the colors after applying them.
 *
 * @author Loïc Payol
 */
public class ANSIString {
    public static final String SEQ_START = "\u001B[";
    public static final String SEQ_END = "m";

    private String rawString;
    private ANSIAttribute[] attributes;

    /**
     * Constructs an ANSIString from a String and ANSIAttributes
     *
     * @param rawString  The raw string
     * @param attributes The modifiying attributes
     */
    public ANSIString(String rawString, ANSIAttribute... attributes) {
        this.rawString = rawString;
        this.attributes = attributes;
    }

    public String getRawString() {
        return rawString;
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

        out += rawString;

        out += SEQ_START + ANSIAttribute.ATTR_RESET + SEQ_END;

        return out;
    }
}

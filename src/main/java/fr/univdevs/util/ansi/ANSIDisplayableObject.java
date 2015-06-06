package fr.univdevs.util.ansi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing an ANSI colored object. It automatically resets the colors after applying them.
 *
 * @author Loic Payol
 */
public class ANSIDisplayableObject<T> {
    public static final String SEQ_START = "\u001B[";
    public static final String SEQ_END = "m";

    private T rawObject;
    private List<ANSIAttribute> attributes;

    /**
     * Constructs an ANSIString from an object and ANSIAttributes
     *
     * @param rawObject  The raw object
     * @param attributes The modifiying attributes
     */
    public ANSIDisplayableObject(T rawObject, ANSIAttribute... attributes) {
        this.rawObject = rawObject;
        this.attributes = new ArrayList<ANSIAttribute>(Arrays.asList(attributes));
    }

    public T getRaw() {
        return rawObject;
    }

    public List<ANSIAttribute> getAttributes() {
        return attributes;
    }

    /**
     * Adds an attribute
     *
     * @param ansiAttribute The attribute to add
     * @return Itself, for chaining purposes
     * <p/>
     * If you need the boolean indicator, please use ANSIDisplayableObject<T>#getAttributes() instead
     */
    public ANSIDisplayableObject<T> addAttribute(ANSIAttribute ansiAttribute) {
        attributes.add(ansiAttribute);
        return this;
    }

    /**
     * Removes an attribute
     *
     * @param o The object to remove
     * @return Itself, for chaining purposes
     * <p/>
     * If you need the boolean indicator, please use ANSIDisplayableObject<T>#getAttributes() instead
     */
    public ANSIDisplayableObject<T> removeAttribute(Object o) {
        attributes.remove(o);
        return this;
    }


    @Override
    public String toString() {
        if (attributes.isEmpty())
            return rawObject.toString();

        String out = SEQ_START;
        for (int i = 0; i < attributes.size(); i++) {
            out += attributes.get(i);
            if (i != attributes.size() - 1)
                out += ";";
        }
        out += SEQ_END;

        out += rawObject;

        out += SEQ_START + ANSIAttribute.ATTR_RESET + SEQ_END;

        return out;
    }
}

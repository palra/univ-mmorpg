package fr.univdevs.util.ansi;

import java.util.EnumSet;

/**
 * Class representing an ANSI colored object. It automatically resets the colors after applying them.
 *
 * @author Loic Payol
 */
public class ANSIDisplayableObject<T> {
    public static final String SEQ_START = "\u001B[";
    public static final String SEQ_END = "m";

    private T rawObject;
    private EnumSet<ANSIAttribute> attributes;

    /**
     * Constructs an ANSIString from an object and ANSIAttributes
     *
     * @param rawObject  The raw object
     * @param attributes The modifiying attributes
     */
    public ANSIDisplayableObject(T rawObject, ANSIAttribute... attributes) {
        this.rawObject = rawObject;
        this.attributes =
            attributes.length > 0 ?
                EnumSet.of(attributes[0], attributes) :
                EnumSet.noneOf(ANSIAttribute.class)
        ;
    }

    public ANSIDisplayableObject(ANSIDisplayableObject<T> other) {
        this.rawObject = other.rawObject;
        this.attributes = other.attributes;
    }

    public T getRaw() {
        return rawObject;
    }

    public EnumSet<ANSIAttribute> getAttributes() {
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
        for (ANSIAttribute attribute : attributes) {
            out += attribute + ";";
        }

        return out.substring(0, out.length() - 1) + SEQ_END + rawObject + SEQ_START + ANSIAttribute.ATTR_RESET + SEQ_END;
    }
}
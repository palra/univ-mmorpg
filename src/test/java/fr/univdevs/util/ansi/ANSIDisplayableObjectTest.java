package fr.univdevs.util.ansi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by palra on 06/06/15.
 */
public class ANSIDisplayableObjectTest {

    @Test
    public void testGetRaw() throws Exception {
        String s = "test";
        ANSIDisplayableObject<String> ansi = new ANSIDisplayableObject<String>(s);

        assertSame(s, ansi.getRaw());
    }

    @Test
    public void testAddRemove() throws Exception {
        ANSIDisplayableObject<Integer> ansi = new ANSIDisplayableObject<Integer>(42);
        ansi
            .addAttribute(ANSIAttribute.ATTR_BLINK)
            .addAttribute(ANSIAttribute.BG_BLUE)
            .addAttribute(ANSIAttribute.BG_BLUE)
            .addAttribute(ANSIAttribute.FG_RED)
            .addAttribute(ANSIAttribute.FG_GREEN)
            .removeAttribute(ANSIAttribute.FG_RED);

        assertTrue(ansi.getAttributes().contains(ANSIAttribute.ATTR_BLINK));
        assertTrue(ansi.getAttributes().contains(ANSIAttribute.BG_BLUE));
        assertTrue(ansi.getAttributes().contains(ANSIAttribute.FG_GREEN));
        assertFalse(ansi.getAttributes().contains(ANSIAttribute.FG_RED));

        assertEquals(3, ansi.getAttributes().toArray().length);
    }
}
package fr.univdevs.util.ansi;

/**
 * Utility class listing all the ansi special sequences.
 *
 * @author Loïc Payol
 */
public enum ANSIAttribute {
    ATTR_RESET("0"),
    ATTR_BOLD("1"),
    ATTR_UNDERSCORE("4"),
    ATTR_BLINK("5"),
    ATTR_REVERSE("7"),

    FG_BLACK("30"),
    FG_RED("31"),
    FG_GREEN("32"),
    FG_YELLOW("33"),
    FG_BLUE("34"),
    FG_MAGENTA("35"),
    FG_CYAN("36"),
    FG_WHITE("37"),

    BG_BLACK("40"),
    BG_RED("41"),
    BG_GREEN("42"),
    BG_YELLOW("43"),
    BG_BLUE("44"),
    BG_MAGENTA("45"),
    BG_CYAN("46"),
    BG_WHITE("47");

    String modifier;

    ANSIAttribute(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return this.modifier;
    }
}

package fr.univdevs.mmorpg.engine.action;

/**
 * Enumeration
 * Resume all results to any action
 */
public enum ActionResult {
    NOTHING("%s ne fait rien");

    private String desc = "";

    /**
     * Constructs an ActionResult
     *
     * @param desc format String describing the action.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">Format string reference</a>
     */
    ActionResult(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}

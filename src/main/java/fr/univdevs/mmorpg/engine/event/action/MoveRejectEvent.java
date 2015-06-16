package fr.univdevs.mmorpg.engine.event.action;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

/**
 * Event thrown when a move can't e done because of lack of action points
 *
 * @author Loïc Payol
 */
public class MoveRejectEvent extends ActionEvent {
    protected static final String NAME = "move_reject";
    private int nbCases;

    public MoveRejectEvent(Player subject, int nbCases) {
        super(NAME, subject, null);
        this.nbCases = nbCases;
    }


    @Override
    public String getDescription() {
        return new ANSIString(getSubject().getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) +
            " can't move " +
            new ANSIString(getSubject().getCharacter().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) +
            " of " + this.nbCases + " case" +
            ((this.nbCases <= 1) ? "" : "s") + // Pluralize the string
            " (not enough action points : " +
            new ANSIString(getSubject().getCharacter().getActionPoints() + "", ANSIAttribute.FG_GREEN) + ")";
    }
}

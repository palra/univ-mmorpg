package fr.univdevs.mmorpg.engine.event.action;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Event thrown when a cure failed because the character does not have enough action points
 *
 * @author Loïc Payol
 */
public class CureRejectEvent extends ActionEvent {
    private static final String NAME = "cure_not_enough_action_points";
    private Cure cure;

    public CureRejectEvent(Player subject, Player target, Cure cure) {
        super(NAME, subject, target);
        this.cure = cure;
    }

    public CureRejectEvent(Date date, Player subject, Player target, Cure cure) {
        super(NAME, date, subject, target);
        this.cure = cure;
    }

    @Override
    public String getDescription() {
        Character cSubj = this.getSubject().getCharacter();
        Character cTarg = this.getTarget().getCharacter();

        return new ANSIString(cSubj.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " does not " +
            " have enough action points (" + new ANSIString(cSubj.getActionPoints() + "", ANSIAttribute.FG_GREEN) + ") to " +
            "cure " + new ANSIString(cTarg.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD);
    }
}

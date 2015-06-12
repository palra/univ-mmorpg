package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.logger.LoggerInterface;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.game.event.ActionEvent;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Actions that does nothing, neither on the subject nor the target.
 *
 * @author Loïc Payol
 */
public class NoOpAction extends Action {

    /**
     * {@inheritDoc}
     */
    public NoOpAction(Player chosenSubject) {
        super(chosenSubject, null);
    }

    @Override
    public void execute() throws Exception {
        LoggerInterface l = this.getLogger();
        l.log(new NoOpEvent(this.getSubject()));
    }

    public static class NoOpEvent extends ActionEvent {
        private static final String NAME = "noop";

        public NoOpEvent(Player subject) {
            super(NAME, subject, null);
        }

        public NoOpEvent(Date date, Player subject) {
            super(NAME, date, subject, null);
        }

        @Override
        public String getDescription() {
            return new ANSIString(getSubject().getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) + " passe son tour";
        }
    }
}

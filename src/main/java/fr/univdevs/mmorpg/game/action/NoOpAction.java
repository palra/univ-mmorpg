package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.event.action.ActionEvent;
import fr.univdevs.mmorpg.engine.logger.Logger;

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
    public NoOpAction(Player chosenSubject, Player chosenTarget) {
        super(chosenSubject, chosenTarget);
    }

    public NoOpAction(NoOpAction other) {
        super(other);
    }


    @Override
    public void execute() throws Exception {
        Logger l = this.getLogger();
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
            return this.getSubject().getName() + " passe son tour";
        }
    }
}

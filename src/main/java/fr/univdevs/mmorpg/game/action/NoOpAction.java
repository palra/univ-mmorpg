package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.SubjectEvent;

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

    @Override
    public void execute() throws Exception {
        Logger l = this.getLogger();
        l.log(new NoOpEvent(this.getSubject()));
    }

    public static class NoOpEvent extends SubjectEvent<Player> {
        public NoOpEvent(Player subject) {
            this(new Date(), subject);
        }

        public NoOpEvent(Date date, Player subject) {
            super("action", "noop", date, subject);
        }

        @Override
        public String getDescription() {
            return this.getSubject().getName() + " passe son tour";
        }
    }
}

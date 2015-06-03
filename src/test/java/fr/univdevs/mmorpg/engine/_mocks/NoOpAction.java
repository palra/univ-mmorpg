package fr.univdevs.mmorpg.engine._mocks;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.action.Action;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.SubjectEvent;

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
            super("action", "noop", subject);
        }

        @Override
        public String toString() {
            return this.getSubject().getName() + "passe son tour";
        }
    }
}

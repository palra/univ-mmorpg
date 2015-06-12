package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.logger.LoggerInterface;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.event.action.NoOpEvent;

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

    public NoOpAction(NoOpAction other) {
        super(other);
    }


    @Override
    public void execute() {
        LoggerInterface l = this.getLogger();
        l.log(new NoOpEvent(this.getSubject()));
    }


}

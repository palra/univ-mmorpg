package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.event.action.NoOpEvent;
import fr.univdevs.mmorpg.engine.logger.Logger;

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
    public void execute() {
        Logger l = this.getLogger();
        l.log(new NoOpEvent(this.getSubject()));
    }


}

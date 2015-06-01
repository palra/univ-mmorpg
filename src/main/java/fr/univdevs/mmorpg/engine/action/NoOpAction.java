package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.Player;

/**
 * NoOpAction class
 * When a character does nothing
 */
public class NoOpAction extends Action {
    public NoOpAction(Player subject, Player target) {
        super(subject, target);
    }

    @Override
    public ActionResult execute() throws Exception {
        return ActionResult.NOTHING;
    }
}
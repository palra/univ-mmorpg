package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;

/**
 * NoOpAction class
 * When a character does nothing
 */
public class NoOpAction extends Action {
    public NoOpAction(Character subject, Character target) {
        super(subject, target);
    }

    @Override
    public ActionResult execute() throws Exception {
        return ActionResult.ATTACKED;
    }
}

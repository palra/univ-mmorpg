package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.Character;

/**
 * NoOpAction class
 * When a character does nothing
 */
public class NoOpAction extends Action {

    /**
     * NoOpAction constructor
     * When a charachter does absolutely nothing
     *
     * @param subject The character making the action
     * @param target  The other one, often matching the first
     */
    public NoOpAction(Character subject, Character target) {
        super(subject, target);
    }

    /**
     * {@inheritDoc}
     * @return
     * @throws Exception
     */
    public ActionResult execute() throws Exception {
        return ActionResult.NOTHING;
    }
}

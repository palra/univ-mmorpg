package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Cure;

/**
 * Public class CureAction
 * A character (healer or not) use this action on himself of another target
 */
public class CureAction extends Action {
    private Cure cure;

    /**
     * action constructor
     *
     * @param chosenSubject the Character who execute the action
     * @param chosenTarget  the Character targeted
     */
    public CureAction(Player chosenSubject, Player chosenTarget, Cure chosenCure) {
        super(chosenSubject, chosenTarget);
        this.cure = chosenCure;
    }

    @Override
    public void execute() throws Exception {
        getTarget().getCharacter().setHealth(getTarget().getCharacter().getHealth() + this.cure.getRestoredPoints());
    }
}

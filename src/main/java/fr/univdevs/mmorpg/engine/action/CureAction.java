package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.logger.LoggerInterface;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.mmorpg.engine.event.action.CureEvent;

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
    public CureAction(Player chosenSubject, Player chosenTarget, Cure chosenCure) throws IllegalArgumentException {
        super(chosenSubject, chosenTarget);
        if (chosenSubject.getCharacter().getInventory().has(chosenCure))
            this.cure = chosenCure;
        else
            throw new IllegalArgumentException("N'est pas dans l'inventaire!");
    }

    public CureAction(CureAction other) {
        super(other);
        this.cure = other.cure;
    }


    @Override
    public void execute() {
        getTarget().getCharacter().setHealth(getTarget().getCharacter().getHealth() + this.cure.getRestoredPoints());
        getSubject().getCharacter().getInventory().remove(this.cure);
        LoggerInterface l = this.getLogger();
        l.log(new CureEvent(this.getSubject(), this.getTarget()));
        this.cure = null;
    }



}
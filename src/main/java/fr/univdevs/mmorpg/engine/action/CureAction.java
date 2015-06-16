package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.mmorpg.engine.event.action.CureEvent;
import fr.univdevs.mmorpg.engine.event.action.CureRejectEvent;
import fr.univdevs.mmorpg.engine.logger.LoggerInterface;

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
    public CureAction(Player chosenSubject, Player chosenTarget, Cure chosenCure) throws NotInInventoryException {
        super(chosenSubject, chosenTarget);
        if (chosenSubject.getCharacter().getInventory().has(chosenCure))
            this.cure = chosenCure;
        else
            throw new NotInInventoryException("The cure is not in the inventory");
    }

    public CureAction(CureAction other) {
        super(other);
        this.cure = other.cure;
    }

    @Override
    public void execute() {
        getTarget().getCharacter().setHealth(getTarget().getCharacter().getHealth() + this.cure.getRestoredPoints());
        getSubject().getCharacter().getInventory().remove(this.cure);
        if (getSubject().getCharacter().getActionPoints() >= this.cure.getRestoredPoints() / 10) {
            getSubject().getCharacter().setActionPoints(getSubject().getCharacter().getActionPoints() - this.cure.getRestoredPoints() / 10);
        } else this.getLogger().log(new CureRejectEvent(getSubject(), getTarget(), this.cure));
        LoggerInterface l = this.getLogger();
        l.log(new CureEvent(this.getSubject(), this.getTarget()));
        this.cure = null;
    }

    public static class NotInInventoryException extends Exception {
        public NotInInventoryException(String message) {
            super(message);
        }
    }



}

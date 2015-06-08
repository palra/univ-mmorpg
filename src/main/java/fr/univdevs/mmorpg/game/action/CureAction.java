package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.mmorpg.engine.logger.ActionEvent;
import fr.univdevs.mmorpg.engine.logger.Logger;

import java.util.Date;

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
    public void execute() throws Exception {
        getTarget().getCharacter().setHealth(getTarget().getCharacter().getHealth() + this.cure.getRestoredPoints());
        getSubject().getCharacter().getInventory().remove(this.cure);
        Logger l = this.getLogger();
        l.log(new CureEvent(this.getSubject(), this.getTarget()));
        this.cure = null;
    }

    public static class CureEvent extends ActionEvent {
        public CureEvent(Player subject, Player target) {
            this(new Date(), subject, target);
        }

        public CureEvent(Date date, Player subject, Player target) {
            super("action", "cure", date, subject, target);
        }


        @Override
        public String getDescription() {
            return this.getSubject() + " a soigné " + this.getTarget();
        }
    }

}

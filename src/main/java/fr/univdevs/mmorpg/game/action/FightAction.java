package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.mmorpg.engine.logger.ActionEvent;
import fr.univdevs.mmorpg.engine.logger.Logger;

import java.util.Date;

/**
 * Public class FightAction
 * Represents a fighting action
 * A character use a fightAction on a target
 */
public class FightAction extends Action {
    private Weapon weapon;

    /**
     * action constructor
     *
     * @param chosenSubject the Character who execute the action
     * @param chosenTarget  the Character targeted
     */
    public FightAction(Player chosenSubject, Player chosenTarget, Weapon chosenWeapon) throws IllegalArgumentException {
        super(chosenSubject, chosenTarget);
        if (chosenSubject.getCharacter().getInventory().has(chosenWeapon))
            this.weapon = chosenWeapon;
        else
            throw new IllegalArgumentException("Pas dans l'inventaire!");
    }

    @Override
    public void execute() throws Exception {
        getTarget().getCharacter().setHealth((int) (getTarget().getCharacter().getHealth() + (getTarget().getCharacter().getHealth() * getTarget().getCharacter().getResistance()) - this.weapon.getPower()));
        Logger l = this.getLogger();
        l.log(new FightEvent(this.getSubject(), this.getTarget()));
        this.weapon = null;
    }

    public static class FightEvent extends ActionEvent<Player> {
        public FightEvent(Player subject, Player target) {
            this(new Date(), subject, target);
        }

        public FightEvent(Date date, Player subject, Player target) {
            super("action", "fight", date, subject, target);
        }

        @Override
        public String getDescription() {
            return this.getSubject().getName() + " a attaqué " + this.getTarget().getName();
        }
    }
}

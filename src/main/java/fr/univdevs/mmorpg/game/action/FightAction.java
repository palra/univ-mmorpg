package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.mmorpg.engine.logger.ActionEvent;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.SubjectEvent;

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
    public FightAction(Player chosenSubject, Player chosenTarget, Weapon chosenWeapon) {
        super(chosenSubject, chosenTarget);
        this.weapon = chosenWeapon;
    }

    @Override
    public void execute() throws Exception {
        getTarget().getCharacter().setHealth(getTarget().getCharacter().getHealth() - this.weapon.getPower());
        Logger l = this.getLogger();
        l.log(new FightEvent(this.getSubject(), this.getTarget()));
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
            return this.getSubject().getName() + " a attaqué " + this.getTarget();
        }
    }
}

package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
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
        l.log(new FightEvent(this.getSubject()));
    }

    public static class FightEvent extends SubjectEvent<Player> {
        public FightEvent(Player subject) {
            this(new Date(), subject);
        }

        public FightEvent(Date date, Player subject) {
            super("action", "noop", date, subject);
        }

        @Override
        public String getDescription() {
            return this.getSubject().getName() + " a attaqué";
        }
    }
}

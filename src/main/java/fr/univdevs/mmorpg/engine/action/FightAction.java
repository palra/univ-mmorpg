package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.logger.LoggerInterface;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.mmorpg.engine.event.action.FightEvent;

/**
 * Public class FightAction
 * Represents a fighting action
 * A character use a fightAction on a target
 */
public class FightAction extends Action {
    public int NB_DEAD;
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

    public FightAction(FightAction other) {
        super(other);
        this.weapon = other.weapon;
    }


    @Override
    public void execute() {
        getTarget().getCharacter().setHealth((int) (getTarget().getCharacter().getHealth() + (getTarget().getCharacter().getHealth() * getTarget().getCharacter().getResistance()) - this.weapon.getPower()));
        getSubject().getCharacter().setActionPoints(getSubject().getCharacter().getActionPoints() - 2);
        if (this.getTarget().getCharacter().getHealth() <= 0) {
            this.getSubject().getCharacter().setActionPoints(this.getSubject().getCharacter().getActionPoints() + 20);
            System.out.println(this.getTarget().getCharacter().getName() + " est mort!");
        }
        LoggerInterface l = this.getLogger();
        l.log(new FightEvent(this.getSubject(), this.getTarget()));
    }


}

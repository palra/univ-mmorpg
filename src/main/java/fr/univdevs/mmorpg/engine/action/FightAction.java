package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Weapon;

/**
 * FightAction class
 * This action is triggered when a character attacks another one
 */
public class FightAction extends Action {

    private Weapon weapon;

    /**
     * Action constructor
     *
     * @param chosenSubject the Character who execute the action
     * @param chosenTarget  the Character targeted
     */
    public FightAction(Character chosenSubject, Character chosenTarget) {
        super(chosenSubject, chosenTarget);
    }

    /**
     * Public method to pick a weapon in order to attack
     *
     * @param chosenWeapon the weapon we want to use
     * @return chosenWeapon the same weapon
     */
    public Weapon setWeapon(Weapon chosenWeapon) {
        this.weapon = chosenWeapon;
        return chosenWeapon;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public ActionResult execute() {
        this.getTarget().removeHealth(this.weapon.getPower());
        return ActionResult.ATTACKED;
    }
}

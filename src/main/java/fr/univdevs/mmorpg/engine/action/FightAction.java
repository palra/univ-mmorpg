package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Weapon;
import fr.univdevs.mmorpg.engine.skills.ActionResult;

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

    public void setWeapon(Weapon chosenWeapon) {
        this.weapon = chosenWeapon;
    }

    @Override
    public ActionResult execute() {
        this.getTarget().removeHealth(this.weapon.getPower());
        return ActionResult.Attacked;
    }
}

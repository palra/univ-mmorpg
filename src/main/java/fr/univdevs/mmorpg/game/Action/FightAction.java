package fr.univdevs.mmorpg.game.Action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Weapon;

/**
 * Public class FightAction
 * Represents a fighting action
 * A character use a fightAction on a target
 */
public class FightAction extends Action {
    private Weapon weapon;

    /**
     * Action constructor
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
    }
}

package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;

/**
 * Created by drattak on 29/05/15.
 */
public class SpellAction extends Action {
    private Weapon spell;

    public SpellAction(Character subject, Character target) {
        super(subject, target);
    }

    /**
     * Public method to give a spell to the Action
     * The Action cannot be done without a spell
     *
     * @param chosenSpell the spell we want to execute
     * @return the chosenSpell
     */
    public Weapon setSpell(Weapon chosenSpell) {
        this.spell = chosenSpell;
        return chosenSpell;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     * @throws NullPointerException
     */
    public ActionResult execute() throws NullPointerException {
        this.getTarget().removeHealth(this.spell.getPower());
        return null;
    }
}

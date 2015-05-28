package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;

/**
 * Class CureAction
 * Action to cure one character
 */
public class CureAction extends Action {
    private Cure cure;

    /**
     * CureAction constructor
     *
     * @param subject The character who cures
     * @param target  The cured one
     */
    public CureAction(Character subject, Character target) {
        super(subject, target);
    }

    public Cure setAction(Cure chosenCure) {
        this.cure = chosenCure;
        return chosenCure;
    }

    @Override
    public ActionResult execute() throws Exception {
        //if (this.cure == null) throw new Exception("Pas de potion sélectionnée!");
        if (getSubject().getInventory().getByName(cure.getName()) == null) throw new Exception("Pas dans l'inventaire");
        getTarget().addHealth(this.cure.getRestoredPoints());
        getSubject().getInventory().remove(this.cure);
        return ActionResult.ATTACKED; //To be changed //TODO Game manager
    }

    public String toString() throws NullPointerException {
        if (this.cure == null) throw new NullPointerException("Pas de cure disponible");
        return super.toString() + "Nombre de points restaurés = " + this.cure.getRestoredPoints();
    }
}

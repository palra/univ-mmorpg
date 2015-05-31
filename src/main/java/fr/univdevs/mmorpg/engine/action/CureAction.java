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

    /**
     * Public method to add a Cure to the action
     *
     * @param chosenCure the Cure we want to use
     * @return the same cure
     */
    public Cure setCure(Cure chosenCure) {
        this.cure = chosenCure;
        return chosenCure;
    }

    /**
     * {@inheritDoc}
     * @return
     * @throws Exception
     */
    public ActionResult execute() throws Exception {
        //if (this.cure == null) throw new Exception("Pas de potion sélectionnée!");
        if (getSubject().getInventory().getByName(cure.getName()) == null) throw new Exception("Pas dans l'inventaire");
        getTarget().addHealth(this.cure.getRestoredPoints());
        getSubject().getInventory().remove(this.cure);
        return ActionResult.ATTACKED; //To be changed //TODO Game manager
    }

    /**
     * Redefinition of toString
     * @return the generated String
     * @throws NullPointerException if there's no cure to describe
     */
    public String toString() throws NullPointerException {
        if (this.cure == null) throw new NullPointerException("Pas de cure disponible");
        return super.toString() + "Nombre de points restaurés = " + this.cure.getRestoredPoints();
    }
}

package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;

/**
 * Public class MoveAction
 * When the character does nothing but moving
 */
public class MoveAction extends Action {

    private int x = -100000;
    private int y = -100000;

    public MoveAction(Character target) {
        super(target, target);
    }

    /**
     * Public method for the position
     *
     * @param chosenX the X-position
     * @param chosenY the Y-position
     */
    public void setPos(int chosenX, int chosenY) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     * @throws ArithmeticException
     */
    public ActionResult execute() throws ArithmeticException {
        if (this.x == -100000 || this.y == -100000) {
            throw new ArithmeticException("Position invalide");
        }
        this.getTarget().setX(x);
        this.getTarget().setY(y);
        return ActionResult.ATTACKED;
    }
}

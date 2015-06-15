package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.mmorpg.engine.logger.LoggerInterface;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Cure;
import fr.univdevs.mmorpg.engine.event.action.CureEvent;
import fr.univdevs.mmorpg.engine.event.inventory.NotEnoughActionPointsEvent;

/**
 * Public class CureAction
 * A character (healer or not) use this action on himself of another target
 */
public class DropAction extends Action {
    private Item item;

    /**
     * action constructor
     *
     * @param chosenSubject the Character who execute the action
     * @param chosenItem    the Character targeted
     */
    public DropAction(Player chosenSubject, Item chosenItem) throws NotInInventoryException {
        super(chosenSubject, chosenSubject);
        if (chosenSubject.getCharacter().getInventory().has(chosenItem))
            this.item = chosenItem;
        else throw new NotInInventoryException("Ce n'est pas dans l'inventaire!");

    }

    public DropAction(DropAction other) {
        super(other);
    }

    @Override
    public void execute() {
        if (this.item != null) {
            getTarget().getCharacter().getInventory().remove(this.item);
            LoggerInterface l = this.getLogger();
            l.log(new CureEvent(this.getSubject(), this.getTarget()));
        } else return;
    }

    public static class NotInInventoryException extends Exception {
        public NotInInventoryException(String message) {
            super(message);
        }
    }


}

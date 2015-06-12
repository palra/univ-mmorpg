package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Inventory;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.mmorpg.engine.event.action.ActionEvent;
import fr.univdevs.mmorpg.engine.event.move.MoveActionEvent;
import fr.univdevs.mmorpg.engine.event.not_money.NotEnoughMoneyEvent;
import fr.univdevs.mmorpg.engine.world.Entity;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Action done when a character oves on the map
 */
public class MoveAction extends Action {
    private World.Direction direction;
    private int nbCases;

    /**
     * Action constructor
     *
     * @param chosenSubject the Character who execute the action
     * @param chosenTarget  the Character targeted
     * @param direction     the direction of the movement
     * @param nbCases       the number of cases of the movment
     */
    public MoveAction(Player chosenSubject, Player chosenTarget, World.Direction direction, int nbCases) {
        super(chosenSubject, chosenTarget);
        if (direction == null)
            throw new NullPointerException("Direction can't be null");
        this.direction = direction;
        this.nbCases = nbCases;
    }

    public MoveAction(MoveAction other) {
        super(other);
        this.direction = other.direction;
        this.nbCases = other.nbCases;
    }


    @Override
    public void execute() {
        World w = this.getGameManager().getWorld();
        Character c = this.getSubject().getCharacter();
        if (this.nbCases > 1 * c.getActionPoints()) {

        }

        World.MoveResult res = w.move(c, this.direction, this.nbCases);
        c.setActionPoints(c.getActionPoints() - 1 * res.getNbCases());
        this.getLogger().log(new MoveActionEvent(getSubject(), res, this.direction));

        Inventory inventory = c.getInventory();
        for (Entity entity : res.getNonCollidableEntities()) {
            if (entity instanceof Item) {
                Item item = (Item) entity;
                try {
                    inventory.add(item);
                    w.removeEntity(entity);
                } catch (Inventory.NotEnoughCashException exp) {
                    getLogger().log(new NotEnoughMoneyEvent(item, c));
                }
            }
        }
    }


}


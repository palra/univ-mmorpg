package fr.univdevs.mmorpg.engine.action;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Inventory;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.mmorpg.engine.event.action.MoveEvent;
import fr.univdevs.mmorpg.engine.event.action.MoveRejectEvent;
import fr.univdevs.mmorpg.engine.event.inventory.AddEvent;
import fr.univdevs.mmorpg.engine.event.inventory.NotEnoughMoneyEvent;
import fr.univdevs.mmorpg.engine.world.Entity;
import fr.univdevs.mmorpg.engine.world.World;

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

        World.MoveResult res = w.move(c, this.direction, this.nbCases);
        c.setActionPoints(c.getActionPoints() - res.getNbCases());

        if (c.getActionPoints() < 0) {
            int diff = 0 - c.getActionPoints();
            w.move(c, this.direction, -diff); // Rewind move
            c.setActionPoints(0);
            this.getLogger().log(new MoveRejectEvent(getSubject(), res.getNbCases() - diff));
            return;
        }

        this.getLogger().log(new MoveEvent(getSubject(), res, this.direction));

        Inventory inventory = c.getInventory();
        for (Entity entity : res.getNonCollidableEntities()) {
            if (entity instanceof Item) {
                Item item = (Item) entity;
                try {
                    inventory.add(item);
                    w.removeEntity(entity);
                } catch (Inventory.NotEnoughCashException exp) {
                    this.getLogger().log(new NotEnoughMoneyEvent(item, c));
                    return;
                }

                this.getLogger().log(
                    new AddEvent(item, this.getSubject().getCharacter())
                );
            }
        }
    }
}
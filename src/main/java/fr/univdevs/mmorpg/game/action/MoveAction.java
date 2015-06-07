package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Inventory;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.mmorpg.engine.world.Entity;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.event.ActionEvent;
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

    @Override
    public void execute() throws Exception {
        World w = this.getGameManager().getWorld();
        Character c = this.getSubject().getCharacter();
        World.MoveResult res = w.move(c, this.direction, this.nbCases);
        this.getLogger().log(new MoveActionEvent(getSubject(), res, this.direction));

        Inventory i = c.getInventory();
        for (Entity e : res.getNonCollidableEntities()) {
            if (e instanceof Item)
                i.add((Item) e);
        }
    }

    public static class MoveActionEvent extends ActionEvent {
        public static final String NAME = "move";
        private World.MoveResult res;
        private World.Direction dir;

        public MoveActionEvent(Player subject, World.MoveResult res, World.Direction dir) {
            super(NAME, subject, null);
            this.res = res;
            this.dir = dir;
        }

        public MoveActionEvent(Date date, Player subject, World.MoveResult res, World.Direction dir) {
            super(NAME, date, subject, null);
            this.res = res;
            this.dir = dir;
        }

        @Override
        public String getDescription() {
            String out = new ANSIString(getSubject().getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) +
                " a déplacé " +
                new ANSIString(getSubject().getCharacter().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) +
                " de " + res.getNbCases() + " case" +
                ((res.getNbCases() > 1) ? "" : "s") + // Pluralize the string
                " vers ";

            switch (dir) {
                case LEFT:
                    out += "la gauche";
                    break;
                case RIGHT:
                    out += "la droite";
                    break;
                case UP:
                    out += "le haut";
                    break;
                case DOWN:
                    out += "le bas";
                    break;
            }

            return out;
        }
    }
}

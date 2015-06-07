package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
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
        w.move(c, this.direction, this.nbCases);
        this.getLogger().log(new MoveActionEvent(getSubject(), getTarget(), this.direction, this.nbCases));
    }

    public static class MoveActionEvent extends ActionEvent {
        public static final String NAME = "move";
        private World.Direction direction;
        private int nbCases;

        public MoveActionEvent(Player subject, Player target, World.Direction direction, int nbCases) {
            super(NAME, subject, target);
            this.direction = direction;
            this.nbCases = nbCases;
        }

        public MoveActionEvent(Date date, Player subject, Player target, World.Direction direction, int nbCases) {
            super(NAME, date, subject, target);
            this.direction = direction;
            this.nbCases = nbCases;
        }

        @Override
        public String getDescription() {
            String out = new ANSIString(getSubject().getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) +
                " a déplacé " +
                new ANSIString(getSubject().getCharacter().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) +
                " de " + nbCases + " case" +
                ((nbCases > 1) ? "" : "s") + // Pluralize the string
                " vers ";

            switch (direction) {
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

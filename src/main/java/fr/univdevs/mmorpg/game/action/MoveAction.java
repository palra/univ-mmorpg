package fr.univdevs.mmorpg.game.action;

import fr.univdevs.mmorpg.engine.Action;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.SubjectEvent;

import java.util.Date;

/**
 * MoveAction class
 * Describes the action when a character moves
 */
public class MoveAction extends Action {
    private int x;
    private int y;

    public MoveAction(Player subject, int chosenX, int chosenY) {
        super(subject, subject);
        this.x = chosenX;
        this.y = chosenY;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public void execute() throws Exception {
        getSubject().getCharacter().setY(3);
        getSubject().getCharacter().setX(4);
        Logger l = this.getLogger();
        l.log(new MoveEvent(this.getSubject()));
    }

    public static class MoveEvent extends SubjectEvent<Player> {

        public MoveEvent(Player subject) {
            this(new Date(), subject);
        }

        public MoveEvent(Date date, Player subject) {
            super("action", "noop", date, subject);
        }

        @Override
        public String getDescription() {
            return this.getSubject() + " est allé à " + getSubject().getCharacter().getX() + ", " + getSubject().getCharacter().getY();
        }
    }
}

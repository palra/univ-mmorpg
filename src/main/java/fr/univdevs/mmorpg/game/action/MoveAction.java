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

    public MoveAction(Player subject) {
        super(subject, subject);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void execute() throws Exception {
        setY(this.y);
        setX(this.x);
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

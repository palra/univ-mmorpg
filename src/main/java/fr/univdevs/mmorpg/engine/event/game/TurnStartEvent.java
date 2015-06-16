package fr.univdevs.mmorpg.engine.event.game;

import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Event thrown when a player starts its turn
 *
 * @author Loïc Payol
 */
public class TurnStartEvent extends GameEvent {
    protected static final String NAME = "turn_start";
    private Player subject;

    public TurnStartEvent(GameManager gameManager, Player subject) {
        super(NAME, gameManager);
        this.setSubject(subject);
    }

    public TurnStartEvent(Date date, GameManager gameManager, Player subject) {
        super(NAME, date, gameManager);
        this.setSubject(subject);
    }

    public Player getSubject() {
        return subject;
    }

    public void setSubject(Player subject) {
        if (subject == null)
            throw new NullPointerException("The subject cannot be null");
        this.subject = subject;
    }

    @Override
    public String getDescription() {
        return
            new ANSIString(this.subject.getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) +
                "'s turn";
    }
}

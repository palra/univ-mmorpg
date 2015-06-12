package fr.univdevs.mmorpg.engine.event.game;

import fr.univdevs.logger.Event;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Event thrown when a round starts.
 */
public class RoundStartEvent extends Event {
    public static final String TOPIC = "game";
    public static final String NAME = "round_start";

    private int roundNb;

    /**
     * Constructs a GameRoundStartEvent
     *
     * @param roundNb The number of the round
     */
    public RoundStartEvent(int roundNb) {
        super(TOPIC, NAME);
        this.roundNb = roundNb;
    }

    /**
     * Constructs a GameRoundStartEvent
     *
     * @param date    The date of the event creation
     * @param roundNb The number of the round
     */
    public RoundStartEvent(Date date, int roundNb) {
        super(TOPIC, NAME, date);
        this.roundNb = roundNb;
    }

    /**
     * Returns the round number
     *
     * @return The round number
     */
    public int getRoundNumber() {
        return this.roundNb;
    }

    @Override
    public String getDescription() {
        return new ANSIString("Début du tour n°" + roundNb, ANSIAttribute.ATTR_BOLD) + "";
    }
}

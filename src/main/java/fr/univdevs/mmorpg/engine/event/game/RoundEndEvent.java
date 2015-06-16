package fr.univdevs.mmorpg.engine.event.game;

import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Event thrown when a round ends.
 */
public class RoundEndEvent extends Event {
    public static final String TOPIC = "game";
    public static final String NAME = "round_end";

    private int roundNb;

    /**
     * Constructs a GameRoundEndEvent
     *
     * @param roundNb The number of the round
     */
    public RoundEndEvent(int roundNb) {
        super(TOPIC, NAME);
        this.roundNb = roundNb;
    }

    /**
     * Constructs a GameRoundStartEvent
     *
     * @param date    The date of the event creation
     * @param roundNb The number of the round
     */
    public RoundEndEvent(Date date, int roundNb) {
        super(TOPIC, NAME, date);
        this.roundNb = roundNb;
    }

    /**
     * Returns the round number
     *
     * @return The round number
     */
    public int getRoundNumber() {
        return roundNb;
    }

    @Override
    public String getDescription() {
        return new ANSIString("End of turn #" + roundNb, ANSIAttribute.ATTR_BOLD) + "";
    }
}

package fr.univdevs.mmorpg.engine.event.game;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.GameManagerAware;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Events that reports an information about a given game
 *
 * @author Vincent EMILE
 */
public class DeathEvent extends Event {
    protected static final String TOPIC = "player";
    protected static final String name = "death";
    private Player player;

    /**
     * Constructs an DeathEvent
     *
     * @param chosenPlayer The player who died
     */
    public DeathEvent(Player chosenPlayer) {
        super(TOPIC, name);
        this.setPlayer(chosenPlayer);
    }

    /**
     * Constructs an ActionEvent
     *
     * @param date         The date of the event
     * @param chosenPlayer The player who died
     */
    public DeathEvent(Date date, Player chosenPlayer) {
        super(TOPIC, name, date);
        this.setPlayer(chosenPlayer);
    }

    /**
     * Public getter for player
     *
     * @return the player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Public setter for player
     *
     * @param chosenPlayer the player we set
     */
    public void setPlayer(Player chosenPlayer) {
        if (chosenPlayer == null)
            throw new NullPointerException("The player cannot be null");
        this.player = chosenPlayer;
    }

    @Override
    public String getDescription() {
        return new ANSIString(this.getPlayer().getCharacter().getName() + " est mort! Oh non!", ANSIAttribute.ATTR_BOLD) + "";
    }
}

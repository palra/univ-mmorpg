package fr.univdevs.mmorpg.game.event;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.logger.Event;

import java.util.Date;

/**
 * Class representing an event triggered when an action is involved. Its topic is {@link ActionEvent#TOPIC}
 *
 * @author Loïc Payol
 */
public abstract class ActionEvent extends Event {
    public static final String TOPIC = "action";

    private Player subject;
    private Player target;

    /**
     * Constructs an ActionEvent
     *
     * @param name    The name of the event
     * @param subject The subject of the action, non nullable, but the constructor will not throw an exception for that
     * @param target  The target of the action, nullable
     */
    public ActionEvent(String name, Player subject, Player target) {
        super(TOPIC, name);
        this.subject = subject;
        this.target = target;
    }

    /**
     * Constructs an ActionEvent
     *
     * @param name    The name of the event
     * @param date    The date of the event
     * @param subject The subject of the action, non nullable
     * @param target  The target of the action, nullable
     */
    public ActionEvent(String name, Date date, Player subject, Player target) {
        super(TOPIC, name, date);
        this.subject = subject;
        this.target = target;
    }

    public Player getSubject() {
        return this.subject;
    }

    public Player getTarget() {
        return this.target;
    }
}

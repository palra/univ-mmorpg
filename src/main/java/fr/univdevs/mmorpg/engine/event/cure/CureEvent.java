package fr.univdevs.mmorpg.engine.event.cure;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.event.action.ActionEvent;

import java.util.Date;

public class CureEvent extends ActionEvent {
    public CureEvent(Player subject, Player target) {
        this(new Date(), subject, target);
    }

    public CureEvent(Date date, Player subject, Player target) {
        super("cure", date, subject, target);
    }


    @Override
    public String getDescription() {
        return this.getSubject() + " a soigné " + this.getTarget();
    }
}
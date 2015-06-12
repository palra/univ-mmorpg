package fr.univdevs.mmorpg.engine.event.action;

import fr.univdevs.mmorpg.engine.Player;

import java.util.Date;

public class FightEvent extends ActionEvent {
    public FightEvent(Player subject, Player target) {
        this(new Date(), subject, target);
    }

    public FightEvent(Date date, Player subject, Player target) {
        super("fight", date, subject, target);
    }

    @Override
    public String getDescription() {
        return this.getSubject().getName() + " a attaqué " + this.getTarget().getName() + " avec ";
    }
}
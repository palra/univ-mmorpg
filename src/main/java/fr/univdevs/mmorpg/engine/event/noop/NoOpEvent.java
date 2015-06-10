package fr.univdevs.mmorpg.engine.event.noop;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.event.action.ActionEvent;

import java.util.Date;

public class NoOpEvent extends ActionEvent {
    private static final String NAME = "noop";

    public NoOpEvent(Player subject) {
        super(NAME, subject, null);
    }

    public NoOpEvent(Date date, Player subject) {
        super(NAME, date, subject, null);
    }

    @Override
    public String getDescription() {
        return this.getSubject().getName() + " passe son tour";
    }
}
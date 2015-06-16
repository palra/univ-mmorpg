package fr.univdevs.mmorpg.engine.event.action;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

public class MoveEvent extends ActionEvent {
    public static final String NAME = "move";
    private World.MoveResult res;
    private World.Direction dir;

    public MoveEvent(Player subject, World.MoveResult res, World.Direction dir) {
        super(NAME, subject, null);
        this.res = res;
        this.dir = dir;
    }

    public MoveEvent(Date date, Player subject, World.MoveResult res, World.Direction dir) {
        super(NAME, date, subject, null);
        this.res = res;
        this.dir = dir;
    }

    @Override
    public String getDescription() {
        String out = new ANSIString(getSubject().getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) +
            " moved " +
            new ANSIString(getSubject().getCharacter().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) +
            " of " + res.getNbCases() + " case" +
            ((res.getNbCases() <= 1) ? "" : "s"); // Pluralize the string
        switch (dir) {
            case LEFT:
                out += "to the left";
                break;
            case RIGHT:
                out += "to the right";
                break;
            case UP:
                out += "upside";
                break;
            case DOWN:
                out += "downside";
                break;
        }

        return out;
    }
}
package fr.univdevs.mmorpg.engine.event.move;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.event.action.ActionEvent;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

public class MoveActionEvent extends ActionEvent {
    public static final String NAME = "move";
    private World.MoveResult res;
    private World.Direction dir;

    public MoveActionEvent(Player subject, World.MoveResult res, World.Direction dir) {
        super(NAME, subject, null);
        this.res = res;
        this.dir = dir;
    }

    public MoveActionEvent(Date date, Player subject, World.MoveResult res, World.Direction dir) {
        super(NAME, date, subject, null);
        this.res = res;
        this.dir = dir;
    }

    @Override
    public String getDescription() {
        String out = new ANSIString(getSubject().getName(), ANSIAttribute.FG_MAGENTA, ANSIAttribute.ATTR_BOLD) +
                " a déplacé " +
                new ANSIString(getSubject().getCharacter().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) +
                " de " + res.getNbCases() + " case" +
                ((res.getNbCases() > 1) ? "" : "s") + // Pluralize the string
                " vers ";

        switch (dir) {
            case LEFT:
                out += "la gauche";
                break;
            case RIGHT:
                out += "la droite";
                break;
            case UP:
                out += "le haut";
                break;
            case DOWN:
                out += "le bas";
                break;
        }

        return out;
    }
}
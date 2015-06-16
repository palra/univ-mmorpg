package fr.univdevs.mmorpg.engine.event.action;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

public class FightEvent extends ActionEvent {
    private Weapon weapon;

    public FightEvent(Player subject, Player target, Weapon weapon) {
        this(new Date(), subject, target, weapon);
    }

    public FightEvent(Date date, Player subject, Player target, Weapon weapon) {
        super("fight", date, subject, target);
        if (weapon == null)
            throw new NullPointerException("The weapon can't be null");
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return new ANSIString(this.getSubject().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) +
            " attacked " +
            new ANSIString(this.getTarget().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " with " +
            new ANSIString(this.weapon.getType(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_BOLD);
    }
}
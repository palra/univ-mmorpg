package fr.univdevs.mmorpg.engine.event.inventory;

import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

public class NotEnoughActionPointsEvent extends Event {
    private static final String TOPIC = "inventory";
    private static final String NAME = "not_enough_action_points";
    private Item item;
    private fr.univdevs.mmorpg.engine.character.Character character;

    public NotEnoughActionPointsEvent(Item item, Character character) {
        super(TOPIC, NAME);
        this.item = item;
        this.character = character;
    }

    public NotEnoughActionPointsEvent(Date date, Item item, Character character) {
        super(TOPIC, NAME, date);
        this.item = item;
        this.character = character;
    }

    @Override
    public String getDescription() {
        return new ANSIString(character.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " n'a pas " +
                "assez de points d'action (" + new ANSIString(character.getActionPoints() + "£", ANSIAttribute.FG_GREEN) + ") pour faire cela " +
                new ANSIString(String.valueOf(character.getActionPoints()), ANSIAttribute.FG_GREEN) + ")";
    }
}
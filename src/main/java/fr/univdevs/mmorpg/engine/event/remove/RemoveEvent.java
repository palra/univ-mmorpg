package fr.univdevs.mmorpg.engine.event.remove;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

public class RemoveEvent extends Event {
    private static final String TOPIC = "inventory";
    private static final String NAME = "remove";
    private Item item;
    private fr.univdevs.mmorpg.engine.character.Character character;

    public RemoveEvent(Item item, Character character) {
        super(TOPIC, NAME);
        this.item = item;
        this.character = character;
    }

    public RemoveEvent(Date date, Item item, Character character) {
        super(TOPIC, NAME, date);
        this.item = item;
        this.character = character;
    }

    @Override
    public String getDescription() {
        return new ANSIString(character.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " relâche " +
                new ANSIString(item.getCategory(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_BOLD) + " (" +
                new ANSIString(item.getID() + "", ANSIAttribute.ATTR_UNDERSCORE, ANSIAttribute.FG_CYAN) + ")";
    }
}
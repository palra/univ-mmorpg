package fr.univdevs.mmorpg.engine.event.inventory;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

public class RemoveEvent extends InventoryEvent {
    private static final String TOPIC = "inventory";
    private static final String NAME = "remove";
    private Item item;
    private fr.univdevs.mmorpg.engine.character.Character character;

    public RemoveEvent(Item item, Character character) {
        super(NAME, character);
        this.item = item;
        this.character = character;
    }

    public RemoveEvent(Date date, Item item, Character character) {
        super(NAME, date, character);
        this.item = item;
    }

    @Override
    public String getDescription() {
        return new ANSIString(character.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " relâche " +
            new ANSIString(item.getCategory(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_BOLD) + " (" +
            new ANSIString(item.getID() + "", ANSIAttribute.ATTR_UNDERSCORE, ANSIAttribute.FG_CYAN) + ")";
    }
}
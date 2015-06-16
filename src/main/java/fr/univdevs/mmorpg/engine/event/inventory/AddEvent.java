package fr.univdevs.mmorpg.engine.event.inventory;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

/**
 * Event thrown when an item is added in the inventory of a character
 *
 * @author Loïc Payol
 */
public class AddEvent extends InventoryEvent {
    private static final String NAME = "add";
    private Item item;

    public AddEvent(Item item, Character character) {
        super(NAME, character);
        this.item = item;
    }

    public AddEvent(Date date, Item item, Character character) {
        super(NAME, date, character);
        this.item = item;
    }

    @Override
    public String getDescription() {
        return new ANSIString(this.getSubject().getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " picks up " +
                new ANSIString(this.item.getType(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_BOLD) + " (" +
            new ANSIString(this.item.getID() + "", ANSIAttribute.ATTR_UNDERSCORE, ANSIAttribute.FG_CYAN) + ")";
    }
}

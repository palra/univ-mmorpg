package fr.univdevs.mmorpg.engine.event.inventory;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.Date;

public class NotEnoughMoneyEvent extends Event {
    private static final String TOPIC = "inventory";
    private static final String NAME = "not_enough_money";
    private Item item;
    private fr.univdevs.mmorpg.engine.character.Character character;

    public NotEnoughMoneyEvent(Item item, Character character) {
        super(TOPIC, NAME);
        this.item = item;
        this.character = character;
    }

    public NotEnoughMoneyEvent(Date date, Item item, Character character) {
        super(TOPIC, NAME, date);
        this.item = item;
        this.character = character;
    }

    @Override
    public String getDescription() {
        return new ANSIString(character.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " does not " +
            "have enough money (" + new ANSIString(character.getMoney() + "£", ANSIAttribute.FG_GREEN) + ") to buy " +
                new ANSIString(item.getType(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_BOLD) + " (" +
            new ANSIString(item.getID() + "", ANSIAttribute.ATTR_UNDERSCORE, ANSIAttribute.FG_CYAN) + ", " +
            new ANSIString(character.getMoney() + "£", ANSIAttribute.FG_GREEN) + ")";
    }
}
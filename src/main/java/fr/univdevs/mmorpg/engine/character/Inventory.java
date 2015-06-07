package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.logger.Event;
import fr.univdevs.mmorpg.engine.logger.Logger;
import fr.univdevs.mmorpg.engine.logger.LoggerAwareInterface;
import fr.univdevs.util.ansi.ANSIAttribute;
import fr.univdevs.util.ansi.ANSIString;

import java.util.*;

/**
 * Inventory
 * The inventory containing items
 */
public class Inventory implements LoggerAwareInterface {
    private HashMap<String, Item> items; // A HashMap is a couple of Objects, here a couple Integer, Item
    private Character character;
    private Logger logger;

    public Inventory() {
        throw new IllegalArgumentException("The character is mandatory");
    }

    /**
     * Inventory constructor
     * A HashMap is a couple string, item here
     * The string is the key (the name of the item)
     */
    public Inventory(Character c) {
        this.items = new HashMap<String, Item>();
        if (c == null)
            throw new IllegalArgumentException("The character is mandatory");
        this.character = c;
    }

    /**
     * Returns the character
     *
     * @return The character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Returns the logger
     *
     * @return The logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * {@inheritDoc}
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Redefinition of toString
     *
     * @return the generated String
     */
    public String toString() {
        String charac = "";
        for (int i = 0; i < this.getItems().length; i++) {
            charac += this.getItems()[i].toString() + '\n';
        }
        return charac;
    }

    /**
     * @return Item collection
     */
    public Item[] getItems() {
        return items.values().toArray(new Item[this.size()]);
    }

    /**
     * @return the size of the Inventory
     */
    public int size() {
        return items.size();
    }

    /**
     * @return True if Inventory is empty
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * @param category the selected category
     * @return matching items
     */
    public Item[] getByType(String category) {
        ArrayList<Item> selectedItems = new ArrayList<Item>();
        for (Item value : this.items.values()) {
            if (value.getCategory().equals(category)) {
                selectedItems.add(value);
            }
        }
        return selectedItems.toArray(new Item[selectedItems.size()]);
    }

    /**
     * @return all Types of the inventory
     */
    public String[] getTypes() {
        HashSet<String> types = new HashSet<String>(); //Hashset avoid doubles
        Iterator i = this.items.entrySet().iterator();
        for (Item value : this.items.values()) {
            types.add(value.getCategory());
        }

        return (String[]) types.toArray();
    }

    /**
     * @return sum of all the weights
     */
    public int getWeight() {
        int totalWeight = 0;
        Iterator i = this.items.entrySet().iterator();
        for (Item value : this.items.values()) {
            totalWeight += value.getWeight();
        }
        return totalWeight;
    }

    /**
     * @param item idem to be added
     */
    public Item add(Item item) {
        item.onRegister(character);
        Item i = this.items.put(item.getID(), item);

        if (i != null)
            i.onUnregister(character);

        if (logger != null) {
            logger.log(new InventoryAddEvent(i, character));
        }

        return i;
    }

    /**
     * Public method to check if the inventory the param Item
     *
     * @param item the item we want to check
     * @return true if the inventory contains the selected item
     */
    public boolean has(Item item) {
        return this.items.containsValue(item);
    }

    /**
     * Public method to check if the inventory has an item
     *
     * @param key We check the presence by the id
     * @return true if the inventory has the selected item
     */
    public boolean has(String key) {
        return this.items.containsKey(key);
    }


    /**
     * @param item The removed item, if removed
     */
    public Item remove(Item item) {
        Item i = this.items.remove(item.getID());
        if (i != null)
            i.onUnregister(this.getCharacter());

        if (logger != null) {
            logger.log(new InventoryRemoveEvent(i, character));
        }

        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;

        Inventory inventory = (Inventory) o;

        return items.equals(inventory.items);

    }

    public List<String> getIds() {
        ArrayList<String> results = new ArrayList<String>();
        for (String key : items.keySet()) {
            results.add(key);
        }
        return results;
    }

    public static class InventoryAddEvent extends Event {
        private static final String TOPIC = "inventory";
        private static final String NAME = "add";
        private Item item;
        private Character character;

        public InventoryAddEvent(Item item, Character character) {
            super(TOPIC, NAME);
            this.item = item;
            this.character = character;
        }

        public InventoryAddEvent(Date date, Item item, Character character) {
            super(TOPIC, NAME, date);
            this.item = item;
            this.character = character;
        }

        @Override
        public String getDescription() {
            return new ANSIString(character.getName(), ANSIAttribute.FG_BLUE, ANSIAttribute.ATTR_BOLD) + " ramasse " +
                new ANSIString(item.getCategory(), ANSIAttribute.FG_CYAN, ANSIAttribute.ATTR_BOLD) + " (" +
                new ANSIString(item.getID() + "", ANSIAttribute.ATTR_UNDERSCORE, ANSIAttribute.FG_CYAN) + ")";
        }
    }

    public static class InventoryRemoveEvent extends Event {
        private static final String TOPIC = "inventory";
        private static final String NAME = "remove";
        private Item item;
        private Character character;

        public InventoryRemoveEvent(Item item, Character character) {
            super(TOPIC, NAME);
            this.item = item;
            this.character = character;
        }

        public InventoryRemoveEvent(Date date, Item item, Character character) {
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
}

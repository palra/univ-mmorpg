package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.logger.LoggerAwareInterface;
import fr.univdevs.logger.LoggerInterface;
import fr.univdevs.mmorpg.engine.event.inventory.AddEvent;
import fr.univdevs.mmorpg.engine.event.inventory.RemoveEvent;

import java.util.*;

/**
 * Inventory
 * The inventory containing items
 */
public class Inventory implements LoggerAwareInterface {
    private HashMap<String, Item> items; // A HashMap is a couple of Objects, here a couple String, Item
    private Character character;
    private LoggerInterface logger;

    /**
     * Empty inventory constructor
     */
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
     * Inventory copy constructor
     *
     * @param other the inventory to copy
     */
    public Inventory(Inventory other) {
        this.items = other.items;
        this.character = other.character;
        this.logger = other.logger;
    }

    public Item getById(String chosenID) {
        return this.items.get(chosenID);
    }

    /**
     * Returns the character
     *
     * @return The character
     */
    public Character getCharacter() {
        return this.character;
    }

    /**
     * Returns the logger
     *
     * @return The logger
     */
    public LoggerInterface getLogger() {
        return this.logger;
    }

    /**
     * {@inheritDoc}
     */
    public void setLogger(LoggerInterface logger) {
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
        return this.items.values().toArray(new Item[this.size()]);
    }

    /**
     * @return the size of the Inventory
     */
    public int size() {
        return this.items.size();
    }

    /**
     * @return True if Inventory is empty
     */
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * @param category the selected category
     * @return matching items
     */
    public Item[] getByType(String category) {
        ArrayList<Item> selectedItems = new ArrayList<Item>();
        for (Item value : this.items.values()) {
            if (value.getType().equals(category)) {
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
            String cat = value.getType();
            if (!types.contains(cat)) {
                types.add(cat);
            }
        }

        return (String[]) types.toArray();
    }

    /**
     * @return sum of all the weights
     */
    public int getWeight() {
        int totalWeight = 0;
        for (Item value : this.items.values()) {
            totalWeight += value.getWeight();
        }
        return totalWeight;
    }

    /**
     * Adds the given item to the collection. If the item can't be added, returns it.
     *
     * @param chosenItem idem to be added
     *
     * @return the result this.items.put
     */
    public Item add(Item chosenItem) throws NotEnoughCashException {
        if (this.character.getMoney() >= chosenItem.getCost()) {
            chosenItem.onRegister(character);

            if (chosenItem != null)
                chosenItem.onUnregister(character);

            if (logger != null) {
                logger.log(new AddEvent(chosenItem, character));
            }

            this.character.setMoney(this.character.getMoney() - chosenItem.getCost());

        } else throw new NotEnoughCashException("Pas assez d'argent!");

        return this.items.put(chosenItem.getID(), chosenItem);
    }

    /**
     * Public method to check if the inventory the param Item
     *
     * @param item the item we want to check
     * @return true if the inventory contains the selected item
     */
    public boolean has(Object item) {
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
     * Public method to remove an item
     * @param item The removed item, if removed
     */
    public Item remove(Item item) {
        Item i = this.items.remove(item.getID());
        if (i != null)
            i.onUnregister(this.getCharacter());

        if (logger != null) {
            logger.log(new RemoveEvent(item, character));
        }

        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;

        Inventory inventory = (Inventory) o;

        return this.items.equals(inventory.items);

    }

    /**
     * Public method to get all the IDs of the inventory
     * @return the List of IDs
     */
    public List<String> getIds() {
        ArrayList<String> results = new ArrayList<String>();
        for (String key : this.items.keySet()) {
            results.add(key);
        }
        return results;
    }



    /**
     * Exception created in case there's not enough money
     */
    public static class NotEnoughCashException extends Exception {
        public NotEnoughCashException(String message) {
            super(message);
        }
    }
}

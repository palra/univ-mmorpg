package fr.univdevs.mmorpg.engine.character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Inventory
 * The inventory containing items
 *
 */
public class Inventory {
    public static final String[] protections = {"Helmet", "Shield"};
    private HashMap<Integer, Item> items; //A HashMap is a couple of Objects, here a couple String, Item
    private Character character;


    /**
     * Inventory constructor
     * A HashMap is a couple string, item here
     * The string is the key (the name of the item)
     */
    public Inventory(Character chosenCharacter) {
        this.items = new HashMap<Integer, Item>();
        this.character = chosenCharacter;
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
     *
     * @return  Item collection
     */
    public Item[] getItems(){
        return items.values().toArray(new Item[this.size()]);
    }

    /**
     * Public getter for Character
     *
     * @return the character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     *
     * @return  the size of the Inventory
     */
    public int size(){
        return items.size();
    }

    /**
     *
     * @return  True if Inventory is empty
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /**
     *
     * @param category  the selected category
     * @return  matching items
     */
    public Item[] getByType(String category){
        ArrayList<Item> selectedItems = new ArrayList<Item>();
        for(Item value : this.items.values()){
                if (value.getCategory().equals(category)) {
                    selectedItems.add(value);
                }
        }
        return selectedItems.toArray(new Item[selectedItems.size()]);
    }

    /**
     *
     * @return all Types of the inventory
     */
    public String[] getTypes(){
        HashSet<String> types = new HashSet<String>(); //Hashset avoid doubles
        Iterator i = this.items.entrySet().iterator();
        for(Item value : this.items.values()){
            types.add(value.getCategory());
        }

        return (String[]) types.toArray();
    }

    /**
     *
     * @return sum of all the weights
     */
    public int getWeight(){
        int totalWeight = 0;
        Iterator i = this.items.entrySet().iterator();
        for(Item value : this.items.values()){
            totalWeight += value.getWeight();
            }
        return totalWeight;
    }

    /**
     * Public method to check if the character can use the item
     *
     * @param wantedItem the item we want to add
     * @return true if the character can use the item
     */
    public boolean checkUse(Item wantedItem) {
        for (int i = 0; i < this.character.getCanUse().length; i++) {
            if (this.character.getCanUse()[i] == wantedItem.getCategory())
                return true;
        }
        return false;
    }


    /**
     *
     * @param item  idem to be added
     */
    public Item add(Item item) throws Exception {
        if (!checkUse(item)) throw new Exception();
        return this.items.put(item.getID(), item);
    }

    /**
     * Public method to check if the inventory the param Item
     * @param item  the item we want to check
     * @return true if the inventory contains the selected item
     */
    public boolean has(Item item) {

        return this.items.containsValue(item);
    }

    /**
     * Public method to check if the inventory has an item
     * @param key  We check the presence by the id
     * @return true if the inventory has the selected item
     */
    public boolean has(int key) {
        return this.items.containsKey(key);
    }

    /**
     *
     * @param item  item to be removed
     */
    public Item remove(Item item) {
        return this.items.remove(item.getID());
    }

    /**
     * Redefinition of equals method
     * @param o the object we want to compare
     * @return true if this and o are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;

        Inventory inventory = (Inventory) o;

        return items.equals(inventory.items);

    }

    /**
     * Public method to get the IDs of all the inventory's item
     * @return an arraylist containing these items
     */
    public ArrayList<Integer> getIds() {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (Integer key : items.keySet()) {
            results.add(key);
        }
        return results;
    }
}

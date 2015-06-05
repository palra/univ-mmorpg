package fr.univdevs.mmorpg.engine.character;

import java.lang.reflect.Array;
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
    private HashMap<Integer, Item> items; //A HashMap is a couple of Objects, here a couple String, Item

    /**
     * Inventory constructor
     * A HashMap is a couple string, item here
     * The string is the key (the name of the item)
     */
    public Inventory() {
        this.items = new HashMap<Integer, Item>();
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
     *
     * @param item  idem to be added
     */
    public Item add(Item item) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;

        Inventory inventory = (Inventory) o;

        return items.equals(inventory.items);

    }

    public ArrayList<Integer> getIds() {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (Integer key : items.keySet()) {
            results.add(key);
        }
        return results;
    }
}

package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.world.MovableEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @class Inventory
 * The inventory containing items
 *
 */
public class Inventory {
    private HashMap<String, Item> items; //A HashMap is a couple of Objects, here a couple String, Item

    /**
     * Inventory constructor
     * A HashMap is a couple string, item here
     * The string is the key (the name of the item)
     */
    public Inventory() {
        this.items = new HashMap<String, Item>();
    }

    public String toString() {
        String charac = new String();
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
        Iterator i = this.items.entrySet().iterator();
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
        String[] typeString = (String[])types.toArray();
        return typeString;
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
     * @param name  selected name
     * @return  matching items
     */
    public Item getByName(String name) {
        return this.items.get(name);
    }

    /**
     *
     * @param item  idem to be added
     */
    public Item add(Item item) {
        return this.items.put(item.getName(), item);
    }


    public boolean has(Item item) {

        return this.items.containsValue(item);
    }

    public boolean has(String name) {
        return this.items.containsKey(name);
    }



    /**
     *
     * @param item  item to be removed
     */
    public Item remove(Item item) {
        return this.items.remove(item.getName());
    }
}

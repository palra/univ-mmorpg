package fr.univdevs.mmorpg.engine.character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by drattak on 20/05/15.
 */
public class Inventory {
    public Inventory(){}
    public HashMap<String,Item> items;

    /**
     *
     * @return  Item collection
     */
    public Item[] getItems(){
        return (Item[]) items.values().toArray();
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
                    selectedItems.add(this.items.get(i));
                }
        }
        return (Item[]) selectedItems.toArray();
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
    public Item[] getByName(String name){
        ArrayList<Item> selectedItems = new ArrayList<Item>();
        Iterator i = this.items.entrySet().iterator();
        for(Item value : this.items.values()){
            if (value.getCategory().equals(name)) {
                selectedItems.add(this.items.get(i));
            }
        }
        return (Item[]) selectedItems.toArray();
    }

    /**
     *
     * @param item  idem to be added
     */
    public Item[] add(Item item){
        Item[] addedItem = new Item[1];
        if (this.items.values().add(item))
            addedItem[0] = item;

        return addedItem;
    }

    /**
     *
     * @param item  item to be removed
     */
    public Item[] remove(Item item){
        Item[] itemRemoved = new Item[1];
        if (this.items.values().remove(item)){
            itemRemoved[0] = item;
        }
        return itemRemoved;
    }
}

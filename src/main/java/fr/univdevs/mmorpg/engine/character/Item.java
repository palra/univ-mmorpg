package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.world.MovableEntity;
import fr.univdevs.util.Strings;

import java.util.ArrayList;

/**
 * Item class
 * An item is any object that can be wore
 */
public abstract class Item implements MovableEntity {
    private static ArrayList<String> ids = new ArrayList<String>();
    private String ID;
    private String category;
    private int cost;
    private int weight;

    private int x;
    private int y;

    /**
     * Item Constructor
     *
     * @param itemCategory category of the item, cannot be changed
     * @param itemCost     price of the item
     * @param itemWeight   weight of the item, cannot be changed
     */
    public Item(String itemCategory, int itemCost, int itemWeight) {
        this(itemCategory, itemCost);
        this.weight = itemWeight;
    }


    /**
     * Item Constructor
     *
     * @param itemCategory category of the item, cannot be changed
     * @param itemCost     price of the item
     */
    public Item(String itemCategory, int itemCost) {
        this.category = itemCategory;
        this.cost = itemCost;
        do {
            this.ID = Strings.random();
            ids.add(this.ID);
        } while (!ids.contains(this.ID));
    }

    public Item(Item other) {
        this.ids = new ArrayList<String>(other.ids);
        this.ID = new String(other.ID);
        this.category = new String(other.category);
        this.cost = other.cost;
        this.weight = other.weight;
        this.x = other.x;
        this.y = other.y;
    }


    public static ArrayList<String> getIds() {
        return ids;
    }

    public String toString() {
        return "id = " + this.getID() + '\n' + "category = " + this.getCategory() + "\n" + "cost = " + this.getCost() + "\n";
    }

    /**
     * Public method to return the category of the item
     *
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Public method to return the price of the item
     *
     * @return The cost of the item
     */
    public int getCost() {
        return cost;
    }

    /**
     * Public method to return the weight of the Item
     *
     * @return The weight of the item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Public method to indicate how the item will affect the character
     * By default, it does nothing.
     *
     * @param character on which character it will be applied
     */
    public void onRegister(Character character) {
    }

    /**
     * Public method to indicate how the item will affect the character
     * By default, it does nothing.
     *
     * @param character on which character it will be applied
     */
    public void onUnregister(Character character) {
    }

    /**
     * {@inheritDoc}
     */
    public int getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    public int getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Public getter for ID
     *
     * @return the ID of the object
     */
    public String getID() {
        return this.ID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (cost != item.cost) return false;
        if (weight != item.weight) return false;
        return category.equals(item.category);

    }
}

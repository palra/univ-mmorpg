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
    private String type;
    private int cost;
    private int weight;

    private int x;
    private int y;

    /**
     * Item Constructor
     *
     * @param itemType category of the item, cannot be changed
     * @param itemCost     price of the item
     * @param itemWeight   weight of the item, cannot be changed
     */
    public Item(String itemType, int itemCost, int itemWeight) {
        this.type = itemType;
        this.cost = itemCost;
        this.weight = itemWeight;
        do {
            this.ID = Strings.random32();
        } while (ids.contains(this.ID));
        ids.add(this.ID);
    }


    /**
     * Item copy constructor
     *
     * @param other the item to copy
     */
    public Item(Item other) {
        this.ID = other.ID;
        this.type = other.type;
        this.cost = other.cost;
        this.weight = other.weight;
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Redefinition of toString
     * @return the generated string
     */
    public String toString() {
        return "id = " + this.getID() + "\ncategory = " + this.getType() + "\ncost = " + this.getCost() + "\n";
    }

    /**
     * Public method to return the category of the item
     *
     * @return The category
     */
    public String getType() {
        return this.type;
    }

    /**
     * Public method to return the price of the item
     *
     * @return The cost of the item
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Public method to return the weight of the Item
     *
     * @return The weight of the item
     */
    public int getWeight() {
        return this.weight;
    }


    /**
     * {@inheritDoc}
     */
    public int getX() {
        return this.x;
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
        return this.y;
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

    /**
     * Method executed when this item is added to the inventory of the given character.
     * Here should be applied the wanted effect of the item on the character
     * By default, the method does nothing, so make sure the method is redefined if you want to apply your efffect
     *
     * @param c The owner of this item
     */
    public void onRegister(Character c) {
        c.setSpeed(c.getSpeed() - this.getWeight() / 20);
    }

    /**
     * Method executed when this item is removed to the inventory of the given character
     * Here should be removed the wanted effect of the item on the character
     * By default, the method does nothing, so make sure the method is redefined if you want to remove your efffect
     *
     * @param c The owner of this item
     */
    public void onUnregister(Character c) {
        c.setSpeed(c.getSpeed() + this.getWeight() / 20);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (this.cost != item.cost) return false;
        if (this.weight != item.weight) return false;
        return this.type.equals(item.type);

    }
}

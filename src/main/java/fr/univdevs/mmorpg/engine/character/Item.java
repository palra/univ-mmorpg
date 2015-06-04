package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.world.MovableEntity;

/**
 * Item class
 * An item is any object that can be wore
 */
public abstract class Item implements MovableEntity {
    private String name;
    private String category;
    private int cost;
    private int weight;

    private int x;
    private int y;

    /**
     * Item Constructor
     *
     * @param itemName     name of the item, cannot be changed
     * @param itemCategory category of the item, cannot be changed
     * @param itemCost     price of the item
     * @param itemWeight   weight of the item, cannot be changed
     */
    public Item(String itemName, String itemCategory, int itemCost, int itemWeight){
        this.name = itemName;
        this.category = itemCategory;
        this.cost = itemCost;
        this.weight = itemWeight;
    }

    /**
     * Item Constructor
     * @param itemName  name of the item, cannot be changed
     * @param itemCategory  category of the item, cannot be changed
     * @param itemCost  price of the item
     */
    public Item(String itemName, String itemCategory, int itemCost) {
        this.name = itemName;
        this.category = itemCategory;
        this.cost = itemCost;
    }

    public String toString() {
        return "name = " + this.getName() + "\n" + "category = " + this.getCategory() + "\n" + "cost = " + this.getCost() + "\n";
    }

    /**
     * Public method to return the name of the item
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Public method to return the category of the item
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Public method to return the price of the item
     * @return The cost of the item
     */
    public int getCost() {
        return cost;
    }

    /**
     * Public method to return the weight of the Item
     * @return The weight of the item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Public method to indicate how the item will affect the character
     * By default, it does nothing.
     * @param character on which character it will be applied
     */
    public void onRegister(Character character) {
    }

    /**
     * Public method to indicate how the item will affect the character
     * By default, it does nothing.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (cost != item.cost) return false;
        if (weight != item.weight) return false;
        if (!name.equals(item.name)) return false;
        return category.equals(item.category);

    }
}

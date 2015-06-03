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
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Public method to return the category of the item
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Public method to return the price of the item
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**
     * Public method to return the weight of the Item
     * @return
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Public abstract method to indicate how the item will affect the character
     * @param character on which character it will be applied
     */
    public abstract void onRegister(String character);

    /**
     * Public abstract method to indicate how the item will affect the character
     * @param character on which character it will be applied
     */
    public abstract void onUnregister(String character);

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

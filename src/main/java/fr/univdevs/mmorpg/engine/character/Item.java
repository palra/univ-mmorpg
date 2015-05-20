package fr.univdevs.mmorpg.engine.character;

/**
 * Created by drattak on 20/05/15.
 */
public abstract class Item {
    private String name;
    private String category;
    private int cost;
    private int weight;

    public Item(String itemName, String itemCategory, int itemCost, int itemWeight){
        this.name = itemName;
        this.category = itemCategory;
        this.cost = itemCost;
        this.weight = itemWeight;
    }

    public Item(String itemName, String itemCategory, int itemCost) {
        this.name = itemName;
        this.category = itemCategory;
        this.cost = itemCost;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public abstract void onRegister(String character);


    public abstract void onUnregister(String character);
}

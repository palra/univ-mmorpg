package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.world.MovableEntity;
import fr.univdevs.mmorpg.game.item.protection.Helmet;
import fr.univdevs.mmorpg.game.item.weapon.Knife;
import fr.univdevs.util.Numbers;
import fr.univdevs.util.ansi.ANSIChar;

import java.io.Serializable;

/**
 * The Character object. This is the character played by a player
 */
public abstract class Character implements MovableEntity, Serializable {
    private final static int MAX_HEALTH = 100;
    private final static double MAX_RESISTANCE = 0.99;
    private String type;
    private String name;
    private int experience;
    private int actionPoints;
    private int health;
    private double resistance;
    private int speed;
    private int money;
    private Inventory inventory;
    private int x;
    private int y;
    private ANSIChar display;

    /**
     * Character constructor
     *
     * @param chosenName Name chosen for the character, can't change
     * @param chosenType Type chosen for the character, can't change
     */
    public Character(String chosenName, String chosenType) {
        this(chosenName, chosenName.trim().toUpperCase().charAt(0), chosenType); //trim removes spaces before and after
    }

    /**
     * Character constructor
     *
     * @param chosenName    Name chosen for the character, can't change
     * @param chosenDisplay char that will be displayed on the map
     * @param chosenType    Type chosen for the character, can't change
     */
    public Character(String chosenName, char chosenDisplay, String chosenType) {
        this(chosenName, new ANSIChar(chosenDisplay), chosenType); //ansichar is for displaying in terminal
    }


    /**
     * Character constructor
     *
     * @param chosenName    Name chosen for the character, can't change
     * @param chosenDisplay ANSIChar, fos visuals, read-only (for public)
     * @param chosenType    Type chosen for the character, can't change
     */
    public Character(String chosenName, ANSIChar chosenDisplay, String chosenType) {
        this.name = chosenName;
        this.type = chosenType;
        this.inventory = new Inventory(this);
        this.money = 4000; //We set money before trying to add items
        try {        //Because Inventory.add throws Exception, we have to try{}catch(){}
            this.inventory.add(new Knife());
        } catch (Inventory.NotEnoughCashException e) {
            e.printStackTrace();
        }
        try {       //Because Inventory.add throws Exception, we have to try{}catch(){}
            this.inventory.add(new Helmet());
        } catch (Inventory.NotEnoughCashException e) {
            e.printStackTrace();
        }
        this.health = 100;
        this.resistance = 0.0;
        this.setDisplay(chosenDisplay);
        this.speed = 100;
        this.actionPoints = 300;
    }

    public Character(Character other) {
        this.type = other.type;
        this.name = other.name;
        this.experience = other.experience;
        this.actionPoints = other.actionPoints;
        this.health = other.health;
        this.resistance = other.resistance;
        this.speed = other.speed;
        this.money = other.money;
        this.inventory = new Inventory(other.inventory);
        this.x = other.x;
        this.y = other.y;
        this.display = new ANSIChar(other.display);
    }

    public String toString() {
        String charac = "";
        charac += "name = " + this.name + "\ntype = " + this.type + "\nexperience = " + this.experience + "\npoints d'action = " + this.actionPoints + "\npoints de vie = " + this.health + "\nresistance = " + this.resistance + "\nvitesse = " + this.speed + "\nargent = " + this.money + "\n\nINVENTAIRE : \n" + this.inventory.toString();
        return charac;
    }

    /**
     * Returns the money the Character has
     *
     * @return int
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Public method to change money Value
     *
     * @param money how much money we give
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Public mehod to get the type (category) of the character
     *
     * @return String
     */
    public String getType() {
        return this.type;
    }

    /**
     * Public method to return the name of the Character
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Public method to return the XP of the Character
     *
     * @return int
     */
    public int getExperience() {
        return this.experience;
    }

    /**
     * Public method to change XP of the Character
     *
     * @param experience amount of experience we want to give
     */
    public void setExperience(int experience) {
        this.experience = Numbers.clamp(experience, 0, Integer.MAX_VALUE);
    }

    /**
     * Public method to return the Action Points of the Character
     *
     * @return int
     */
    public int getActionPoints() {
        return this.actionPoints;
    }

    /**
     * Public method to give Action Points
     *
     * @param chosenActionPoints amount of Action Points to give
     */
    public void setActionPoints(int chosenActionPoints) {
        this.actionPoints = chosenActionPoints;
    }

    /**
     * Public method to return Health Point
     *
     * @return int
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Public method to give Health Point
     *
     * @param chosenHealth The new healh point value
     */
    public void setHealth(int chosenHealth) {
        this.health = Numbers.clamp(chosenHealth, 0, MAX_HEALTH);
    }

    /**
     * Public method to return resistance of a Character
     *
     * @return double
     */
    public double getResistance() {
        return this.resistance;
    }

    /**
     * Public method to give resistance to a character
     * @param resistance    coefficient to set, must be in [0;1)
     */
    public void setResistance(double resistance) {
        this.resistance = Numbers.clamp(resistance, 0, MAX_RESISTANCE);
    }

    /**
     * Public method to return the speed of a character
     *
     * @return int
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Public method to set the speed of a Character
     *
     * @param speed the speed of the character
     */
    public void setSpeed(int speed) {
        this.speed = speed;
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
     * Public method to return the inventory of a character
     *
     * @return Inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * {@inheritDoc}
     */
    public ANSIChar getDisplay() {
        return this.display;
    }

    /**
     * {@inheritDoc}
     */
    protected void setDisplay(ANSIChar display) {
        this.display = display;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isCollidable() {
        return true;
    }

    /**
     * Returns true if the given Item class can be used, false otherwise.
     *
     * @param itemClass The Item class
     * @return true if the itemClass can be used, false otherwise.
     */
    public boolean canUse(Class<? extends Item> itemClass) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;

        if (experience != character.experience) return false;
        if (actionPoints != character.actionPoints) return false;
        if (health != character.health) return false;
        if (Double.compare(character.resistance, resistance) != 0) return false;
        if (speed != character.speed) return false;
        if (money != character.money) return false;
        if (!type.equals(character.type)) return false;
        if (!name.equals(character.name)) return false;
        if (x != character.x) return false;
        if (y != character.y) return false;
        if (!getDisplay().equals(character.getDisplay())) return false;
        if (isCollidable() != character.isCollidable()) return false;
        return inventory.equals(character.inventory);

    }
}
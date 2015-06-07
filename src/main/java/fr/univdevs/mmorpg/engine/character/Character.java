package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.world.MovableEntity;
import fr.univdevs.util.Numbers;
import fr.univdevs.util.ansi.ANSIChar;

/**
 * The Character object. This is the character played by a player
 */
public abstract class Character implements MovableEntity {
    private final static int MAX_HEALTH = 100;
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
    public Character(String chosenName, String chosenType){
        this(chosenName, chosenName.trim().toUpperCase().charAt(0), chosenType);
    }

    /**
     * Character constructor
     *
     * @param chosenName    Name chosen for the character, can't change
     * @param chosenDisplay char that will be displayed on the map
     * @param chosenType    Type chosen for the character, can't change
     */
    public Character(String chosenName, char chosenDisplay, String chosenType) {
        this(chosenName, new ANSIChar(chosenDisplay), chosenType);
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
        this.health = 100;
        this.setDisplay(chosenDisplay);
    }

    public String toString() {
        String charac = "";
        charac += "name = " + this.name + "\n" + "type = " + this.type + "\n" + "experience = " + this.experience + "\n" + "points d'action = " + this.actionPoints + "\n" + "points de vie = " + this.health + "\n" + "resistance = " + this.resistance + "\n" + "vitesse = " + this.speed + "\n" + "argent = " + this.money + "\n" + "\nINVENTAIRE : \n" + this.inventory.toString();
        return charac;
    }

    /**
     * Returns the money the Character has
     *
     * @return int
     */
    public int getMoney() {
        return money;
    }

    /**
     * Public method to change money Value
     * @param money how much money we give
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Public mehod to get the type (category) of the character
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Public method to return the name of the Character
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Public method to return the XP of the Character
     * @return int
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Public method to change XP of the Character
     * @param experience    amount of experience we want to give
     */
    public void setExperience(int experience) {
        this.experience = Numbers.clamp(experience, 0, Integer.MAX_VALUE);
    }

    /**
     * Public method to return the Action Points of the Character
     * @return int
     */
    public int getActionPoints() {
        return actionPoints;
    }

    /**
     * Public method to give Action Points
     * @param chosenActionPoints    amount of Action Points to give
     */
    public void setActionPoints(int chosenActionPoints) {
        this.actionPoints = chosenActionPoints;
    }

    /**
     * Public method to return Health Point
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * Public method to give Health Point
     * @param chosenHealth The new healh point value
     */
    public void setHealth(int chosenHealth) {
        this.health = Numbers.clamp(chosenHealth, 0, MAX_HEALTH);
    }

    /**
     * Public method to return resistance of a Character
     * @return double
     */
    public double getResistance() {
        return resistance;
    }

    /**
     * Public method to give resistance to a character
     * @param resistance    coefficient to set, must be greater than 1
     */
    public void setResistance(double resistance) {
        this.resistance = Numbers.clamp(resistance, 1, Double.MAX_VALUE);
    }

    /**
     * Public method to return the speed of a character
     * @return int
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Public method to set the speed of a Character
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
     * @return Inventory
     */
    public Inventory getInventory(){
        return this.inventory;
    }

    /**
     * {@inheritDoc}
     */
    public ANSIChar getDisplay() {
        return display;
    }

    /**
     * {@inheritDoc}
     */
    protected void setDisplay(ANSIChar display) {
        this.display = display;
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
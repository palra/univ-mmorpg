package fr.univdevs.mmorpg.engine.character;

import fr.univdevs.mmorpg.engine.world.MovableEntity;

/**
 * The Character object. This is the character played by a player
 * It a
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

    /**
     * Character constructor
     *
     * @param chosenName Name chosen for the character, can't change
     * @param chosenType Type chosen for the character, can't change
     */
    public Character(String chosenName, String chosenType){
        this.name = chosenName;
        this.type = chosenType;
        this.inventory = new Inventory();
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
     * Private method to change money Value
     * @param money how much money we give
     */
    private void setMoney(int money) {
        this.money = money;
    }

    /**
     * Public method to add Money
     * @param money the amount of money we want to add
     */
    public void addMoney(int money){
        this.setMoney(this.getMoney()+money);
    }

    /**
     * Public method to remove Money
     * @param money the amount of money we want to remove
     */
    public void removeMoney(int money){
        this.setMoney(this.getMoney()-money);
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
     * Private method to change XP of the Character
     * @param experience    amount of experience we want to give
     */
    private void setExperience(int experience) {

        this.experience = experience;
    }

    /**
     * Public method to add experience to the Character
     *
     * @param experience amount of experience we want to add
     */
    public void addExperience(int experience){
        this.setExperience(this.getExperience()+experience);
    }

    /**
     * Public method to remove experience to the Character
     * @param experience    amout of experience we want to remove
     */
    public void removeExperience(int experience){
        this.setExperience(this.getExperience()-experience);
    }

    /**
     * Public method to return the Action Points of the Character
     * @return int
     */
    public int getActionPoints() {
        return actionPoints;
    }

    /**
     * Private method to give Action Points
     * @param chosenActionPoints    amount of Action Points to give
     */
    private void setActionPoints(int chosenActionPoints) {
        this.actionPoints = chosenActionPoints;
    }

    /**
     * Public method to add Action Points
     * @param actionPoints    amount of Action Points to add
     */
    public void addActionPoints(int actionPoints) {
        this.setActionPoints(this.getActionPoints() + actionPoints);
    }

    /**
     * Public method to remove Action Points
     * @param action    amount of Action Points to remove
     */
    public void removeActionPoints(int action) {
        this.setActionPoints(this.getActionPoints() - action);
    }

    /**
     * Public method to return Health Point
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * Private method to give Health Point
     * @param health    amount of health points to give
     */
    private void setHealth(int health) {
        this.health = health;
    }

    /**
     * Public method to add Health Point
     * @param health    amount of health points to add
     */
    public void addHealth(int health){
        this.setHealth(this.getHealth()+health);
    }

    /**
     * Public method to remove Health Point
     * @param health    amount of health points to remove
     */
    public void removeHealth(int health){
        this.setHealth(this.getHealth()+health);
    }

    /**
     * Public method to return resistance of a Character
     * @return double
     */
    public double getResistance() {
        return resistance;
    }

    /**
     * Private method to give resistance to a character
     * @param resistance    coefficient to set
     */
    private void setResistance(double resistance) {
        this.resistance = resistance;
    }

    /**
     * Public method to add resistance to a character
     * @param resistance    coefficient to add
     */
    public void addResistance(double resistance){
        this.setResistance(this.getResistance()+resistance);
    }

    /**
     * Public method to remove resistance
     * @param resistance    coefficient to remove
     */
    public void removeResistance(double resistance){
        this.setResistance(this.getResistance()-resistance);
    }

    /**
     * Public method to return the speed of a character
     * @return int
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Private method to set the speed of a Character
     * @param speed the speed of the character
     */
    private void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Public method to add speed to a character
     * @param speed amount of speed we want to add
     */
    public void addSpeed(int speed){
        this.setSpeed(this.getSpeed()+speed);
    }

    /**
     * Public method to remove speed to a character
     * @param speed amount of speed we want to remove
     */
    public void removeSpeed(int speed){
        this.setSpeed(this.getSpeed()-speed);
    }

    /**
     * Public method to return the inventory of a character
     * @return Inventory
     */
    public Inventory getInventory(){
        return this.inventory;
    }


}

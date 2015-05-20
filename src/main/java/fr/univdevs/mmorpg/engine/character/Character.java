package fr.univdevs.mmorpg.engine.character;

/**
 * Created by drattak on 20/05/15.
 */
public abstract class Character {
    private final static int MAX_HEALTH = 100;
    private String type;
    private String name;
    private int experience;
    private int action;
    private int health;
    private double resistance;
    private int speed;
    private int money;
    private Inventory inventory;

    public Character(String chosenName, String chosenType){
        this.name = chosenName;
        this.type = chosenType;
        this.inventory = new Inventory();
    }

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money){
        this.setMoney(this.getMoney()+money);
    }

    public void removeMoney(int money){
        this.setMoney(this.getMoney()-money);
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    private void setExperience(int experience) {

        this.experience = experience;
    }

    public void addEpxerience(int experience){
        this.setExperience(this.getExperience()+experience);
    }

    public void removeExperience(int experience){
        this.setExperience(this.getExperience()-experience);
    }

    public int getAction() {
        return action;
    }

    private void setAction(int action) {
        this.action = action;
    }

    public void addAction(int action){
        this.setAction(this.getAction()+action);
    }

    public void removeAction(int action){
        this.setAction(this.getAction()-action);
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public void addHealth(int health){
        this.setHealth(this.getHealth()+health);
    }

    public void removeHealth(int health){
        this.setHealth(this.getHealth()+health);
    }

    public double getResistance() {
        return resistance;
    }

    private void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public void addResistance(double resistance){
        this.setResistance(this.getResistance()+resistance);
    }

    public void removeResistance(double resistance){
        this.setResistance(this.getResistance()-resistance);
    }

    public int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    public void addSpeed(int speed){
        this.setSpeed(this.getSpeed()+speed);
    }

    public void removeSpeed(int speed){
        this.setSpeed(this.getSpeed()-speed);
    }

    public Inventory getInventory(){
        return this.inventory;
    }


}

package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Item;

/**
 * Abstract class weapon
 * Each character has the ability to own one or more weapons in its inventory
 */
public abstract class Weapon extends Item {
    private int power;

    /**
     * Weapon constructor
     *
     * @param weaponName     name of the weapon, cannot be changed
     * @param weaponCategory category of the weapon, cannot be changed
     * @param weaponCost     cost of the weapon
     * @param weaponWeight   weight of the weapon, cannot be changed
     * @param weaponPower    power of the weapon
     */
    public Weapon(String weaponName, String weaponCategory, int weaponCost, int weaponWeight, int weaponPower) {
        super(weaponName, weaponCategory, weaponCost, weaponWeight);
        this.power = weaponPower;
    }

    /**
     * Weapon constructor
     * @param weaponName    name of the weapon, cannot be changed
     * @param weaponCategory    category of the weapon, cannot be changed
     * @param weaponCost    cost of the weapon
     * @param weaponPower   power of the weapon
     */
    public Weapon(String weaponName, String weaponCategory, int weaponCost, int weaponPower) {
        super(weaponName, weaponCategory, weaponCost);
        this.power = weaponPower;
    }

    /**
     * function to return the power of a weapon
     * @return int
     */
    public int getPower(){
        return this.power;
    }
}

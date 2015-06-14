package fr.univdevs.mmorpg.engine.character.item;

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
     * @param weaponCategory category of the weapon, cannot be changed
     * @param weaponCost     cost of the weapon
     * @param weaponWeight   weight of the weapon, cannot be changed
     * @param weaponPower    power of the weapon
     */
    public Weapon(String weaponCategory, int weaponCost, int weaponWeight, int weaponPower) {
        super(weaponCategory, weaponCost, weaponWeight);
        this.power = weaponPower;
    }


    /**
     * Copy constructor of weapon
     * @param other the weapon we want to copy
     */
    public Weapon(Weapon other) {
        super(other);
        this.power = other.power;
    }

    /**
     * function to return the power of a weapon
     *
     * @return int
     */
    public int getPower() {
        return this.power;
    }

    public boolean isCollidable() {
        return false;
    }
}

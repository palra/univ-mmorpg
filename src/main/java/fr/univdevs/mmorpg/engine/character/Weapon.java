package fr.univdevs.mmorpg.engine.character;

/**
 * Created by drattak on 20/05/15.
 */
public abstract class Weapon extends Item{
    private int power;

    public Weapon(String weaponName, String weaponCategory, int weaponCost, int weaponWeight, int weaponPower) {
        super(weaponName, weaponCategory, weaponCost, weaponWeight);
        this.power = weaponPower;
    }

    public Weapon(String weaponName, String weaponCategory, int weaponCost, int weaponPower) {
        super(weaponName, weaponCategory, weaponCost);
        this.power = weaponPower;
    }

    public int getPower(){
        return this.power;
    }
}

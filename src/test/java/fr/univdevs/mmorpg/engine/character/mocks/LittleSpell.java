package fr.univdevs.mmorpg.engine.character.mocks;

/**
 * Created by drattak on 29/05/15.
 */
public class LittleSpell extends Weapon {
    /**
     * {@inheritDoc}
     *
     * @param weaponName
     * @param weaponCategory
     * @param weaponWeight
     */
    public LittleSpell(String weaponName, String weaponCategory, int weaponWeight) {
        super(weaponName, weaponCategory, 120, weaponWeight, 50);
    }

    /**
     * {@inheritDoc}
     *
     * @param weaponName
     * @param weaponCategory
     */
    public LittleSpell(String weaponName, String weaponCategory) {
        super(weaponName, weaponCategory, 120, 50);
    }

    @Override
    public void onRegister(String character) {

    }

    @Override
    public void onUnregister(String character) {

    }

    public int getX() {
        return 0;
    }

    public void setX(int x) {

    }

    public int getY() {
        return 0;
    }

    public void setY(int y) {

    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return false;
    }
}

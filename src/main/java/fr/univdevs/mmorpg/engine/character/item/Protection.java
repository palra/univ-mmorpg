package fr.univdevs.mmorpg.engine.character.item;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;

/**
 * Item representing a character's protection
 */
public abstract class Protection extends Item {
    private double robustness;

    /**
     * Protection constructor
     * A protection is something the character carries to improve his defence
     *
     * @param protectionCost       the cost
     * @param protectionWeight     the Weight, is added to character's weight
     * @param protectionRobustness is equivalent to efficiency of the protection
     */
    public Protection(String protectionCategory, int protectionCost, int protectionWeight, double protectionRobustness) {
        super(protectionCategory, protectionCost, protectionWeight);
        this.robustness = protectionRobustness;
    }

    public Protection(Protection other) {
        super(other);
        this.robustness = other.robustness;
    }


    /**
     * Getter of robustness
     *
     * @return robustness
     */
    public double getRobustness() {
        return this.robustness;
    }

    public boolean isCollidable() {
        return false;
    }

    @Override
    public void onRegister(Character c) {
        super.onRegister(c);
        c.setResistance(
            c.getResistance() + this.robustness);

    }

    @Override
    public void onUnregister(Character c) {
        super.onRegister(c);
        c.setResistance(
            c.getResistance() - this.robustness
        );
    }


}

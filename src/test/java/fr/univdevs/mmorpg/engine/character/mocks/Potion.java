package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Cure;

/**
 * Potion testclass
 * A Potion is a kind of cure, therefore it extends to it
 * A Potion restore 10 points
 */
public class Potion extends Cure{
    public Potion(String potionName, String potionCategory, int potionCost, int potionWeight, int potionPoints){
        super(potionName,potionCategory,potionCost,potionWeight,potionPoints);
    }

    /**
     * function to specify the action of the potion
     *
     * @param Character on which character the potion will be applied
     */
    public void onRegister(String Character) {
    }

    /**
     * function to specify the action of the potion
     * @param Character on which character the potion will be applied
     */
    public void onUnregister(String Character){}
}

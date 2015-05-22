package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Cure;

/**
 * Created by drattak on 20/05/15.
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

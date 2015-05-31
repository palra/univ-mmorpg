package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Item;

/**
 * Created by drattak on 20/05/15.
 */
public abstract class Protection extends Item {
    private double robustness;

    public Protection(String protectionName, String protectionCategory, int protectionCost, int protectionWeight,double protectionRobustness){
        super(protectionName,protectionCategory,protectionCost, protectionWeight);
        this.robustness = protectionRobustness;
    }

    public double getRobustness(){
        return this.robustness;
    }

}

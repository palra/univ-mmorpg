package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Weapon;

/**
 * Created by drattak on 21/05/15.
 */
public class Bow extends Weapon {
    public Bow(String bowName, String bowCategory, int bowCost, int bowWeight, int bowPower) {
        super(bowName, bowCategory, bowCost, bowWeight, bowPower);
    }

    @Override
    public void onRegister(String character) {

    }

    @Override
    public void onUnregister(String character) {

    }
}

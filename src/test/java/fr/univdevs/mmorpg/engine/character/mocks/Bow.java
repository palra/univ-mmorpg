package fr.univdevs.mmorpg.engine.character.mocks;

import fr.univdevs.mmorpg.engine.character.Weapon;

/**
 * Testclass Bow
 * A Bow
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

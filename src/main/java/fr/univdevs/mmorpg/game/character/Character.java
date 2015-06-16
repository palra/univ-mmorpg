package fr.univdevs.mmorpg.game.character;


public class Character {
    private final static int MAX_HEALTH = 100;
    private final static double MAX_RESISTANCE = 0.99;


    public static int getMaxHealth() {
        return MAX_HEALTH;
    }

    public static double getMaxResistance() {
        return MAX_RESISTANCE;
    }
}

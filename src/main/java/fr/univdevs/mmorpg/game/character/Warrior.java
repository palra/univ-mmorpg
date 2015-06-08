package fr.univdevs.mmorpg.game.character;

import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.Item;
import fr.univdevs.mmorpg.game.item.cure.HealerCure;

/**
 * Created by drattak on 23/05/15.
 * TODO : document
 */
public class Warrior extends Character {
    /**
     * Default constructor
     *
     * @param name The name of the warrior
     */
    public Warrior(String name) {
        super(name, "Warrior");
    }

    @Override
    public boolean canUse(Class<? extends Item> itemClass) {
        return !(itemClass.isAssignableFrom(HealerCure.class)); // instanceof Cure
    }
}

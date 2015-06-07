package fr.univdevs.mmorpg.engine.character.skills;

import fr.univdevs.mmorpg.engine.character.Character;

/**
 * Interface representing the ability to fight with other characters
 *
 * @author Vincent Emile
 */
public interface CanFight {
    void attack(Character target, String weaponName);
}

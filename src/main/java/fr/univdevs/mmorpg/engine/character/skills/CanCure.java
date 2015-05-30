package fr.univdevs.mmorpg.engine.character.skills;

/**
 * Interface representing the ability to cure other characters
 *
 * @author Vincent Emile
 */
public interface CanCure {
    void cure(Character c, String cureName);
}

package fr.univdevs.mmorpg.engine.character.skills;

/**
 * Interface representing the ability to put spells on other characters
 *
 * @author Vincent Emile
 * @author Loïc Payol
 */
public interface CanSpell {
    void putSpell(Character c, String spellName);
}

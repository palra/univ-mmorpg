package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.util.ansi.ANSIChar;

/**
 * Public interface Entity, declare any object to an entity, that can be displayed in the map
 */
public interface Entity {

    /**
     * Returns the horizontal position of the entity
     *
     * @return int The horizontal position of the entity
     */
    int getX();

    /**
     * Returns the vertical position of the entity
     *
     * @return int The vertical position of the entity
     */
    int getY();

    /**
     * Returns the ANSIChar that represents the entity on the map.
     *
     * @return The display character
     */
    ANSIChar getDisplay();

    /**
     * When moving an entity, does this entity blocks the way ?
     * @return The collidableness of the entity
     */
    boolean isCollidable();
}

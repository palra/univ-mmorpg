package fr.univdevs.mmorpg.engine.world;

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
     * Returns the String that represents the entity on the map.
     * Note that it could be a char, as it MUST be rendered as a char on the screen, but we assume that you know it, so
     * make sure your string is rendered as a single character on the terminal, if you use ANSI Colors
     * <p/>
     * TODO : make a class in order to make sure that a single character will be printed and add the possibility to add some colors
     *
     * @return The display "string"
     */
    String getDisplay();

    /**
     * When moving an entity, does this entity blocks the way ?
     * @return The collidableness of the entity
     */
    boolean isCollidable();
}

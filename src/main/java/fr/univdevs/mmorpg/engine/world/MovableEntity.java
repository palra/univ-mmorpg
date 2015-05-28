package fr.univdevs.mmorpg.engine.world;

/**
 * Public interface MovableEntity
 * This interface declare as movable any entity that implements it
 */
public interface MovableEntity extends Entity {
    /**
     * Sets the horizontal position of the entity
     *
     * @param x the horizontal position of the entity
     */
    void setX(int x);

    /**
     * Sets the vertical position of the entity
     *
     * @param y the vertical position of the entity
     */
    void setY(int y);
}

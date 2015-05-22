package fr.univdevs.mmorpg.engine.world;

/**
 * Public interface MovableEntity
 * This interface declare as movable any entity that implements it
 */
public interface MovableEntity extends Entity {
    public void setX(int x);
    public void setY(int y);
}

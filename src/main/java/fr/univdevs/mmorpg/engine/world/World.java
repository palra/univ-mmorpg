package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.util.Vector2D;

import java.util.HashMap;

/**
 * Public class world
 * It represents the world of the game
 */
public class World {
    private HashMap<Vector2D<Integer>, Entity> entities;
    private Tilemap tilemap;

    /**
     * World constructor
     *
     * @param tilemap The tilemap
     */
    public World(Tilemap tilemap) {
        this.entities = new HashMap<Vector2D<Integer>, Entity>();
        this.tilemap = tilemap;
    }

    /**
     * Returns the tilemap
     *
     * @return The tilemap
     */
    public Tilemap getTilemap() {
        return tilemap;
    }

    /**
     * Public method addEntity to add an Entity to the world
     *
     * @param e the Entity we want to add
     * @return null if no entity was at this place, the old entity otherwise
     */
    public Entity addEntity(Entity e) throws EntityCollisionException {
        return this.entities.put(new Vector2D<Integer>(e.getX(), e.getY()), e);
    }

    /**
     * Public method to return an Entity
     *
     * @param x the horizontal position of the entity you want to get
     * @param y the vertical position of the entity you want to get
     * @return the entity, if exists
     */
    public Entity getEntity(int x, int y) {
        return this.entities.get(new Vector2D<Integer>(x, y));
    }

    /**
     * Moves a given entity to nb cases from `dir` direction
     *
     * @param dir The direction of the move
     * @param nb  The number of cases to move, must be positive
     * @return true if a collision occured, false otherwise.
     */
    public boolean move(MovableEntity e, Direction dir, int nb) {
        if (nb <= 0)
            return false;

        int i = 0;
        boolean collision = false;
        int up_dir = (dir == Direction.UP) ? 1 : (dir == Direction.DOWN) ? -1 : 0;
        int right_dir = (dir == Direction.RIGHT) ? 1 : (dir == Direction.LEFT) ? -1 : 0;

        while (i < nb && !collision) {
            collision = isCollidableAt(e.getX(), e.getY());

            e.setX(e.getX() + up_dir);
            e.setY(e.getY() + right_dir);
            i++;
        }

        if (collision) {
            e.setX(e.getX() - up_dir);
            e.setY(e.getY() - right_dir);
        }

        return collision;
    }

    public boolean isCollidableAt(int x, int y) {
        Entity e = getEntity(x, y);
        return e != null && e.isCollidable();
    }

    public enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    /**
     * Exception thrown when an entity is colliding something in the world, and that is not expected.
     * @author Loïc Payol
     */
    public static class EntityCollisionException extends Exception {
        /**
         * {@inheritDoc}
         */
        public EntityCollisionException(String message) {
            super(message);
        }
    }
}

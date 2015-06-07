package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.util.Vector2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
     * @return An instance of MoveResult, that sets nonCollidableEntities at null when no movment has been done.
     */
    public MoveResult move(MovableEntity e, Direction dir, int nb) {
        if (nb <= 0)
            return new MoveResult(null, false, 0);

        int i = 0;
        boolean collision = false;
        int up_dir = (dir == Direction.UP) ? -1 : (dir == Direction.DOWN) ? 1 : 0;
        int right_dir = (dir == Direction.RIGHT) ? 1 : (dir == Direction.LEFT) ? -1 : 0;
        List<Entity> nonCollidableEntities = new ArrayList<Entity>();

        while (i < nb && !collision) {
            e.setX(e.getX() + right_dir);
            e.setY(e.getY() + up_dir);
            collision = isCollidableAt(e.getX(), e.getY());

            Entity inplace = getEntity(e.getX(), e.getY());
            if (inplace != null && !inplace.isCollidable()) {
                nonCollidableEntities.add(inplace);
            }

            i++;
        }

        if (collision) {
            e.setX(e.getX() - right_dir);
            e.setY(e.getY() - up_dir);
            i--;
        }

        return new MoveResult(nonCollidableEntities, collision, i);
    }

    public boolean isCollidableAt(int x, int y) {
        Entity e = getEntity(x, y);
        Tilemap.Tile t = tilemap.getTileAt(x, y);
        return (e != null && e.isCollidable()) || (t != null && t.isCollidable());
    }

    public enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public static class MoveResult {
        private final List<Entity> nonCollidableEntities;
        private final boolean collision;
        private final int nbCases;

        public MoveResult(List<Entity> nonCollidableEntities, boolean collision, int nbCases) {
            this.nonCollidableEntities = nonCollidableEntities;
            this.collision = collision;
            this.nbCases = nbCases;
        }

        public List<Entity> getNonCollidableEntities() {
            return nonCollidableEntities;
        }

        public boolean isCollision() {
            return collision;
        }

        public int getNbCases() {
            return nbCases;
        }
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

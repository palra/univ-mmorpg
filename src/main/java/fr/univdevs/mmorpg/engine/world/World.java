package fr.univdevs.mmorpg.engine.world;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Public class world
 * It represents the world of the game
 */
public class World implements Serializable {
    private ArrayList<Entity> entities;
    private Tilemap tilemap;

    /**
     * World constructor
     *
     * @param tilemap The tilemap
     */
    public World(Tilemap tilemap) {
        this.entities = new ArrayList<Entity>();
        this.tilemap = tilemap;
    }

    public World(World other) {
        this.entities = new ArrayList<Entity>(other.entities);
        this.tilemap = new Tilemap(other.tilemap);
    }

    /**
     * Returns the tilemap
     *
     * @return The tilemap
     */
    public Tilemap getTilemap() {
        return this.tilemap;
    }

    /**
     * Public method addEntity to add an Entity to the world
     *
     * @param e the Entity we want to add
     * @return true
     */
    public boolean addEntity(Entity e) {
        return this.entities.add(e);
    }

    /**
     * Removes the entity passed in parameter from the world
     *
     * @param e The entity we want to remove
     * @return true if the entity was removed, false otherwise
     */
    public boolean removeEntity(Entity e) {
        return this.entities.remove(e);
    }

    /**
     * Public method to return an Entity
     *
     * @param x the horizontal position of the entity you want to get
     * @param y the vertical position of the entity you want to get
     * @return the entity, if exists
     */
    public Entity getEntity(int x, int y) {
        ListIterator<Entity> it = this.entities.listIterator();
        Entity entity = null;
        while (it.hasNext() && entity == null) {
            Entity e = it.next();
            if (e.getX() == x && e.getY() == y)
                entity = e;
        }

        return entity;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * Moves a given entity to nb cases from `dir` direction
     *
     * @param dir The direction of the move
     * @param nb  The number of cases to move, must be positive
     * @return An instance of MoveResult, that sets nonCollidableEntities at null when no movment has been done.
     */
    public MoveResult move(MovableEntity e, Direction dir, int nb) {
        if (nb == 0)
            return new MoveResult(null, false, 0);

        int i = 0;
        boolean collision = false;
        int up_dir = ((nb < 0) ? -1 : 1) * ((dir == Direction.UP) ? -1 : (dir == Direction.DOWN) ? 1 : 0);
        int right_dir = ((nb < 0) ? -1 : 1) * ((dir == Direction.RIGHT) ? 1 : (dir == Direction.LEFT) ? -1 : 0);
        nb = Math.abs(nb);
        List<Entity> nonCollidableEntities = new ArrayList<Entity>();

        while (i < nb && !collision) {
            int newX = e.getX() + right_dir;
            int newY = e.getY() + up_dir;
            // Query the entity that is at the next position
            Entity inplace = getEntity(newX, newY);
            if (inplace != null && !inplace.isCollidable()) {
                nonCollidableEntities.add(inplace);
            }

            // Checking if any collision
            collision = isCollidableAt(newX, newY);

            if (!collision) {
                // Move the entity
                e.setX(newX);
                e.setY(newY);
                i++;
            }
        }

        return new MoveResult(nonCollidableEntities, collision, i);
    }

    public boolean isCollidableAt(int x, int y) {
        Entity e = getEntity(x, y);
        Tilemap.Tile t = this.tilemap.getTileAt(x, y);
        return (e != null && e.isCollidable()) || (t != null && t.isCollidable());
    }

    public enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public static class MoveResult implements Serializable {
        private final List<Entity> nonCollidableEntities;
        private final boolean collision;
        private final int nbCases;

        public MoveResult(List<Entity> nonCollidableEntities, boolean collision, int nbCases) {
            this.nonCollidableEntities = nonCollidableEntities;
            this.collision = collision;
            this.nbCases = nbCases;
        }

        public List<Entity> getNonCollidableEntities() {
            return this.nonCollidableEntities;
        }

        public boolean isCollision() {
            return this.collision;
        }

        public int getNbCases() {
            return this.nbCases;
        }
    }

}

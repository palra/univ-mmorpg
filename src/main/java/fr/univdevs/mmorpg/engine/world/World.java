package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.util.Vector2D;

import java.util.HashMap;

/**
 * Public class world
 * It represents the world of the game
 */
public class World {

    private HashMap<Vector2D<Integer>, Entity> entities;

    /**
     * World constructor
     */
    public World() {
        entities = new HashMap<Vector2D<Integer>, Entity>();
    }

    /**
     * Public method addEntity to add an Entity to the world
     *
     * @param e the Entity we want to add
     * @return null if no entity was at this place, the old entity otherwise
     */
    public Entity addEntity(Entity e) {
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


}

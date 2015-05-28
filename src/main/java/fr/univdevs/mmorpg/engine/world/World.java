package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.mmorpg.engine.utils.Vector2D;

import java.util.HashMap;

/**
 * Public class world
 * It represents the world of the game
 */
public class World {

    private HashMap<Vector2D<Integer, Integer>, Entity> entities;

    /**
     * World constructor
     */
    public World() {
        entities = new HashMap<Vector2D<Integer, Integer>, Entity>();
    }

    /**
     * Public method addEntity to add an Entity to the world
     *
     * @param e the Entity we want to add
     * @return the Entity we just added
     */
    public Entity addEntity(Entity e) {
        this.entities.put(new Vector2D<Integer, Integer>(e.getX(), e.getY()), e);
        return e;
    }

    /**
     * Public method to return an Entity
     *
     * @param e the Entity we want to get
     * @return the entity got
     */
    public Entity getEntity(Entity e) {
        return this.entities.get(e);
    }


}

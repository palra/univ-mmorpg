package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.mmorpg.engine.character.utils.Pair;
import fr.univdevs.mmorpg.engine.world.Entity;

import java.util.HashMap;

/**
 * Public class world
 * It represents the world of the game
 */
public class World {

    private HashMap<Pair<Integer, Integer>, Entity> entities;

    /**
     * World constructor
     */
    public World() {
        entities = new HashMap<Pair<Integer, Integer>, Entity>();
    }

    /**
     * Public method addEntity to add an Entity to the world
     *
     * @param e the Entity we want to add
     * @param p the positon of this Entity
     * @return the Entity we just added
     */
    public Entity addEntity(Entity e, Pair<Integer, Integer> p) {
        this.entities.put(p, e);
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

package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.mmorpg.engine.utils.Pair;

/**
 * Public interface Entity, declare any object to an entity, that can be displayed in the map
 */
public interface Entity {
    int getX();

    int getY();

    String getDisplay();

    boolean isCollidable();

    Pair getPair();
}

package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.mmorpg.engine.character.utils.Pair;

/**
 * Public interface Entity, declare any object to an entity, that can be displayed in the map
 */
public interface Entity {
    public int getX();
    public int getY();
    public String getDisplay();
    public boolean isCollidable();

    public Pair getPair();
}

package fr.univdevs.mmorpg.engine.world;

/**
 * Created by drattak on 19/05/15.
 */
public interface Entity {
    public int getX();
    public int getY();
    public String getDisplay();
    public boolean isCollidable();

}

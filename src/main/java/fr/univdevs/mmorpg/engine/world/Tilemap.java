package fr.univdevs.mmorpg.engine.world;

/**
 * Tilemap class
 * A Tilemap is a map represented with characters
 * In facts, this is an array of char
 */
public class Tilemap {

    public final static int GRID_SIZE = 10;

    private char[] tiles;

    public Tilemap(char[] chosenTiles) {
        tiles = chosenTiles;
    }

    /**
     * Public method to get the Char of the map
     *
     * @return An array of char, composing the map
     */
    public char[] getTiles() {
        return tiles;
    }

    /**
     * Public method render the map
     * The map is an array of char, render will format it to a map
     */
    public void render() {
        for (int i = 0; i < this.tiles.length; i++) {
            System.out.print(this.tiles[i]);
        }
    }

    public boolean exists(int x, int y) {
        return (x * GRID_SIZE + y <= tiles.length);
    }

    /**
     * Public method to return one tile
     *
     * @param x the Easting of the tile
     * @param y the Northing of the tile
     * @return The tile we want to get
     */
    public char getTile(int x, int y) {
        return tiles[x * GRID_SIZE + y];
    }

    /**
     * Public method to set a tile
     *
     * @param x the Easting of the tile
     * @param y the Northing of the tile
     * @param c the tile we want to add
     * @return the tile added
     */
    public char setTile(int x, int y, char c) throws Exception {
        if (!(exists(x, y))) throw new Exception("La case n'existe pas");
        tiles[x * GRID_SIZE + y] = c;
        return c;
    }

    /**
     * Public method to have the size (litteral) of the map
     *
     * @return the size
     */
    public int getSize() {
        return this.tiles.length;
    }

}

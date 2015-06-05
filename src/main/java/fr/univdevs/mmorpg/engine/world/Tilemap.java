package fr.univdevs.mmorpg.engine.world;

import java.io.PrintStream;

/**
 * Tilemap class
 * A Tilemap is a map represented with characters
 *
 * @author Vincent Emile
 */
public class Tilemap {

    private static char EMPTY_CHAR = ' ';
    private char[] tiles;
    private int dimension;

    public Tilemap(int dimension) {
        this.tiles = new char[dimension * dimension];
        this.dimension = dimension;
    }

    /**
     * Tilemap Constructor
     *
     * @param chosenTiles the char array representing the tiles, assuming its length is a square number.
     */
    public Tilemap(char[] chosenTiles) {
        tiles = chosenTiles;
        dimension = (int) Math.sqrt(tiles.length);
    }

    /**
     * Returns the 1-dimensional array of tiles.
     *
     * @return An array of char, composing the map
     */
    public char[] getTiles() {
        return tiles;
    }

    /**
     * Renders the map.
     *
     * @param out The ourput print stream
     */
    public void render(PrintStream out) {
        for (int i = 0; i < this.tiles.length; i++) {
            out.print(this.tiles[i]);
            if (i % dimension == 0 && i != 0)
                out.println();
        }
    }

    /**
     * Checks if a given position is in the tilemap.
     *
     * @param x The horizontal position to test
     * @param y The vertical position to test
     * @return true if the position is valid, false otherwise
     */
    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < dimension && y >= 0 && y < dimension);
    }

    /**
     * Returns the display character of the tile at a given position
     *
     * @param x The horizontal position
     * @param y The vertical position
     * @return The char at the given position.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    public char getCharAt(int x, int y) {
        return this.tiles[x * dimension + y];
    }

    /**
     * Checks if a given position contains an empty tile
     *
     * @param x The horizontal position to test
     * @param y The vertical position to test
     * @return The char at the given position.
     *
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    public boolean isEmptyAt(int x, int y) {
        return getCharAt(x, y) != EMPTY_CHAR;
    }

    /**
     * Public method to return one tile
     *
     * @param x The horizontal position
     * @param y The vertical position
     * @return The tile we want to get, if exists, null otherwise
     */
    public Entity getTileAt(int x, int y) {
        if (!isValidPosition(x, y))
            return null;

        char c = getCharAt(x, y);
        return new Tile(x, y, c, !isEmptyAt(x, y));
    }

    /**
     * Sets the tile
     *
     * @param x The horizontal position
     * @param y The vertical position
     * @param c the tile we want to add
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    public void setTile(int x, int y, char c) {
        this.tiles[x * dimension + y] = c;
    }

    /**
     * Returns the length of a side of the tilemap
     * @return The dimension
     */
    public int getDimension() {
        return dimension;
    }

    public static class Tile implements Entity {
        private int x;
        private int y;
        private char disp;
        private boolean collidable;

        public Tile(int x, int y, char disp, boolean collidable) {
            this.x = x;
            this.y = y;
            this.disp = disp;
            this.collidable = collidable;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getDisplay() {
            return "" + disp; // Cast to string
        }

        public boolean isCollidable() {
            return collidable;
        }
    }
}

package fr.univdevs.mmorpg.engine.world;

import fr.univdevs.util.Vector2D;
import fr.univdevs.util.ansi.ANSIChar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static fr.univdevs.util.Numbers.randomInt;

/**
 * Tilemap class
 * A Tilemap is a map represented with characters
 *
 * @author Vincent Emile
 */
public class Tilemap {

    private static char EMPTY_CHAR = ' ';
    private char[] tiles;
    private int width;
    private int height;


    public Tilemap(int dimension) {
        this.tiles = new char[dimension * dimension];
        this.width = this.height = dimension;
    }

    public Tilemap(int width, int height) {
        this.tiles = new char[width * height];
        this.width = width;
        this.height = height;
    }

    /**
     * Tilemap Constructor
     *
     * @param chosenTiles the char array representing the tiles, assuming its length is a square number.
     */
    public Tilemap(char[] chosenTiles, int width, int height) {
        tiles = chosenTiles;
        if (width * height != tiles.length)
            throw new IllegalArgumentException("Width and height does not correspond to the given array");

        this.width = width;
        this.height = height;
    }

    public Tilemap(Tilemap other) {
        this.tiles = other.tiles;
        this.width = other.width;
        this.height = other.height;
    }


    /**
     * Creates a new Tilemap from a resource file.
     * <p/>
     * Syntax of a file:
     * <width>
     * <height>
     * <map>
     * <p/>
     * Where :
     * - `width` is the number of columns of the map
     * - `height` is the number of rows of the map
     * - `map` is a string with `height` substrings of `width` length, separated by a EOF character (\n, depending of
     * your OS).
     *
     * @param filename The path to the resource file, is an absolute link where `/` points at the root of the
     *                 `main/resources` folder.
     * @return A new instance of the Tilemap
     * @throws IOException If any error occured with file reading
     */
    public static Tilemap newFromFilename(String filename) throws IOException {
        Scanner sc = new Scanner(Tilemap.class.getResourceAsStream(filename));
        int width = sc.nextInt();
        int height = sc.nextInt();
        sc.nextLine();

        Tilemap tilemap = new Tilemap(width, height);

        for (int row = 0; row < height; row++) {
            String strRow = sc.nextLine();
            for (int col = 0; col < width; col++) {
                tilemap.setTile(col, row, strRow.charAt(col));
            }
        }

        return tilemap;
    }

    /**
     * Returns the 1-dimensional array of tiles.
     *
     * @return An array of char, composing the map
     */
    public char[] getTiles() {
        return this.tiles;
    }

    public Entity[] getTilesEntity() {
        Entity[] tiles = new Entity[this.tiles.length];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tiles[row * width + col] = this.getTileAt(col, row);
            }
        }

        return tiles;
    }

    /**
     * Renders the map.
     *
     * @return the rendered map
     */
    public String render() {
        String out = "";
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                out += getCharAt(col, row);
            }
            out += System.lineSeparator();
        }

        return out;
    }

    /**
     * Checks if a given position is in the tilemap.
     *
     * @param x The horizontal position to test
     * @param y The vertical position to test
     * @return true if the position is valid, false otherwise
     */
    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
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
        return this.tiles[y * width + x];
    }

    /**
     * Checks if a given position contains an empty tile
     *
     * @param x The horizontal position to test
     * @param y The vertical position to test
     * @return The char at the given position.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    public boolean isEmptyAt(int x, int y) {
        return getCharAt(x, y) == EMPTY_CHAR;
    }

    /**
     * Public method to return one tile
     *
     * @param x The horizontal position
     * @param y The vertical position
     * @return The tile we want to get, if exists, null otherwise
     */
    public Tile getTileAt(int x, int y) {
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
        this.tiles[y * width + x] = c;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Returns a random position on the tilemap, in an empty tile.
     *
     * @return The random position, null if not available
     */
    public Vector2D<Integer> getEmptyRandomPosition() {
        List<Vector2D<Integer>> emptyPositions = new ArrayList<Vector2D<Integer>>();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (isEmptyAt(col, row))
                    emptyPositions.add(new Vector2D<Integer>(col, row));
            }
        }

        if (emptyPositions.isEmpty())
            return null;

        return emptyPositions.get(randomInt(0, emptyPositions.size() - 1));
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

        public ANSIChar getDisplay() {
            return new ANSIChar(disp);
        }

        public boolean isCollidable() {
            return collidable;
        }
    }
}

package fr.univdevs.mmorpg.engine.world;

/**
 * Tilemap class
 * A Tilemap is a map represented with characters
 * In facts, this is an array of char
 */
public class Tilemap {
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

    public void render() {
        for (int i = 0; i < this.tiles.length; i++) {
            System.out.print(this.tiles[i]);
        }
    }
}

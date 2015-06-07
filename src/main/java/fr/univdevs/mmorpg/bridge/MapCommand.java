package fr.univdevs.mmorpg.bridge;

import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.world.Entity;
import fr.univdevs.mmorpg.engine.world.Tilemap;

/**
 * Command that dumps the map of a GameManager
 * Synopsis:
 * map
 *
 * @author Loïc Payol
 */
public class MapCommand extends GameManagerAwareCommand {
    private static String MAP_ONLY_OPT = "--map-only";

    public MapCommand() {
        this.setName("map");
    }

    @Override
    public String execute(String[] args) throws Exception {
        boolean mapOnly = args.length >= 1 && args[0].equals(MAP_ONLY_OPT);
        Tilemap tilemap = this.getGameManager().getWorld().getTilemap();
        Entity[] entities = tilemap.getTilesEntity();

        int width = tilemap.getWidth();
        int height = tilemap.getHeight();

        if (!mapOnly) {
            GameManager gm = this.getGameManager();

            // Displays the players
            for (Player p : gm.getPlayers()) {
                Character c = p.getCharacter();
                entities[c.getY() * width + c.getX()] = c;
            }

            // TODO : displays the items in the world
        }

        String out = "";

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                out += entities[row * width + col].getDisplay();
            }
            out += System.lineSeparator();
        }

        return out;
    }

    @Override
    public String getSynopsis() {
        return "[" + MAP_ONLY_OPT + "]";
    }
}

package fr.univdevs.mmorpg.bridge;

import fr.univdevs.commander.CommandException;
import fr.univdevs.mmorpg.engine.GameManager;
import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.world.Entity;
import fr.univdevs.mmorpg.engine.world.Tilemap;
import fr.univdevs.mmorpg.engine.world.World;

import java.util.List;

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
    public String execute(String[] args) throws CommandException {
        boolean mapOnly = args.length >= 1 && args[0].equals(MAP_ONLY_OPT);
        World world = this.getGameManager().getWorld();
        Tilemap tilemap = world.getTilemap();
        Entity[] entities = tilemap.getTilesEntity();

        int width = tilemap.getWidth();
        int height = tilemap.getHeight();

        if (!mapOnly) {
            GameManager gm = this.getGameManager();

            // Query the world entities
            List<Entity> entitiesToAdd = world.getEntities();

            // Query the players
            for (Player p : gm.getPlayers()) {
                entitiesToAdd.add(p.getCharacter());
            }

            // And add the whole to the global list
            for (Entity e : entitiesToAdd) {
                entities[e.getY() * width + e.getX()] = e;
            }
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

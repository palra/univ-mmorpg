package fr.univdevs.mmorpg.bridge;

/**
 * Command that dumps the map of a GameManager
 * Synopsis:
 * map
 *
 * @author Loïc Payol
 */
public class MapCommand extends GameManagerAwareCommand {

    public MapCommand() {
        this.setName("map");
    }

    @Override
    public String execute(String[] args) throws Exception {
        return this.getGameManager().getWorld().getTilemap().render();
    }

    @Override
    public String getSynopsis() {
        return "";
    }
}

package fr.univdevs.mmorpg.game;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.game.character.Healer;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.util.Strings;

import java.util.*;

/**
 * Collection of methods that initializes a game.
 *
 * @author Vincent Emile
 */
public class AppInit {
    private static List<Player> players = new ArrayList<Player>();
    private static String resumePlayers = "";

    /*public static void main(String[] args) {
        init();
        System.out.println(affichePlayer(players));
    }*/

    public static List<Player> init() throws InputMismatchException {
        int number = getNumberofPlayers();
        for (int i = 0; i < number; i++) {
            System.out.println("Player " + (i + 1) + " :");
            playerInit();
        }
        return players;
    }

    public static int getNumberofPlayers() throws InputMismatchException {
        Scanner sc;
        do {
            System.out.print("How many players do you want to create ? ");
            sc = new Scanner(System.in);
        } while (!(sc.hasNextInt()));
        return sc.nextInt();
    }

    public static boolean playerInit() {
        System.out.print("Enter the name of the player : ");
        String playerName = new Scanner(System.in).nextLine();
        System.out.print("Enter the name of his character : ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("What category of character do you want ?\n" +
            "1. Warrior\n" +
            "2. Healer"
        );
        int category = new Scanner(System.in).nextInt();
        return players.add(new Player(Strings.toCamelCase(playerName), determineCharacter(category, name)));
    }


    public static Character determineCharacter(int category, String name) {
        switch (category) {
            case 1:
                return new Warrior(Strings.toCamelCase(name));
            case 2:
                return new Healer(Strings.toCamelCase(name));
        }
        return null;
    }

    public static String affichePlayer(HashMap<String, Player> players) {

        for (Player player : players.values()) {
            resumePlayers += player.toString();
        }
        return resumePlayers;
    }

}


package fr.univdevs.mmorpg.game;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.game.character.Healer;
import fr.univdevs.mmorpg.game.character.Warrior;
import fr.univdevs.util.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

    public static List<Player> init() {
        System.out.println("Combien de joueurs ?");
        int number = new Scanner(System.in).nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Joueur " + (i + 1));
            playerInit();
        }
        return players;
    }


    public static boolean playerInit() {
        System.out.println("Entrez le nom du joueur : ");
        String playerName = new Scanner(System.in).nextLine();
        System.out.println("Entrez le nom du personnage : ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Quelle categorie ?\n" +
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


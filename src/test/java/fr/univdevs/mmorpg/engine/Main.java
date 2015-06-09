package fr.univdevs.mmorpg.engine;

import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.world.World;
import fr.univdevs.mmorpg.game.character.Healer;
import fr.univdevs.mmorpg.game.character.Warrior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by drattak on 08/06/15.
 */
public class Main {
    private static HashMap<String, Player> players = new HashMap<String, Player>();
    public static void main(String[] args) {
        init();
        fight(players);
    }

    public static void init() {
        System.out.println("Combien de joueurs ?");
        int number = new Scanner(System.in).nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("JOUEUR " + (i + 1));
            playerInit();
        }
    }


    public static Player playerInit() {
        System.out.println("Entrez le nom du joueur : ");
        String playerName = new Scanner(System.in).nextLine();
        System.out.println("Entrez le nom du personnage : ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Quelle categorie ?\n1.Warrior\n2. Healer");
        int category = new Scanner(System.in).nextInt();
        return players.put(playerName, new Player(playerName, determineCharacter(category, name)));
    }

    public static Character determineCharacter(int category, String name) {
        switch (category) {
            case 1:
                return new Warrior(name);
            case 2:
                return new Healer(name);
        }
        return null;
    }

    public static void fight(HashMap<String, Player> players) {
    }

}


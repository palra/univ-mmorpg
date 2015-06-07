package fr.univdevs.mmorpg;

import fr.univdevs.mmorpg.engine.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to test the engine
 */
public class EngineTest {
    private ArrayList<Player> players;

    public void registerPlayers() {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Combien de joueurs ? ");
        number = sc.nextInt();
    }

    public void init() {

    }
}

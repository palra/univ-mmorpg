package fr.univdevs.mmorpg;

import fr.univdevs.mmorpg.engine.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to test the engine
 */
public class EngineTest {
    private ArrayList<Player> players;

    public static void main(String[] args) {

    }

    @Test
    public void registerPlayers() throws Exception {
        int number;
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        System.out.println("Combien de joueurs ? ");
        number = sc.nextInt();
        System.out.println(number);
    }

    public void init() {
    }


}

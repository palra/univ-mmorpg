package fr.univdevs.mmorpg.game;

import java.io.FileNotFoundException;

/**
 * The main application
 *
 * @author Loïc Payol
 */
public class App {

    public static void main(String[] args) {
        try {
            Game game;

            try {
                game = Game.readFrom("game.sav");
            } catch (FileNotFoundException e) {
                game = new Game();
            }
            game.play();
            game.saveTo("game.sav");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
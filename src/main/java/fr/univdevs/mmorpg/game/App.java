package fr.univdevs.mmorpg.game;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * The main application
 *
 * @author Loïc Payol
 */
public class App {

    private static String fileName;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int choice;
        Scanner sc = new Scanner(System.in);
        Game game;

        do {
            System.out.println("Select an action :");
            System.out.println("(1) Start a new game");
            System.out.println("(2) Load from file");
            System.out.print("Your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
        } while (choice < 1 || choice > 2);

        if (choice == 1) { // Start a new game
            game = new Game();
        } else {
            game = loadFromFile();
        }

        game.play();

        System.out.print("Do you want to save your game ? (y/N) : ");
        String save = sc.nextLine();
        if (save.trim().toUpperCase().equals("Y"))
            App.saveToFile(game);
    }

    private static Game loadFromFile() throws IOException, ClassNotFoundException {
        File file;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter the name of your save file : ");
            file = new File(sc.nextLine());
        } while (!(file.exists() && file.isFile()));

        fileName = file.getPath();
        return Game.readFrom(file);
    }


    private static void saveToFile(Game game) throws IOException {
        File file;
        Scanner sc = new Scanner(System.in);
        String name;

        do {
            System.out.print("Enter the name of your save file [" + fileName + "]: ");
            name = sc.nextLine();
            if (name.trim().isEmpty())
                name = fileName;
            file = new File(name);
        } while (file.exists() && !file.isFile());

        game.saveTo(file);
    }
}
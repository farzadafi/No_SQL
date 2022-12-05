package view;

import service.MongoService;

import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final MongoService mongoService;

    public Menu() {
        mongoService = new MongoService();
    }

    public void mainMenu() {
        int command;
        while (true) {
            System.out.println("********WELCOME*********");
            printGreen("Current DB is " + mongoService.getCurrentDBName());
            System.out.println("1-Create DB and Switch to it");
            System.out.println("2-Get all DB name");
            System.out.println("3-Drop DB with Name");
            System.out.println("4-Get all collection on Current DB");
            System.out.println("5-Create a collection");
            System.out.println("6-remove a collection");
            System.out.println("7-Insert a document");
            System.out.println("8-remove a document");
            System.out.println("9-Find One Document");
            System.out.println("10-Exit");
            System.out.println("Enter your command:");
            command = input.nextInt();
            input.nextLine();
            switch (command) {
                case 1 -> mongoService.addDBOrSwitch();

                case 2 -> mongoService.getAllDBName();

                case 3 -> mongoService.dropDB();

                case 4 -> mongoService.getCollectionName();

                case 5 -> mongoService.createCollection();

                case 6 -> mongoService.removeCollection();

                case 7 -> mongoService.createOneDocument();

                case 8 -> mongoService.removeOneDocument();

                case 9 -> mongoService.findOneDocument();

                case 10 -> {
                    System.out.println("Good Luck!");
                    System.exit(0);
                }
            }
        }
    }

    public void printGreen(String input) {
        System.out.println("\u001b[32m |" + input + "\u001b[0m");
    }
}

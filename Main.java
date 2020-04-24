package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        intro();
        int gm = gameMode();
        ArrayList<Boolean> booleanVariables = new ArrayList<Boolean>(); // all boolean variables will be stored here
        booleanVariables.add(false); // quit added at pos 0
        booleanVariables.add(true); // isPlayer1 added at pos 1
        booleanVariables.add(false); // end added at pos 2
        booleanVariables.add(true); // showStats added at pos 3

        ArrayList<Player> playerArrayList = createPlayer(gm);
        Gameboard gameboard = new Gameboard();

        while(!booleanVariables.get(0)) { // while !quit
            if(gm == 1) {

            } else {
                choose(playerArrayList, booleanVariables);
            }
        }
    }

    private static void intro() {

        System.out.println("Welcome to 4 in a line! \n" +
                "Created by Deacu David Theodor \n" +
                "You have to connect 4 symbols in a row to win! \n" +
                "Symbols can be connected in any direction: vertically, horizontally or diagonally. \n" +
                "Let the game begin! Good luck & Have fun!\n" +
                "Press any key to begin!");
                scanner.nextLine();
    }

    private static ArrayList<Player> createPlayer(int gameMode) {
        ArrayList<Player> playerArrayList = new ArrayList<>();
        boolean isDuo = gameMode != 1; // if gamemode = 1, isDuo = false ; else isDuo = true

        switch (gameMode) {
            case 1: //for single player
                playerArrayList.clear(); // clears the array from a previous gamemode.
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                Player player = new Player(name, isDuo);
                playerArrayList.add(player);
                String difficulty;
                while(true) {
                    System.out.println("Choose difficulty: (1)Easy, (2)Medium, (3)Hard");
                    difficulty = scanner.nextLine();
                    if(difficulty.equals("1") || difficulty.equals("2") || difficulty.equals("3") || difficulty.toLowerCase().equals("easy") || difficulty.toLowerCase().equals("medium") || difficulty.toLowerCase().equals("hard")) {
                        if(difficulty.toLowerCase().equals("easy")) {
                            difficulty = "1";
                        } else if(difficulty.toLowerCase().equals("medium")) {
                            difficulty = "2";
                        } else if(difficulty.toLowerCase().equals("hard")) {
                            difficulty = "3";
                        }
                        break;
                    } else {
                        System.out.println("Invalid difficulty input (try: 1 or 2 or 3 or easy or medium or hard)");
                    }
                }
//                Bot bot = new Bot(Integer.parseInt(difficulty));
                break;
            case 2: // for two players
                playerArrayList.clear(); // clears the array from a previous gamemode.
                char symbol1;
                char symbol2;
                System.out.println("(Player1)Enter your name: ");
                String name1 = scanner.nextLine();
                Player player1 = new Player(name1, isDuo);
                String sym1;

                while(true) {
                    System.out.println("(" + name1 + ")Choose your symbol (X or O)");
                    sym1 = scanner.nextLine();

                    if(sym1.toUpperCase().equals("X") || sym1.toUpperCase().equals("O")) {
                        break;
                    } else {
                        System.out.println("invalid input! The symbol must be X or O!");
                    }

                }
                sym1 = sym1.toUpperCase();
                symbol1 = sym1.charAt(0);

                System.out.println("(Player2)Enter your name: ");
                String name2 = scanner.nextLine();
                Player player2 = new Player(name2, isDuo);

                if(symbol1 == 'X') {
                    symbol2 = 'O';
                } else {
                    symbol2 = 'X';
                }

                player1.setSymbol(symbol1);
                player2.setSymbol(symbol2);
                playerArrayList.add(player1);
                playerArrayList.add(player2);
                break;
        }
        return playerArrayList;
    }

    private static int gameMode() {

        int gameMode;
        do {
            System.out.println("Choose your game mode:\n" +
                    "Press '1' for Single Player\n" +
                    "Press '2' for Two Players");
            gameMode = scanner.nextInt();
            scanner.nextLine();
        } while (gameMode != 1 && gameMode != 2);
        return gameMode;
    }

    private static void choose(ArrayList<Player> playerArrayList, ArrayList<Boolean> booleanVariables) {

        int checkChoice;
        booleanVariables.set(2, false); // set end to false
        while(!booleanVariables.get(2)) { // while !end
            int playerIndex;

            if(booleanVariables.get(1)) { // if isPlayer1 turn
                playerIndex = 0;
            } else {
                playerIndex = 1;
            }

                Gameboard.printBoard();
                if(booleanVariables.get(3)) { // if showStats = true
                    printGameProgress(playerArrayList);
                    booleanVariables.set(3, false); // showStats = false
                }
                System.out.println("Is " + playerArrayList.get(playerIndex).getName() + "`s turn.");

                while(true) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if(choice >= 1 && choice <= 7) {

                        checkChoice = Gameboard.choose(playerArrayList.get(playerIndex), choice-1);
                        if(checkChoice == -1) { // position full

                            System.out.println(playerArrayList.get(playerIndex).getName() + " is choosing again.");

                        } else if(checkChoice == 2) { // game continues, nobody won
                            if(booleanVariables.get(1)) {
                                booleanVariables.set(1, false); // isPlayer1 turn = false;
                            } else {
                                booleanVariables.set(1, true); // isPlayer1 turn = true;
                            }
                            break;
                        } else if(checkChoice == 0 || checkChoice == 1) { //symbols may be inverted // somebody won
                            scanner.nextLine(); // pause after match finishes
                            booleanVariables.set(2, true); // its end game = true
                            playerArrayList.get(playerIndex).setWin();

                            if(booleanVariables.get(1)) {
                                booleanVariables.set(1, false); // isPlayer1 turn = false;
                            } else {
                                booleanVariables.set(1, true); // isPlayer1 turn = true;
                            }

                            if(playerIndex == 0) {
                                playerArrayList.get(1).setLoose();
                            } else {
                                playerArrayList.get(0).setLoose();
                            }

                            booleanVariables.set(3, true); // if end game, show stats = true
                            break;
                        } else if(checkChoice == 3) { // if its a tie

                            scanner.nextLine(); // pause after match finishes
                            booleanVariables.set(2, true); // its end game = true

                            if(booleanVariables.get(1)) {
                                booleanVariables.set(1, false); // isPlayer1 turn = false;
                            } else {
                                booleanVariables.set(1, true); // isPlayer1 turn = true;
                            }

                            booleanVariables.set(3, true); // if end game, show stats = true
                            break;
                        }
                    } else {
                        System.out.println("Incorrect choice (must be between 1 and 7).");
                    }
                }
            }
    }

    private static void printGameProgress( ArrayList<Player> playerArrayList) {
        for(int i = 0 ; i < playerArrayList.size() ; i++) {
            System.out.println("================\n" +
                    "Name: " + playerArrayList.get(i).getName() + " | Wins: " + playerArrayList.get(i).getWins() + " | Loses: " +
                    + playerArrayList.get(i).getLosses() + " | W/L Ratio: " + String.format("%.2f", playerArrayList.get(i).getWinLossRatio()) + "\n" +
                    "================");
        }
    }
}

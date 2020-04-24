package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameboard {
    private static String[][] board;
    private static Scanner scanner = new Scanner(System.in);

    public Gameboard() {
        board = new String[6][7];

        for(int i = 0 ; i < 6 ; i++) {
            for(int j = 0; j < 7 ; j++) {
                board[i][j] = ".";
            }
        }
    }

    private static void resetBoard() {
        for(int i = 0 ; i < 6 ; i++) {
            for(int j = 0; j < 7 ; j++) {
                board[i][j] = ".";
            }
        }
        System.out.println("The game has been reseted!");
    }

    public static void printBoard() {

        for(int i = 0 ; i < 20 ; i++) {
            System.out.println(" ");
        }

        for(int i = 0 ; i < 6 ; i++) {
            System.out.println("|" + "     " + board[i][0] + "     " + board[i][1] + "     " + board[i][2] + "     " + board[i][3] + "     " + board[i][4] + "     " + board[i][5] + "     " + board[i][6] + "     " + "|");
            if(i != 5) {
                System.out.println("|                                               |");
            }
        }
        System.out.println(" ______________________________________________ ");
        System.out.println("");
        System.out.println("      " + 1 + "     " + 2 + "     " + 3 + "     " + 4 +  "     " + 5 + "     " + 6 + "     " + 7);
    }

    public static int choose(Player player, int position) {

        if(board[0][position].charAt(0) != '.'){
            System.out.println("Position full!");
            return -1;
        }
        for(int i = 5 ; i >= 0 ; i--) { //is searching for the first free level

             if(board[i][position].charAt(0) == '.') {

                 board[i][position] = String.valueOf(player.getSymbol());
                 int checker = checkEnd();

                 if(checker == 0) {
                     printBoard();
                     System.out.println(player.getName() + " won!\n" +
                             "Press any key to start a new match!");
                     resetBoard();
                     return checker;
                 } else if(checker == 1) {

                     printBoard();
                     System.out.println(player.getName() + " won!\n" +
                             "Press any key to start a new match!");
                     resetBoard();
                     return checker;
                 } else if(checker == 3) {

                     printBoard();
                     System.out.println("Its a tie!\n" +
                             "Press any key to start a new match!");
                     resetBoard();
                     return checker;
                 }
                 break;
             }
         }
        return 2;
    }

    private static ArrayList<Integer> validate(int line, int col, ArrayList<Integer> counters) {

        if(board[line][col].equals(String.valueOf('X'))) {

            counters.set(1, counters.get(1) + 1); //counter X ++;
            counters.set(0, 0); //counter O = 0;
            if(counters.get(1) == 4) {
                counters.add(1); // if X won, a new entry "1" will be added
                return counters;
            }

        } else if(board[line][col].equals(String.valueOf('O'))) {

            counters.set(0, counters.get(0) + 1); //counter O ++;
            counters.set(1, 0); //counter X = 0;
            if (counters.get(0) == 4) {
                counters.add(0); // if O won, a new entry "0" will be added
                return counters;
            }
        } else {
            counters.set(0, 0);
            counters.set(1, 0);
        }
        return counters;
    }

    private static int checkEnd() {
        ArrayList<Integer> validateOutput;
        ArrayList<Integer> counters = new ArrayList<>();
        counters.add(0); // O counter at index 0
        counters.add(0); // X counter at index 1

        int i;
        int j;


        //check for horizontally cases
        for(i = 0 ; i < 6 ; i++) {
            counters.set(0,0); // the counter for O is set to 0, because we are checking a different line
            counters.set(1,0); // the counter for X is set to 0

            for(j = 0 ; j < 7 ; j++) {

                validateOutput = validate(i, j, counters);
                if(validateOutput.size() > 2) { //size > 2 means an entry was added(somebody won)
                    return validateOutput.get(2); //will return 0 for player O, or 1 for player X
                } else {
                    counters.set(0, validateOutput.get(0)); //updates counters
                    counters.set(1, validateOutput.get(1));
                }
            }
        }

        //check for vertically cases
        for(j = 0 ; j < 7 ; j++) {
            counters.set(0,0);
            counters.set(1,0);

            for(i = 0 ; i < 6 ; i++) {

                validateOutput = validate(i, j, counters);
                if(validateOutput.size() > 2) {
                    return validateOutput.get(2);
                } else {
                    counters.set(0, validateOutput.get(0));
                    counters.set(1, validateOutput.get(1));
                }
            }
        }

        //check for diagonally primary LOWER cases
        for(int m = 0 ; m <= 1 ; m++) { //just 2 diagonals with at least 4 elements (except of primary diagonal)
            counters.set(0,0);
            counters.set(1,0);
            i = m + 1;

            for(j = 0 ; i <= 5 ; j++) {

                validateOutput = validate(i, j, counters);
                if(validateOutput.size() > 2) {
                    return validateOutput.get(2);
                } else {
                    counters.set(0, validateOutput.get(0));
                    counters.set(1, validateOutput.get(1));
                }
                i++;
            }
        }

        //check for diagonally primary CENTER cases
        counters.set(0,0);
        counters.set(1,0);
        for(i = 0 ; i < 6 ; i++) {

            validateOutput = validate(i, i, counters);
            if(validateOutput.size() > 2) {
                return validateOutput.get(2);
            } else {
                counters.set(0, validateOutput.get(0));
                counters.set(1, validateOutput.get(1));
            }
        }

        //check for diagonally primary UPPER cases
        for(int m = 0 ; m <= 2 ; m++) { //just 3 diagonals with at least 4 elements
            counters.set(0,0);
            counters.set(1,0);
            i = 0;
            j=m+1;
            for(int n = 0 ; j <= 6 ; n++) {

                validateOutput = validate(i, j, counters);
                if(validateOutput.size() > 2) {
                    return validateOutput.get(2);
                } else {
                    counters.set(0, validateOutput.get(0));
                    counters.set(1, validateOutput.get(1));
                }
                i++;
                j++;
            }
        }

        //check for diagonally secondary LOWER cases
        for(int m = 0 ; m <= 2 ; m++) { //just 3 diagonals with at least 4 elements
            counters.set(0,0);
            counters.set(1,0);
            i = 5;
            j = m+1;
            for(int n = 0 ; j <= 6 ; n++) {

                validateOutput = validate(i, j, counters);
                if(validateOutput.size() > 2) {
                    return validateOutput.get(2);
                } else {
                    counters.set(0, validateOutput.get(0));
                    counters.set(1, validateOutput.get(1));
                }
                i--;
                j++;
            }
        }

        //check for diagonally secondary UPPER cases
        for(int m = 6 ; m >= 4 ; m--) { //just 3 diagonals with at least 4 elements
            counters.set(0,0);
            counters.set(1,0);
            i = m-1;
            for(j = 0 ; i >= 0 ; j++) {
                validateOutput = validate(i, j, counters);
                if(validateOutput.size() > 2) {
                    return validateOutput.get(2);
                } else {
                    counters.set(0, validateOutput.get(0));
                    counters.set(1, validateOutput.get(1));
                }
                i--;
            }
        }

        //check for tie
        for(i = 0 ; i < 6 ; i ++){
            for(j = 0 ; j < 7 ; j++) {
                if(board[i][j].equals(String.valueOf('.'))) {
                    return 2; // nobody won yet
                }
            }
        }
        return 3; // its a tie
    }
}

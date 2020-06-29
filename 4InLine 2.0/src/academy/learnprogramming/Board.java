package academy.learnprogramming;

public abstract class Board {
    private Gamemode gamemode;
    private static String[][] board;

    private int linesNumber;
    private int columnsNumber;

    public Board(Gamemode gamemode) {
        this.gamemode = gamemode;

        if(gamemode.getGamemode() == 1 || gamemode.getGamemode() == 3) {
            linesNumber = 3;
            columnsNumber = 3;
        } else {
            linesNumber = 6;
            columnsNumber = 7;
        }

        board = new String[linesNumber][columnsNumber];
    }

    public Gamemode getGamemode() {
        return gamemode;
    }

    public static String getBoard(int line, int col) {
        return board[line][col];
    }

    public void resetBoard() { // will reset the board to its initial state

        for(int i = 0 ; i < linesNumber ; i++) {
            for(int j = 0; j < columnsNumber ; j++) {
                board[i][j] = ".";
            }
        }
    }

    public abstract void printBoard(); // abstract class that will be implemented with respect to each board size
}

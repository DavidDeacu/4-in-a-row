package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Size size = new Size(1);
        Gamemode gamemode = new Gamemode(size, true);
        TicTacToeBoard board = new TicTacToeBoard(gamemode);
        board.resetBoard();
        board.printBoard();

        Size size2 = new Size(2);
        Gamemode gamemode2 = new Gamemode(size2, true);
        FourInLineBoard board2 = new FourInLineBoard(gamemode2);
        board2.resetBoard();
        board2.printBoard();
    }
}

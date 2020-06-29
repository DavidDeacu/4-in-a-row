package academy.learnprogramming;

public class Gamemode {
    private Size sizeOfBoard;
    private boolean isDuo; // true for 2 players ; false for 1 player vs BOT
    private int gamemode;

    public Gamemode() {}

    public Gamemode(Size sizeOfBoard, boolean isDuo) {
        this.sizeOfBoard = sizeOfBoard;
        this.isDuo = isDuo;

        if(isDuo) {
            if(sizeOfBoard.isSmallBoard()) {
                gamemode = 1; // 2 players - TicTacToe
            } else {
                gamemode = 2; // 2 players - 4 in a Line
            }
        } else {
            if(sizeOfBoard.isSmallBoard()) {
                gamemode = 3; // 1 player - TicTacToe
            } else {
                gamemode = 4; // 1 player - 4 in a Line
            }
        }
    }

    public int getGamemode() {
        return gamemode;
    }

    public Size getSizeOfBoard() {
        return sizeOfBoard;
    }

    public boolean isDuo() {
        return isDuo;
    }
}

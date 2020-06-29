package academy.learnprogramming;

public class TicTacToeBoard extends Board {
    public TicTacToeBoard(Gamemode gamemode) {
        super(gamemode);
    }

    @Override
    public void printBoard() {
        for(int i = 0 ; i < 20 ; i++) { // simulate clearScreen
            System.out.println(" ");
        }

        for(int i = 0 ; i < 3 ; i++) {
            System.out.println("|" + "     " + Board.getBoard(i,0) + "     " + Board.getBoard(i,1) + "     " + Board.getBoard(i,2) +  "     " + "|");
            if(i != 2) {
                System.out.println("|                       |");
            }
        }
        System.out.println(" _______________________ ");
        System.out.println("");
        System.out.println("      " + 1 + "     " + 2 + "     " + 3);
    }
}

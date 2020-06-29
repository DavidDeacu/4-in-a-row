package academy.learnprogramming;

public class FourInLineBoard extends Board {
    public FourInLineBoard(Gamemode gamemode) {
        super(gamemode);
    }

    @Override
    public void printBoard() {
        for(int i = 0 ; i < 20 ; i++) {
            System.out.println(" ");
        }

        for(int i = 0 ; i < 6 ; i++) {
            System.out.println("|" + "     " + Board.getBoard(i,0) + "     " + Board.getBoard(i,1) + "     " + Board.getBoard(i,2) + "     " + Board.getBoard(i,3) + "     " + Board.getBoard(i,4) + "     " + Board.getBoard(i,5) + "     " + Board.getBoard(i,6) + "     " + "|");
            if(i != 5) {
                System.out.println("|                                               |");
            }
        }
        System.out.println(" ______________________________________________ ");
        System.out.println("");
        System.out.println("      " + 1 + "     " + 2 + "     " + 3 + "     " + 4 +  "     " + 5 + "     " + 6 + "     " + 7);
    }
}

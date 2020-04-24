package academy.learnprogramming;


// in progress

public class Bot extends Player{
    private int difficulty;
//    private int wins;
//    private int losses;
//    private double winLossRatio;
//    private char symbol;

    public Bot(String name, boolean twoPlayer) {
        super(name, twoPlayer);
    }


    public int getDifficulty() {
        return difficulty;
    }

//    public int getWins() {
//        return wins;
//    }
//
//    public int getLosses() {
//        return losses;
//    }
//
//    public double getWinLossRatio() {
//        return winLossRatio;
//    }
//
//    public char getSymbol() {
//        return symbol;
//    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

//    public void setWins(int wins) {
//        this.wins = wins;
//    }
//
//    public void setLosses(int losses) {
//        this.losses = losses;
//    }
}

package academy.learnprogramming;

public class Player {
    private String name;
    private int wins;
    private int losses;
    private double winLossRatio;
    private char symbol;
    private boolean twoPlayer;

    public Player(String name, boolean twoPlayer) {
        //for player 1
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.winLossRatio = 0;
        this.twoPlayer = twoPlayer;

        if(!twoPlayer) {
            int randomNumber = (int)(Math.random() * 2) + 1;
            switch (randomNumber) {
                case 1:
                    symbol = 'X';
                    break;
                case 2:
                    symbol = 'O';
                    break;
                default:
                    System.out.println("Error code: 1 (Player class. Symbol)");
                    System.out.println("Gen number: " + randomNumber);
                    symbol = '?';
            }
        }
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public double getWinLossRatio() {
        return winLossRatio;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setWin() {
        wins ++;

        if(losses != 0) {
            winLossRatio = (double)wins/losses;
        } else {
            winLossRatio = (double)wins;
        }

    }

    public void setLoose() {
        losses ++;

        if(wins != 0) {
            winLossRatio = (double)wins/losses;
        } else {
            winLossRatio = -(double)losses;
        }
    }
}
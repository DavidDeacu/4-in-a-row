package academy.learnprogramming;

public class Size {
    private Dimensions dimensions;
    private boolean smallBoard;

    public Size(int size) {
        if(size == 1) { // 3x3 size (Tic Tac Toe)
            this.dimensions = new Dimensions(3, 3);
            this.smallBoard = true;
        } else if (size == 2) { // 6x7 size (4 in a line)
            this.dimensions = new Dimensions(6, 7);
            this.smallBoard = false;
        } else {
            System.out.println("ERROR: The size of the board can support only Tic Tac Toe or 4 In a Line");
        }
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public boolean isSmallBoard() {
        return smallBoard;
    }

    @Override
    public String toString() { // Helps for printing the dimensions of the board
        return "SizeOfBoard{" +
                " number of lines " + dimensions.getLinesNumber() +
                " number of columns " + dimensions.getColumnsNumber() +
                " }";
    }

    private static class Dimensions { // private inner class
        private int linesNumber;
        private int columnsNumber;

        private Dimensions(int linesNumber, int columnsNumber) {
            this.linesNumber = linesNumber;
            this.columnsNumber = columnsNumber;
        }

        private int getLinesNumber() {
            return linesNumber;
        }

        private int getColumnsNumber() {
            return columnsNumber;
        }
    }


}

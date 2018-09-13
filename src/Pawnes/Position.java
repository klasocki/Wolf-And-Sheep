//A pawn has a position.  A chessboard has a field

package Pawnes;

public class Position {
    private int row;
    private int col;


    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public int getRow() {
        return row;
    }

    protected void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}

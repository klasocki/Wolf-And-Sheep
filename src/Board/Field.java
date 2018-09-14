//TODO this class might use position instead of row and column
//It represents fields on a chessboard

package Board;

import javafx.scene.shape.Rectangle;

public class Field {
    protected Rectangle square;
    private int row;
    private int col;
    private boolean taken = false;

    public Field(int row, int col) {
        this.row = row;
        this.col = col;
        square = new Rectangle();
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

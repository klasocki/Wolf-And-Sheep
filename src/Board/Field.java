//TODO this class might use position instead of row and column
//It represents fields on a chessboard

package Board;

import Pieces.Piece;
import javafx.scene.shape.Rectangle;

public class Field {
    protected Rectangle viewRepresentation;
    private int row;
    private int col;
    private boolean taken = false;
    Piece piece;

    public Rectangle getViewRepresentation() {
        return viewRepresentation;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Field(int row, int col) {
        this.row = row;
        this.col = col;
        viewRepresentation = new Rectangle();
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

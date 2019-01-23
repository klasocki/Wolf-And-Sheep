
package Board;

import Pieces.PieceModel;

import java.util.ArrayList;
import java.util.List;

public class FieldModel {
    private int row;
    private int col;
    private PieceModel pieceModel;

    public FieldModel(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public List<FieldModel> getPosiibleMoves() {
        if (this.pieceModel == null) {
            return new ArrayList<>();
        }
        return this.pieceModel.getPossibleMoves();
    }

    public PieceModel getPieceModel() {
        return pieceModel;
    }

    public void setPieceModel(PieceModel pieceModel) {
        this.pieceModel = pieceModel;
    }

    public boolean isTaken() {
        return pieceModel != null;
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

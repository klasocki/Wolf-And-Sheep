
package board;

import pieces.PieceModel;

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

    public List<FieldModel> getPossibleMoves() {
        if (this.pieceModel == null) {
            return new ArrayList<>();
        }
        return this.pieceModel.getPossibleMoves();
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

    public int getCol() {
        return col;
    }

}

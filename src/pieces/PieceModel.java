package pieces;

import board.ChessboardModel;
import board.FieldModel;

import java.util.List;

public abstract class PieceModel {
    private FieldModel fieldModel;
    protected Movable movingWay;
    private ChessboardModel chessboardModel;

    public PieceModel(ChessboardModel chessboardModel) {
        this.chessboardModel = chessboardModel;
    }

    public boolean isPlaced() {
        return !(fieldModel == null);
    }

    public FieldModel getFieldModel() {
        return fieldModel;
    }

    public boolean move(FieldModel fieldModel) {
        List<FieldModel> possibleMoves = this.getPossibleMoves();
        //checking if requested move is valid for a certain piece
        if (possibleMoves.contains(fieldModel)) {
            this.fieldModel.setPieceModel(null);
            this.fieldModel = fieldModel;
            fieldModel.setPieceModel(this);
            return true;
        }
        return false;
    }

    public boolean place(FieldModel fieldModel) {
        if (this.isPlaced() || fieldModel.isTaken()) {
            return false;
        }
        fieldModel.setPieceModel(this);
        this.fieldModel = fieldModel;
        return true;
    }

    public List<FieldModel> getPossibleMoves(){
        return movingWay.getPossibleMoves(this.chessboardModel, this.fieldModel);
    }
}

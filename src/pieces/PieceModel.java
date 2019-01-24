package pieces;

import board.ChessboardModel;
import board.FieldModel;
import game.Game;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class PieceModel {
    private FieldModel fieldModel;
    protected Movable movingWay;
    private ChessboardModel chessboardModel;

    public PieceModel(ChessboardModel chessboardModel) {
        this.chessboardModel = chessboardModel;
    }

    boolean isPlaced() {
        return !(fieldModel == null);
    }

    public FieldModel getFieldModel() {
        return fieldModel;
    }

    public boolean move(FieldModel fieldModel) {
        List<FieldModel> possibleMoves = this.getPossibleMoves();
        //checking if requested move is valid for a certain piece
        if (possibleMoves.contains(fieldModel) && this.hasTurnNow() ) {
            chessboardModel.saveMove(new Game.Move(this.fieldModel, fieldModel));
            this.moveWithoutCheck(fieldModel);
            return true;
        }
        return false;
    }

    public void moveWithoutCheck(FieldModel fieldModel) {
        this.fieldModel.setPieceModel(null);
        this.fieldModel = fieldModel;
        fieldModel.setPieceModel(this);
        chessboardModel.changeTurn();
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
        if(!this.hasTurnNow()) return new ArrayList<>();
        return movingWay.getPossibleMoves(this.chessboardModel, this.fieldModel);
    }

    public boolean hasTurnNow() {
        return chessboardModel.turnOf().isInstance(this);
    }
}

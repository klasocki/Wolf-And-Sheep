package Pieces;

import Board.ChessboardModel;
import Board.FieldModel;

public class WolfModel extends PieceModel {
    public WolfModel(ChessboardModel chessboardModel) {
        super(chessboardModel);
        movingWay = new MovesBothWays();
    }
}

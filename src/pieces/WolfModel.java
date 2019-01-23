package pieces;

import board.ChessboardModel;

public class WolfModel extends PieceModel {
    public WolfModel(ChessboardModel chessboardModel) {
        super(chessboardModel);
        movingWay = new MovesBothWays();
    }
}

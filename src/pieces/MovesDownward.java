package pieces;

import board.ChessboardModel;
import board.FieldModel;

import java.util.ArrayList;

public class MovesDownward implements Movable {
    @Override
    public ArrayList<FieldModel> getPossibleMoves(ChessboardModel chessboard, FieldModel position) {
        return PossibleMovesFiller.fillPossibleMoves(chessboard, position, downRowMove);
    }
}
package pieces;

import board.ChessboardModel;
import board.FieldModel;

import java.util.ArrayList;

public class MovesBothWays implements Movable {

    @Override
    public ArrayList<FieldModel> getPossibleMoves(ChessboardModel chessboard, FieldModel position) {
        //
        Movable movesUp = new MovesUpward();
        Movable movesDown = new MovesDownward();
        ArrayList<FieldModel> upMoves = movesUp.getPossibleMoves(chessboard, position);
        ArrayList<FieldModel> downMoves = movesDown.getPossibleMoves(chessboard, position);
        ArrayList<FieldModel> result = new ArrayList<>();
        result.addAll(upMoves);
        result.addAll(downMoves);
        return result;
    }
}


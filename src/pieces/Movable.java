package pieces;

import board.ChessboardModel;
import board.FieldModel;

import java.util.ArrayList;

public interface Movable {
    ArrayList<FieldModel> getPossibleMoves(ChessboardModel chessboard, FieldModel position);

    // public void move(Position oldPosition, Position newPosition) ;


    int[] colMovesPossible = {-1, 1};

    int upRowMove = -1;
    int downRowMove = 1;

    class PossibleMovesFiller {
        static ArrayList<FieldModel> fillPossibleMoves(ChessboardModel chessboard, FieldModel position, int rowMove) {
            ArrayList<FieldModel> result = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                int row = position.getRow() + rowMove;
                int col = position.getCol() + colMovesPossible[i];
                if (chessboard.isValidMove(row, col))
                    result.add(chessboard.getField(row, col));
            }
            return result;
        }
    }
}






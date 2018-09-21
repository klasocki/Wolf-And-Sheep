package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;

public interface Movable {
    ArrayList<Field> getPossibleMoves(Field position);

    // public void move(Position oldPosition, Position newPosition) ;


    final int[] colMmovesPossible = {-1, 1};

    final int upRowMove = -1;
    final int downRowMove = 1;
    final int chessboardSize = 8;

    class PossibleMovesFiller {
        static ArrayList<Field> fillPossibleMoves(Field position, int rowMove) {
            ArrayList<Field> result = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                int row = position.getRow() + rowMove;
                int col = position.getCol() + colMmovesPossible[i];
                if (Chessboard.isValidMove(row, col))
                    result.add(Chessboard.getField(row, col));
            }
            return result;
        }
    }
}






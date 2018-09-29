package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;

public interface Movable {
    ArrayList<Field> getPossibleMoves(Field position);

    // public void move(Position oldPosition, Position newPosition) ;


    int[] colMovesPossible = {-1, 1};

    int upRowMove = -1;
    int downRowMove = 1;

    class PossibleMovesFiller {
        static ArrayList<Field> fillPossibleMoves(Field position, int rowMove) {
            ArrayList<Field> result = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                int row = position.getRow() + rowMove;
                int col = position.getCol() + colMovesPossible[i];
                if (Chessboard.isValidMove(row, col))
                    result.add(Chessboard.getField(row, col));
            }
            return result;
        }
    }
}






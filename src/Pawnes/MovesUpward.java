package Pawnes;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;

public class MovesUpward implements Movable {

    @Override
    public ArrayList<Field> getPossibleMoves(Field position) {
        ArrayList<Field> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int row = position.getRow() + upRowMove;
            int col = position.getCol() + colMmovesPossible[i];
            if (Chessboard.isValidMove(row, col))
                result.add(Chessboard.getField(row, col));
        }
        return result;
    }
}
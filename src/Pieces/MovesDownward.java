package Pieces;

import Board.Field;

import java.util.ArrayList;

public class MovesDownward implements Movable {
    @Override
    public ArrayList<Field> getPossibleMoves(Field position) {
        return PossibleMovesFiller.fillPossibleMoves(position, downRowMove);
    }
}
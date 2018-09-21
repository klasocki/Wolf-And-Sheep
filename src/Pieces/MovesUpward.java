package Pieces;

import Board.Field;

import java.util.ArrayList;

public class MovesUpward implements Movable {

    @Override
    public ArrayList<Field> getPossibleMoves(Field position) {
        return PossibleMovesFiller.fillPossibleMoves(position, upRowMove);
    }
}
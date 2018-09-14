package Pawnes;

import Board.Field;

import java.util.ArrayList;

public class MovesBothWays implements Movable {

    @Override
    public ArrayList<Field> getPossibleMoves(Field position) {
        //
        Movable movesUp = new MovesUpward();
        Movable movesDown = new MovesDownward();
        ArrayList<Field> upMoves = movesUp.getPossibleMoves(position);
        ArrayList<Field> downMoves = movesDown.getPossibleMoves(position);
        ArrayList<Field> result = new ArrayList<>();
        result.addAll(upMoves);
        result.addAll(downMoves);
        return result;
    }
}


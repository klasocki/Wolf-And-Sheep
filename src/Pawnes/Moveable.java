package Pawnes;

import java.util.ArrayList;

public interface Moveable {
    ArrayList<Position> getPossibleMoves(Position position);

    // public void move(Position oldPosition, Position newPosition) ;


    final int[] colMmove = {-1, 1};
    final int upRowMove = 1;
    final int downRowMove = -1;
    final int chessboardSize = 8;

}

class MovesUpward implements Moveable {


    @Override
    public ArrayList<Position> getPossibleMoves(Position position) {
        ArrayList<Position> result = new ArrayList<>(2);

        return null;
    }
}


class MovesDownward implements Moveable {


    @Override
    public ArrayList<Position> getPossibleMoves(Position position) {
        return null;
    }


}

class MovesBothWays implements Moveable {


    @Override
    public ArrayList<Position> getPossibleMoves(Position position) {
        return null;
    }


}

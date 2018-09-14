package Pawnes;

import Board.Field;

import java.util.ArrayList;

public interface Movable {
    ArrayList<Field> getPossibleMoves(Field position);

    // public void move(Position oldPosition, Position newPosition) ;


    final int[] colMmovesPossible = {-1, 1};

    final int upRowMove = 1;
    final int downRowMove = -1;
    final int chessboardSize = 8;

}





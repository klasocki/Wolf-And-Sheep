package Pieces;

import Board.Chessboard;
import Board.ChessboardView;
import Board.Field;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public abstract class Piece {

    private Field field;
    public Movable movingWay;
    private Circle viewRepresentation;

    public boolean isPlaced() {
        return !(field == null);
    }

    public Field getField() {
        return field;
    }

    public void move(Field field) {
        ArrayList<Field> possibleMoves = movingWay.getPossibleMoves(this.field);
        //checking if requested move is valid for a certain piece
        if (possibleMoves.contains(field)) {
            this.field.setTaken(false);
            this.field = field;
            field.setTaken(true);
            field.setPiece(this);
            ChessboardView.movePiece(viewRepresentation, field);
        }
    }

    public Circle getViewRepresentation() {
        return viewRepresentation;
    }

    public void setViewRepresentation(Circle viewRepresentation) {
        this.viewRepresentation = viewRepresentation;
    }

    public void placePiece(int row, int col) {
        ChessboardView.placePiece(this, Chessboard.getField(row, col));
        field = Chessboard.getField(row, col);
        field.setPiece(this);
        field.setTaken(true);
    }
}

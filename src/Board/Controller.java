package Board;

import Pieces.Movable;
import Pieces.Piece;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class Controller {

    public static void addEventHandlers(Field field) {
        field.viewRepresentation.setOnMouseEntered(event -> Controller.mouseEntered(field));
        field.viewRepresentation.setOnMouseExited(event -> Controller.mouseExited(field));
        field.viewRepresentation.setOnMouseClicked(event -> Controller.mouseClicked(field));
    }

    public static void addEventHandlers(Piece piece) {

        piece.getViewRepresentation().setOnMouseEntered(event -> Controller.mouseEntered(piece.getField()));
        piece.getViewRepresentation().setOnMouseExited(event -> Controller.mouseExited(piece.getField()));
        piece.getViewRepresentation().setOnMouseClicked(event -> Controller.mouseClicked(piece.getField()));
    }

    public static void mouseExited(Field field) {
        Color current = Color.valueOf(field.getViewRepresentation().getFill().toString());
        field.getViewRepresentation().setFill(current.darker());
        if (field.isTaken()) {
            Circle piece = field.getPiece().getViewRepresentation();
            Color pieceCurrent = Color.valueOf(piece.getFill().toString());
            piece.setFill(pieceCurrent.darker());
        }
    }

    public static void mouseEntered(Field field) {
        Color current = Color.valueOf(field.getViewRepresentation().getFill().toString());
        field.getViewRepresentation().setFill(current.brighter());
        if (field.isTaken()) {
            Circle piece = field.getPiece().getViewRepresentation();
            Color pieceCurrent = Color.valueOf(piece.getFill().toString());
            piece.setFill(pieceCurrent.brighter());
        }
    }


    public static void mouseClicked(Field fieldClicked) {
        if (!fieldClicked.isTaken() && Chessboard.getFieldSelected() != null) {
            //If field clicked is a possible move, it does it, else it unselects current filed
            moveSelectedPiece(fieldClicked);
        } else if (fieldClicked.isTaken()) {
            //So, every time you click on a taken field, you select piece you want to move
            if (fieldClicked == Chessboard.getFieldSelected())
                unselectField(null);
            else
                selectPieceToMove(fieldClicked);
        }
    }

    private static void moveSelectedPiece(Field destination) {
        Piece pieceToMove = Chessboard.getFieldSelected().getPiece();
        Movable moveWay = pieceToMove.movingWay;
        ArrayList<Field> moves = moveWay.getPossibleMoves(Chessboard.getFieldSelected());
        unselectField(moves);
        if (moves.contains(destination)) {
            pieceToMove.move(destination);
        }
    }

    private static void unselectField(ArrayList<Field> moves) {
        //This function is designed to work with and without the moves list
        Field field = Chessboard.getFieldSelected();
        if (field == null) return;
        if (moves == null) {
            moves = field.getPiece().movingWay.getPossibleMoves(field);
        }
        for (Field f : moves) {
            f.getViewRepresentation().setFill(ChessboardView.playable);
        }
        field.getViewRepresentation().setFill(ChessboardView.playable);
        Chessboard.setFieldSelected(null);
    }

    private static void selectPieceToMove(Field field) {
        unselectField(null);
        Movable moveWay = field.getPiece().movingWay;
        ArrayList<Field> moves = moveWay.getPossibleMoves(field);
        if (moves.size() == 0) return;
        for (Field f : moves) {
            f.viewRepresentation.setFill(Color.GREEN);
        }
        Chessboard.setFieldSelected(field);
        field.getViewRepresentation().setFill(Color.GOLD);
    }

}

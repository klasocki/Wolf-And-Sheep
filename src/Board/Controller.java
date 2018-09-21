package Board;

import Pieces.Movable;
import Pieces.Piece;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class Controller {

    public static void mouseExited(Rectangle rectangle) {
        Color current = Color.valueOf(rectangle.getFill().toString());
        rectangle.setFill(current.darker());

    }

    public static void mouseEntered(Rectangle rectangle) {
        Color current = Color.valueOf(rectangle.getFill().toString());
        rectangle.setFill(current.brighter());
    }

    public static void mouseClicked(Field fieldClicked) {
        if (!fieldClicked.isTaken() && Chessboard.getFieldSelected() != null) {
            //If field clicked is a possible move it does it, else it unselects current filed
            moveSelectedPiece(fieldClicked);
        } else if (fieldClicked.isTaken()) {
            //So, every time you click on a taken field, you select piece you want to move
            selectPieceToMove(fieldClicked);
        }
    }

    private static void moveSelectedPiece(Field destination) {
        Piece pieceToMove = Chessboard.getFieldSelected().getPiece();
        Movable moveWay = pieceToMove.movingWay;
        ArrayList<Field> moves = moveWay.getPossibleMoves(Chessboard.getFieldSelected());
        for (Field f : moves) {
            f.getViewRepresentation().setFill(ChessboardView.playable);
        }
        Chessboard.getFieldSelected().getViewRepresentation().setFill(ChessboardView.playable);
        if (moves.contains(destination)) {
            pieceToMove.move(destination);
        }
        Chessboard.setFieldSelected(null);
    }

    private static void selectPieceToMove(Field field) {
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

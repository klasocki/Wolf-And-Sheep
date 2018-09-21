package Board;

import Pieces.Piece;
import Pieces.Wolf;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class ChessboardView {
    private static GridPane chessboardView;
    static final Color nonPlayable = Color.BISQUE;
    static final Color playable = Color.valueOf("#383838");
    static final Color wolfColor = Color.GREENYELLOW;
    static final Color sheepColor = Color.LIGHTGREY;

    public static GridPane draw() {
        int size = Chessboard.chessboard.length;
        chessboardView = new GridPane();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle currentField = Chessboard.chessboard[row][col].viewRepresentation;
                Color color;
                if ((row + col) % 2 == 0) color = nonPlayable;
                else color = playable;

                currentField.setFill(color);
                chessboardView.add(currentField, col, row);
                currentField.widthProperty().bind(chessboardView.widthProperty().divide(size));
                currentField.heightProperty().bind(chessboardView.heightProperty().divide(size));
            }
        }
        return chessboardView;
    }

    public static void placePiece(Piece piece, Field field) {
        if (piece.isPlaced()) {
            movePiece(piece.getViewRepresentation(), field);
            return;
        }
        int size = Chessboard.chessboard.length;
        Circle circle = new Circle();
        circle.setFill((piece.getClass() == Wolf.class) ? wolfColor : sheepColor);
        circle.radiusProperty().bind(chessboardView.widthProperty().divide(size * 2 + 1));
        piece.setViewRepresentation(circle);
        chessboardView.add(circle, field.getCol(), field.getRow());
    }

    public static void movePiece(Circle piece, Field field) {
        chessboardView.getChildren().remove(piece);
        chessboardView.add(piece, field.getCol(), field.getRow());
    }


}

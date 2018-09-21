package Board;

import Pieces.Piece;
import Pieces.Wolf;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class ChessboardView {
    private static GridPane chessboardView;
    static Color nonPlayable = Color.BISQUE;
    static Color playable = Color.valueOf("#383838");
    private static Color wolfColor = Color.GREENYELLOW;

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
        int size = Chessboard.chessboard.length;
        Circle circle = new Circle();
        if (piece.getClass() == Wolf.class) circle.setFill(wolfColor);
        circle.radiusProperty().bind(chessboardView.widthProperty().divide(size * 2 + 1));
        piece.setViewRepresentation(circle);

        chessboardView.add(circle, field.getCol(), field.getRow());
    }

    public static void movePiece(Circle piece, Field field) {
        chessboardView.getChildren().remove(piece);
        chessboardView.add(piece, field.getCol(), field.getRow());
    }


}

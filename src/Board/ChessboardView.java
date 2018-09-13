package Board;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessboardView {
    private static Rectangle[][] chessboard;
    private static ChessboardView instance = null;
    private static GridPane chessboardView;

    private ChessboardView(Rectangle[][] board) {
        chessboard = board;
        chessboardView = new GridPane();
    }

    public static GridPane draw(Color nonPlayable, Color playable) {
        int size = chessboard.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle currentField = chessboard[row][col];
                Color color;
                if ((row + col) % 2 == 0) color = nonPlayable;
                else {
                    color = playable;
                }
                currentField.setFill(color);
                chessboardView.add(currentField, col, row);
                currentField.widthProperty().bind(chessboardView.widthProperty().divide(size));
                currentField.heightProperty().bind(chessboardView.heightProperty().divide(size));
            }
        }
        return chessboardView;
    }

    public static ChessboardView getInstance(Rectangle[][] board) {
        //You cannot modify the chessboard Model - it is "final", can only be set at the first time
        if (instance == null) {
            instance = new ChessboardView(board);
        }
        return instance;
    }
}

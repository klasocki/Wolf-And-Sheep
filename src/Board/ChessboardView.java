package Board;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class ChessboardView {
    private static ChessboardView instance = new ChessboardView();

    private ChessboardView() {
    }

    public static GridPane draw(Color nonPlayable, Color playable) {
        int size = Chessboard.chessboard.length;
        GridPane chessboardView = new GridPane();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle currentField = Chessboard.chessboard[row][col].square;
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

    public static ChessboardView getInstance() {
        if (instance == null) {
            instance = new ChessboardView();
        }
        return instance;
    }
}

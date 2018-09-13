package Board;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Chessboard {
    final int size = 8;

    private Chessboard() {
        chessboard = new Rectangle[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessboard[i][j] = new Rectangle();
            }
        }
    }

    private static final Chessboard instance = new Chessboard();
    private static Rectangle[][] chessboard;

    public static Chessboard getInstance() {
        return instance;
    }
}

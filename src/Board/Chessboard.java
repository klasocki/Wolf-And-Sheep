//This is the Model for the Chessboard. Using Singleton pattern
package Board;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Chessboard {
    final int size = 8;
    private static Rectangle[][] chessboard;
    private static final Chessboard instance = new Chessboard();
    private static boolean WolfsTurn = true; //Wolf starts the game

    private Chessboard() {
        //Filling the chessboard with Rectangles
        chessboard = new Rectangle[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessboard[i][j] = new Rectangle();
            }
        }
    }

    public static GridPane draw(Color nonPlayable, Color playable) {
        ChessboardView view = ChessboardView.getInstance(chessboard);
        return view.draw(nonPlayable, playable);
    }

    public static Chessboard getInstance() {
        return instance;
    }

    public static boolean wolfsTurn() {
        return WolfsTurn;
    }

    public static void changeTurn() {
        WolfsTurn = !WolfsTurn;
    }
}

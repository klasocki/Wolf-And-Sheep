//This is the Model for the Chessboard. Using Singleton pattern

package Board;

import javafx.scene.shape.Rectangle;


public class Chessboard {
    final int size = 8;

    private Chessboard() {
        //Filling the chessboard with Rectangles
        chessboard = new Rectangle[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessboard[i][j] = new Rectangle();
            }
        }
    }

    private static final Chessboard instance = new Chessboard();
    private static Rectangle[][] chessboard;
    private static boolean WolfsTurn = true; //Wolf starts the game
    
    public static Chessboard getInstance() {
        return instance;
    }

    public static boolean WolfsTurn() {
        return WolfsTurn;
    }

    public static void changeTurn() {
        WolfsTurn = !WolfsTurn;
    }
}

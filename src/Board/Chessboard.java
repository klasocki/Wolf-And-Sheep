//This is the Model for the Chessboard. Using Singleton pattern
package Board;

public class Chessboard {
    protected final static int size = 8;
    protected static Field[][] chessboard;
    private static final Chessboard instance = new Chessboard();
    private static boolean WolfsTurn = true; //Wolf starts the game

    private Chessboard() {
        //Filling the chessboard with Rectangles
        chessboard = new Field[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessboard[i][j] = new Field(i, j);
            }
        }
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

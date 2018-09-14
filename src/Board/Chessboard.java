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
                if ((i + j) % 2 == 1) {
                    addEventhandlers(chessboard[i][j]);
                }
            }
        }
    }

    private void addEventhandlers(Field field) {
        field.square.setOnMouseEntered(event -> Controller.mouseEntered(field.square));
        field.square.setOnMouseExited(event -> Controller.mouseExited(field.square));
        field.square.setOnMouseClicked(event -> Controller.mouseClicked(field));
    }

    public static boolean isTakenField(int row, int col) {
        return chessboard[row][col].isTaken();
    }

    public static boolean isValidMove(int row, int col) {
        return ((0 <= col) && (col < Chessboard.size) &&
                (0 <= row) && (row < Chessboard.size) &&
                !(chessboard[row][col].isTaken()));
    }

    public static Field getField(int row, int col) {
        return chessboard[row][col];
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

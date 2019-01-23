package Board;

public class ChessboardModel {
    public final static int size = 8;
    protected FieldModel[][] chessboard;
    private boolean WolfsTurn = true; //WolfModel starts the game
    private FieldModel fieldModelSelected = null;

    public FieldModel getFieldModelSelected() {
        return fieldModelSelected;
    }

    public void setFieldModelSelected(FieldModel fieldModelSelected) {
        this.fieldModelSelected = fieldModelSelected;
    }


    ChessboardModel() {
        //Filling the chessboard with Rectangles
        chessboard = new FieldModel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessboard[i][j] = new FieldModel(i, j);
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return ((0 <= col) && (col < ChessboardModel.size) &&
                (0 <= row) && (row < ChessboardModel.size) &&
                !(chessboard[row][col].isTaken()));
    }

    public FieldModel getField(int row, int col) {
        return chessboard[row][col];
    }

    public boolean wolfsTurn() {
        return WolfsTurn;
    }

    public void changeTurn() {
        WolfsTurn = !WolfsTurn;
    }
}

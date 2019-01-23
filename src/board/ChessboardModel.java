package board;

import game.Game;

public class ChessboardModel {
    public final static int size = 8;
    protected FieldModel[][] chessboard;
    private FieldModel fieldModelSelected = null;
    private Game game = new Game();

    public FieldModel getFieldModelSelected() {
        return fieldModelSelected;
    }

    public void setFieldModelSelected(FieldModel fieldModelSelected) {
        this.fieldModelSelected = fieldModelSelected;
    }

    public Class turnOf() {
        return game.turnOf();
    }

    public void changeTurn() {
        game.changeTurn();
    }

    public ChessboardModel() {
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

}

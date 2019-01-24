package board;

import game.Game;

public class ChessboardModel {
    public final static int size = 8;
    private FieldModel[][] chessboard;
    private FieldModel fieldModelSelected = null;
    private Game game = new Game();

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

    public void saveMove(Game.Move move) {
        game.saveMove(move);
    }

    public Game.Move popMove() {
        return game.popMove();
    }

    public boolean canUndo() {
        return game.canUndo();
    }

    public void setSheepMoveUp(boolean sheepMoveUp) {
        this.game.sheepMoveUp = sheepMoveUp;
    }
}

package board;

import pieces.PieceView;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ChessboardView {
    private GridPane chessboardGrid;
    private FieldView[][] chessboard;
    final int size;
    final static Color nonPlayable = Color.BISQUE;
    final static Color playable = Color.valueOf("#383838");
    final static Color prompt = Color.GREEN;
    final static Color selected = Color.GOLD;
    public final static Color wolfColor = Color.CHOCOLATE;
    public final static Color sheepColor = Color.LIGHTGREY;

    public ChessboardView(ChessboardModel chessboardModel) {
        this.size = ChessboardModel.size;
        chessboard = new FieldView[size][size];
        chessboardGrid = new GridPane();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                FieldView currentField = new FieldView(
                        chessboardModel.getField(row, col), this, chessboardModel
                        );
                chessboardGrid.add(currentField.getViewRepresentation(), col, row);
                chessboard[row][col] = currentField;
            }
        }
    }

    public FieldView getFieldView(FieldModel fieldModel) {
        return chessboard[fieldModel.getRow()][fieldModel.getCol()];
    }

    public void movePiece(PieceView piece, int col, int row) {
        Circle pieceView = piece.getViewRepresentation();
        chessboardGrid.getChildren().remove(pieceView);
        chessboardGrid.add(pieceView, col, row);
    }

    public void addPiece(Circle piece, int col, int row) {
        chessboardGrid.add(piece, col, row);
    }

    public GridPane getChessboardGrid() {
        return chessboardGrid;
    }

    public DoubleBinding getPieceRadiusProperty(){
        return chessboardGrid.widthProperty().divide(size * 2 + 1);
    }
}

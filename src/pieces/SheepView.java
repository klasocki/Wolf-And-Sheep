package pieces;

import board.ChessboardView;

public class SheepView extends PieceView {
    public SheepView(PieceModel pieceModel, ChessboardView chessboardView) {
        super(pieceModel, chessboardView);
        this.viewRepresentation.setFill(ChessboardView.sheepColor);
    }
}

package pieces;

import board.ChessboardView;

class SheepView extends PieceView {
    SheepView(PieceModel pieceModel, ChessboardView chessboardView) {
        super(pieceModel, chessboardView);
        this.viewRepresentation.setFill(ChessboardView.sheepColor);
    }
}

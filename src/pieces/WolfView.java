package pieces;

import board.ChessboardView;

class WolfView extends PieceView {
    WolfView(PieceModel pieceModel, ChessboardView chessboardView) {
        super(pieceModel, chessboardView);
        this.viewRepresentation.setFill(ChessboardView.wolfColor);
    }
}
